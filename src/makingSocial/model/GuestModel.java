package makingSocial.model;

public class GuestModel extends UserModel {
    // attributes
    private int ID_User;
    // private ? Photo;
    private String CivilStatus;
    private String RRSS;
    private String BIO;
    // Asistencias
    private String Attendance;
    private int ID_GuestModel;

    // constructor
    public GuestModel(String NickName, String Password, String e_Mail, int Age, String Name, int ID_User, String civilStatus, String RRSS, String BIO, String Attendance, int ID_GuestModel) {
        super(NickName, Password, e_Mail, Age, Name);
        this.ID_User = ID_User;
        CivilStatus = civilStatus;
        this.RRSS = RRSS;
        this.BIO = BIO;
        Attendance = Attendance;
        this.ID_GuestModel = ID_GuestModel;
    }

    // getters & setters

    public int getID_User() { return ID_User; }

    public void setID_User(int ID_User) { this.ID_User = ID_User; }

    public String getCivilStatus() { return CivilStatus; }

    public void setCivilStatus(String civilStatus) { CivilStatus = civilStatus; }

    public String getRRSS() { return RRSS; }

    public void setRRSS(String RRSS) { this.RRSS = RRSS; }

    public String getBIO() { return BIO; }

    public void setBIO(String BIO) { this.BIO = BIO; }

    public String getAttendance() { return Attendance; }

    public void setAttendance(String Attendance) { this.Attendance = Attendance; }

    public int getID_GuestModel() { return ID_GuestModel; }

    public void setID_GuestModel(int ID_GuestModel) { this.ID_GuestModel = ID_GuestModel; }

    // toString
    @Override
    public String toString() {
        return "GuestModel{" +
                "ID_User=" + ID_User +
                ", CivilStatus='" + CivilStatus + '\'' +
                ", RRSS='" + RRSS + '\'' +
                ", BIO='" + BIO + '\'' +
                ", Attendance='" + Attendance + '\'' +
                ", ID_GuestModel=" + ID_GuestModel +
                '}';
    }

    // methods
}
