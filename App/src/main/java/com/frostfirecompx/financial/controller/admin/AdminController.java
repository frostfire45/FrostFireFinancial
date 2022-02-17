package com.frostfirecompx.financial.controller.admin;

import com.frostfirecompx.financial.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
    @Autowired
    FileService fileService;

    @GetMapping("/account/admin")
    public String index(){
        return "upload";
    }

    @PostMapping("/account/admin/uploadFile") @ResponseBody
    public String uploadFile(
            @RequestParam("file") MultipartFile file,
             RedirectAttributes redirectAttributes){
        fileService.uploadFile(file);

        redirectAttributes.addFlashAttribute(
                "message",
                "You successfully uploaded "
                + file.getOriginalFilename() + "!");

        return "File Created";
    }
}
