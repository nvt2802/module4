package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    private static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("Hello", "Xin chào");
        dictionary.put("Apple", "Táo");
        dictionary.put("Banana", "Chuối");
        dictionary.put("Toy", "Đồ chơi");
        dictionary.put("Queen", "Hoàng Thị Quyên");
        dictionary.put("Sex", "Giới tính");
        dictionary.put("Car", "Xe hơi");
        dictionary.put("Table", "Bàn");
        dictionary.put("Chair", "Ghế");
        dictionary.put("Book", "Sách");
        dictionary.put("Computer", "Máy tính");
        dictionary.put("Phone", "Điện thoại");
        dictionary.put("Water", "Nước");
        dictionary.put("Coffee", "Cà phê");
        dictionary.put("Television", "Ti vi");
        dictionary.put("Music", "Âm nhạc");
        dictionary.put("Movie", "Phim");
        dictionary.put("House", "Nhà");
        dictionary.put("School", "Trường học");
        dictionary.put("Student", "Học sinh");
        dictionary.put("Teacher", "Giáo viên");
        dictionary.put("Hospital", "Bệnh viện");
        dictionary.put("Doctor", "Bác sĩ");
        dictionary.put("Engineer", "Kỹ sư");
        dictionary.put("Lawyer", "Luật sư");
        dictionary.put("Police", "Cảnh sát");
    }

    @PostMapping("/Translate")
    public String translate(@RequestParam String english, Model model) {
        String vietnamese ="";
        for (String str : dictionary.keySet()) {
            if (english.trim().equalsIgnoreCase(str)) {
               vietnamese = dictionary.get(str);
            }
        }
        if(vietnamese.equals("")){
            model.addAttribute("vietnamese", "Không tìm thấy trong từ điển");
        }else {
            model.addAttribute("vietnamese", vietnamese);
        }
        return "app";
    }

    @GetMapping("/Translate")
    public String showForm() {
        return "app";
    }
}
