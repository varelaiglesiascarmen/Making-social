package makingSocial.model;

public class GuestUser extends User{
    // attributes
    private String guestUser_ID;
    private String name;
    private String maritalStatus;
    private String RRSS;
    private int edad;

    public GuestUser(String userName, String password, String mail, boolean userType, String guestUser_ID, String name, String maritalStatus, String RRSS, int edad) {
        super(userName, password, mail, userType);
        this.guestUser_ID = guestUser_ID;
        this.name = name;
        this.maritalStatus = maritalStatus;
        this.RRSS = RRSS;
        this.edad = edad;
    }

    //getters & setters
    public String getGuestUser_ID() {
        return guestUser_ID;
    }

    public void setGuestUser_ID(String newGuestUser_ID) {
        this.guestUser_ID = newGuestUser_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String newMaritalStatus) {
        this.maritalStatus = newMaritalStatus;
    }

    public String getRRSS() {
        return RRSS;
    }

    public void setRRSS(String newRRSS) {
        this.RRSS = newRRSS;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int newEdad) {
        this.edad = newEdad;
    }

    // toString
    @Override
    public String toString() {
        return "GuestUser{" +
                "guestUser_ID='" + guestUser_ID + '\'' +
                ", name='" + name + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", RRSS='" + RRSS + '\'' +
                ", edad=" + edad +
                '}';
    }

    // metodos / method
    public void insertCode(){

    }

    public void searchEvent(){

    }

    public void changeRoll(){

    }
}
