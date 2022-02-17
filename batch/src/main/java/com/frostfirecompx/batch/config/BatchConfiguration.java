package com.frostfirecompx.batch.config;

import com.frostfirecompx.financial.domain.accounting.Account;
import com.frostfirecompx.batch.AccountItemProcessor;
import com.frostfirecompx.batch.JobCompletionNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Value("${batch.account}")
    private String accountInsert;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Account> reader(){
       /* FlatFileItemReader<Account> ffir = new FlatFileItemReader<Account>();

        ffir.setName("accountItemReader");
        ffir.setResource(new ClassPathResource("Account.csv"));
        FlatFileItemReaderBuilder.DelimitedBuilder<Account> adb = new FlatFileItemReaderBuilder.DelimitedBuilder<Account>(ffir);
        adb.delimiter(",");

        */
        return new FlatFileItemReaderBuilder<Account>()
                .name("accountItemReader")
                .resource(new ClassPathResource("Account.csv"))
                .delimited()
                .names(new String[]{
                        "account_Id",
                        "accountName",
                        "accountNumber",
                        "pay_info",
                        "contact",
                        "category"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Account>(){
                    {
                        setTargetType(Account.class);
                    }
                })
                .build();
    }
    @Bean
    public AccountItemProcessor processor(){
        return new AccountItemProcessor();
    }
    @Bean
    public JdbcBatchItemWriter<Account> writer(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Account>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(accountInsert)
                .dataSource(dataSource)
                .build();
    }
    @Bean
    public Job importAccountJob(JobCompletionNotificationListener listener, Step step1){
        return jobBuilderFactory.get("importAccountJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }
    @Bean
    public Step step1(JdbcBatchItemWriter<Account> writer){
        return stepBuilderFactory.get("step1")
                .<Account,Account> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
