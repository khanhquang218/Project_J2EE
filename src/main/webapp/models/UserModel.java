package models;

import java.time.LocalDate;

public class UserModel {
    public String UserID;
    public String FirstName;
    public String LastName;
    public String Email;
    public String Phone;
    public String UserAccount;
    public String Pass;
    public LocalDate Dayofbirth;
    public String Gender;
    public String Address;

    //    public String Images;
    public UserModel(String userID, String firstName, String lastName, String email,
                     String phone, String userAccount, String pass, LocalDate dayofbirth, String gender,
                     String address){
        this.UserID = userID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Phone = phone;
        this.UserAccount = userAccount;
        this.Pass = pass;
        this.Dayofbirth = dayofbirth;
        this.Gender = gender;
        this.Address = address;

    }


    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public LocalDate getDayofbirth() {
        return Dayofbirth;
    }

    public void setDayofbirth(LocalDate dayofbirth) {
        Dayofbirth = dayofbirth;
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

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

//    public String getImages() {
//        return Images;
//    }

    public void setAddress(String address) {
        Address = address;
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

//    public void setImages(String images) {
//        Images = images;
//    }

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
