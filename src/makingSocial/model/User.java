package makingSocial.model;

public class User {
    // attribute
        // nombre usuario
        private String userName;
        private String password;
        private String mail;
        // userType = true , es Host
        private boolean userType = true;

    // constructor
    public User(String userName, String password, String mail, boolean userType) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.userType = userType;
    }

    //getters & setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", userType=" + userType +
                '}';
    }
}
