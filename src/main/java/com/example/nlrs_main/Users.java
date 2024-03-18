package com.example.nlrs_main;

import java.util.Scanner;

public class Users {
    String userName;
    String firstName;
    boolean success = false;
    String lastName;
    String password;
    int userID;
    int contact;
    String userType;
    String dateOfBirth;
    String email;
    String country;

    public void setUser(int newUserID,String newUserType,String newUserName, String newPassword,String newFirstName, String newLastName,String newDateOfBirth,
                        int newContact, String newEmail,String newCountry){
        this.userName = newUserName;
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.password = newPassword;
        this.userID = newUserID;
        this.contact = newContact;
        this.userType = newUserType;
        this.dateOfBirth = newDateOfBirth;
        this.email = newEmail;
        this.country = newCountry;
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }
    public String getUserName() {
        return userName;
    }
    public void setFirstName(String newFirstName) {
        this.userName = newFirstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getUserID() {
        return userID;
    }
    public void setIfSuccessful(boolean succeeded) {
        this.success = succeeded;
    }
    public void setContact(int contact) {
        this.contact = contact;
    }
    public int getContact() {
        return contact;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserType(){
        return userType;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCountry() {
        return country;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
}
