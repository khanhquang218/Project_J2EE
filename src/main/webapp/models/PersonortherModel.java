package models;

public class PersonotherModel {
    private String UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    private String UserAccount;
    private String Password;
    private String DayOfBirth;
    private String Gender;
    private String Address;

    public PersonotherModel() {
    }

    public PersonotherModel(String UserID, String FirstName, String LastName, String Email, String Phone, String UserAccount, String Password, String DayOfBirth, String Gender, String Address) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Phone = Phone;
        this.UserAccount = UserAccount;
        this.Password = Password;
        this.DayOfBirth = DayOfBirth;
        this.Gender = Gender;
        this.Address = Address;
    }

    public String getUserID() {
        return UserID;
    }

    public String setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String setFirstName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public String setUserAccount(String UserAccount) {
        this.UserAccount = UserAccount;
    }

    public String getPassword() {
        return Password;
    }

    public String setPassword(String Password) {
        this.Password = Password;
    }

    public String getDayOfBirth() {
        return DayOfBirth;
    }

    public String setDayOfBirth(String DayOfBirth) {
        this.DayOfBirth = DayOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String setAddress(String Address) {
        this.Address = Address;
    }
}