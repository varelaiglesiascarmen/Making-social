package makingSocial.model;

public class GuestUser {
    // attribute
        // id_invitado
        private String guestUser_ID;
        // nombre
        private String name;
        // estado civil
        private String maritalStatus;
        // Red Social
        private String RRSS;
        // edad
        private int age;

    // constructor
    public GuestUser(String guestUser_ID, String name, String maritalStatus, String RRSS, int age) {
        this.guestUser_ID = guestUser_ID;
        this.name = name;
        this.maritalStatus = maritalStatus;
        this.RRSS = RRSS;
        this.age = age;
    }

    // getters & setters
    public String getGuestUser_ID() {
        return guestUser_ID;
    }

    public void setGuestUser_ID(String guestUser_ID) {
        this.guestUser_ID = guestUser_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRRSS() {
        return RRSS;
    }

    public void setRRSS(String RRSS) {
        this.RRSS = RRSS;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString

    @Override
    public String toString() {
        return "GuestUser{" +
                "guestUser_ID='" + guestUser_ID + '\'' +
                ", name='" + name + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", RRSS='" + RRSS + '\'' +
                ", age=" + age +
                '}';
    }
}
