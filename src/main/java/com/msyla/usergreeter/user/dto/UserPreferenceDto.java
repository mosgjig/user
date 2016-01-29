package com.msyla.usergreeter.user.dto;

import java.io.Serializable;
import org.springframework.hateoas.ResourceSupport;

public class UserPreferenceDto extends ResourceSupport implements Serializable{

    private static final long serialVersionUID = -3745911724970637802L;

    private Long key;
    private String firstName;
    private String lastName;
    private String season;

    public UserPreferenceDto() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "UserPreferenceDto{" + "id=" + key + ", firstName=" + firstName + ", lastName=" + lastName + ", season=" + season + '}';
    }
}
