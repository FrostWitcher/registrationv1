package com.api.payload;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegistrationDto {


    @NotEmpty
    @Size(min=2, message = "Min should be 2 letters")
    private String name;
    @Email
    private String email;
    @Size(min=10,max=10,message = "Should be 10 digits")
    private String mobile;


    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}