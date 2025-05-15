package makingSocial.model;

public class User {
    // attribute
        // nombre usuario
        private String NickName;
        private String Password;
        private String PassWordConfirm;
        private String e_Mail;
        private int Age;
        // Host = true , Guest = false
        private boolean userType = true;

    // constructor
    public User(String NickName, String Password, String PassWordConfirm, String e_Mail, int Age) {
        this.NickName = NickName;
        this.Password = Password;
        this.PassWordConfirm = PassWordConfirm;
        this.e_Mail = e_Mail;
        this.Age = Age;
    }

    //getters & setters
    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassWordConfirm() {
        return PassWordConfirm;
    }

    public void setMail(String PassWordConfirm) {
        this.PassWordConfirm = PassWordConfirm;
    }

    public String getE_Mail() {
        return e_Mail;
    }

    public void setE_Mail(String e_Mail) {
        this.e_Mail = e_Mail;
    }

    public int getAge() {
        return e_Mail;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "NickName='" + NickName + '\'' +
                ", Password='" + Password + '\'' +
                ", PassWordConfirm='" + PassWordConfirm + '\'' +
                ", e_Mail=" + e_Mail + '\'' +
                ", Age='" + Age +
                '}';
    }

}
