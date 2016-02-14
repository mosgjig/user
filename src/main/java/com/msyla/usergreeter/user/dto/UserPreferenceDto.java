/*
 * The MIT License
 *
 * Copyright 2016 Modest Syla.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.msyla.usergreeter.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.hateoas.ResourceSupport;

public class UserPreferenceDto extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -3745911724970637802L;

    private Long key;

    @NotNull(message = "{userPreferences.firstName.null}")
    @Size(min = 1, max = 45, message = "{userPreferences.firstName.size}")
    private String firstName;

    @NotNull(message = "{userPreferences.lastName.null}")
    @Size(min = 1, max = 45, message = "{userPreferences.lastName.size}")
    private String lastName;

    @NotNull(message = "{userPreferences.season.null}")
    @Size(min = 1, max = 45, message = "{userPreferences.season.size}")
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
