package models;

import java.time.LocalDate;

public class UserModel {
    public String UserID;
    public String FirstName;
    public String LastName;
    public String Email;
    public String Phone;
    public String UserAccount;
    public LocalDate DayOfBirth;
    public String Gender;
    public String Address;
    public String Images;
    public UserModel(String userID, String firstName, String lastName, String email,
                     String phone, String userAccount, LocalDate dayOfBirth, String gender, String address, String images){
        this.UserID = userID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Phone = phone;
        this.UserAccount = userAccount;
        this.DayOfBirth = dayOfBirth;
        this.Gender = gender;
        this.Address = address;
        this.Images = images;
    }

    public String getUserID() {
        return UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public LocalDate getDayOfBirth() {
        return DayOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getImages() {
        return Images;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        DayOfBirth = dayOfBirth;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setImages(String images) {
        Images = images;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
