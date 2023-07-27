package com.example.validate_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private String name;
    private String singer;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if(songDto.getName().equals("")){
            errors.rejectValue("name",null,"name í empty");
        } else if (songDto.getName().length()>80) {
            errors.rejectValue("name",null,"Length name to long than 80");
        } else if(!songDto.getName().matches("^[a-zA-Z\\s]+$")){
            errors.rejectValue("name",null,"a-zA-Z0-9");
        }
        if(songDto.getSinger().equals("")){
            errors.rejectValue("name",null,"name í empty");
        } else if (songDto.getSinger().length()>80) {
            errors.rejectValue("name",null,"Length name to long than 80");
        } else if(!songDto.getSinger().matches("^^[a-zA-Z\\s]+$")){
            errors.rejectValue("name",null,"a-zA-Z0-9");
        }
        if(songDto.getType().equals("")){
            errors.rejectValue("name",null,"name í empty");
        } else if (songDto.getType().length()>80) {
            errors.rejectValue("name",null,"Length name to long than 80");
        } else if(!songDto.getType().matches("^^[a-zA-Z,\\s]+$")){
            errors.rejectValue("name",null,"a-zA-Z0-9");
        }
     }
}
