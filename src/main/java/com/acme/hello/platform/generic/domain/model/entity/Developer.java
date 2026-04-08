package com.acme.hello.platform.generic.domain.model.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Represents a Developer entity in the 'Generic' bounded context.
 *
 * @version 1.0.0
 */
@Getter
@Builder
public class Developer {
    private final UUID id = UUID.randomUUID();
    @Setter
    private String firstName;
    @Setter
    private String lastName;


    /**
     * Private constructor to enforce trimming of name fields.
     *
     * @param firstName the developer's first name.
     * @param lastName  the developer's last name.
     */
    private Developer(String firstName, String lastName) {
        this.firstName = StringUtils.trimToEmpty(firstName);
        this.lastName = StringUtils.trimToEmpty(lastName);
    }

    /**
     * Returns the full name concatenating first and last names with space.
     * @return the full name as a string.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Checks if either the first name or last name is blank.
     * @return true if any name is blank.
     */
    public boolean isAnyNameBlank() {
        return StringUtils.isAnyBlank(firstName, lastName);
    }

    /**
     * Checks if either the first name or last name is empty.
     * @return true if any name is empty.
     */
    public boolean isAnyNameEmpty() {
        return StringUtils.isAnyEmpty(firstName, lastName);
    }
}
