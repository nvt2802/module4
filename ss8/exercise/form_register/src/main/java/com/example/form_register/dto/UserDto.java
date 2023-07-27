package com.example.form_register.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDto implements Validator {

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "số lượng kí tự từ 5 đến 45")
    private String firstName;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "số lượng kí tự từ 5 đến 45")
    private String lastName;
    private String phoneNumber;
    @Min(18)
    private int age;
    @NotBlank(message = "Không được để trống")
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String number = userDto.getPhoneNumber();
        if (Objects.equals(number, "")) {
            ValidationUtils.rejectIfEmpty(errors, "phoneNumber", null, "Không được để trống");
        }else if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("phoneNumber", null, "Phải có 10-11 số");
        } else if (!number.startsWith("0")) {
            errors.rejectValue("phoneNumber", null, "Bắt đầu bằng 0");
        } else if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", null, "SĐT không đúng");
        }
    }
}
