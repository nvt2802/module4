package com.example.controller;

import com.example.model.Settings;
import com.example.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailboxController {
    @Autowired
    private ISettingsService settingsService;
    @RequestMapping("/info")
    public String showForm(Model model){
        model.addAttribute("settings",settingsService.getSettings());
        return "info";
    }
    @RequestMapping("/update")
    public String showUpdate(Model model){
        Settings settings=settingsService.getSettings();
        model.addAttribute("settings",settings);
        return "update";
    }
    @ModelAttribute("language")
    public String[] getLanguages(){
        return new String[]{"English","Japan","Chinese","Vietnamese"};
    }
    @ModelAttribute("pageSizes")
    public int[] getPageSize(){
        return new int[]{5,10,15,25,50,100};
    }
    @PostMapping("/update")
    public String updateSettings(@ModelAttribute Settings settings, RedirectAttributes redirectAttributes){
        settingsService.update(settings);
        redirectAttributes.addFlashAttribute("msg","update successful");
        return "redirect:/info";
    }
}
