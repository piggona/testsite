package com.kevinmvc.testsite.Profile;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfileForm {

    @Size(min=2)
    private String twitterHandle;

    @Email
    @NotEmpty
    private String email;
    @NotNull
    private LocalDate birthDate;
    @NotEmpty
    private List<String> taste =new ArrayList<>();

    public List<String> getTaste() {
        return taste;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTaste(List<String> taste) {
        this.taste = taste;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }
}
