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
    String courseName;
    boolean userStatus;


    public void setUsers(int newUserID,String newUserType,String newUserName, String newPassword,String newFirstName, String newLastName,String newDateOfBirth,
                         String newEmail, int newContact, String newCountry, String newCourse, boolean newUserStatus){
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
        this.courseName = newCourse;
        this.userStatus = newUserStatus;;

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
    public String getCountry() {
        return country;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    public boolean isUserStatus() {
        return userStatus;
    }
    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
    public boolean getUserStatus()
    {
        return userStatus;
    }
}
