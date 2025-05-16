package makingSocial.model;

public class UserModel {
    // attribute
        // nombre usuario, max 15 caracteres
        private String NickName;
        // max 20 caracteres
        private String Password;
        // max 45 caracteres
        private String E_Mail;
        private int Age;
        // max 10 caracteres
        private String Name;

    // constructor
    public UserModel(String NickName, String Password, String e_Mail, int Age, String Name) {
        this.NickName = NickName;
        this.Password = Password;
        this.E_Mail = e_Mail;
        this.Age = Age;
        this.Name = Name;
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

    public String getE_Mail() {
        return E_Mail;
    }

    public void setE_Mail(String e_Mail) {
        this.E_Mail = e_Mail;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getName() {
        return Age;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "NickName='" + NickName + '\'' +
                "Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", e_Mail=" + E_Mail + '\'' +
                ", Age='" + Age +
                '}';
    }

    // methods

}
