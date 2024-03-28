package dev.arzak21st.loginapp.models;

import java.sql.Date;
import java.util.Objects;

public class User {

    /* ========== PROPRTIES ========== */
    private Integer userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String country;

    /* ========== CONSTRUCTORS ========== */
    public User() {

    }

    public User(String firstName, String lastName, Date dateOfBirth, String gender, String country) {

        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setCountry(country);
    }

    public User(Integer userId, String firstName, String lastName, Date dateOfBirth, String gender, String country) {

        setUserId(userId);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setCountry(country);
    }

    /* ========== GETTERS & SETTERS ========== */
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /* ========== OTHER METHODS ========== */
    @Override
    public boolean equals(Object obj) {

        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        final User other = (User) obj;

        if(!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if(!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if(!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if(!Objects.equals(this.country, other.country)) {
            return false;
        }
        if(!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }
}
