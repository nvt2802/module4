package com.example.validate_song.controller;

import com.example.validate_song.dto.SongDto;
import com.example.validate_song.model.Song;
import com.example.validate_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @RequestMapping("/song")
    public ModelAndView showSong(){
        ModelAndView modelAndView = new ModelAndView("list");
        List<Song> songList = songService.getAll();
        modelAndView.addObject("list",songList);
        return modelAndView;
    }
    @RequestMapping("/create")
    public String showFormCreate(Model model){
        SongDto songDto = new SongDto();
        model.addAttribute("songDto",songDto);
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid@ModelAttribute SongDto songDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        Song song = new Song();
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        BeanUtils.copyProperties(songDto,song);
        songService.add(song);
        redirectAttributes.addFlashAttribute("msg","add successful");
        return "redirect:/song";
    }
    @RequestMapping("/update/{id}")
    public String showFormUpdate(Model model, @PathVariable int id){
        Song song = songService.getById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        model.addAttribute("id",song.getId());
        return "update";
    }
    @PostMapping("/update")
    public String update(@Valid@ModelAttribute SongDto songDto,@RequestParam int id, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        Song song = new Song();
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "update";
        }
        BeanUtils.copyProperties(songDto,song);
        song.setId(id);
        songService.add(song);
        redirectAttributes.addFlashAttribute("msg","update successful");
        return "redirect:/song";
    }
}
