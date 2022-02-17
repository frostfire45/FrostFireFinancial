package com.frostfirecompx.financial;


import com.frostfirecompx.financial.controller.HomeController;
import com.frostfirecompx.financial.domain.accounting.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FrostFireFinancialApplicationTests  {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private HomeController controller;

    @Test
    public void AddNewAccountPosted() throws Exception {

        Account accnt = new Account();
        accnt.setAccount_Id(1);
        accnt.setAccountName("Chase");
        accnt.setAccountNumber("234");
        accnt.setPay_info(null);
        accnt.setContact(null);

        mvc.perform(post("Account/newAccount").contentType(MediaType.APPLICATION_JSON).content(String.valueOf(accnt)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
