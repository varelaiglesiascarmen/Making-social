package makingSocial.model;

public class HostUser {
    // attribute
        // id_anfitrion
        private String host_ID;
        // nombre
        private String name;
        // nombre_usuario
        private String userName;
        // correo
        private String mail;

    // constructor
    public HostUser(String host_ID, String name, String userName, String mail) {
        this.host_ID = host_ID;
        this.name = name;
        this.userName = userName;
        this.mail = mail;
    }

    // getters & setters
    public String getHost_ID() {
        return host_ID;
    }

    public void setHost_ID(String host_ID) {
        this.host_ID = host_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // toString
    @Override
    public String toString() {
        return "HostUser{" +
                "host_ID='" + host_ID + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
