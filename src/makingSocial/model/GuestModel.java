package makingSocial.model;

public class GuestModel extends UserModel {
    // attributes
    // private ? Photo;
    private String CivilStatus;
    private String RRSS;
    private String BIO;
    // Asistencias
    private String Attendance;
    private int ID_GuestModel;

    // constructor
    public GuestModel(int ID_User, String NickName, String Password, String PassWordConfirm, String E_Mail, int Age, String Name, String civilStatus, String RRSS, String BIO, String Attendance, int ID_GuestModel) {
        super(ID_User, NickName, Password, PassWordConfirm, E_Mail, Age, Name);
        this.CivilStatus = civilStatus;
        this.RRSS = RRSS;
        this.BIO = BIO;
        this.Attendance = Attendance;
        this.ID_GuestModel = ID_GuestModel;
    }

    public GuestModel(int ID_User, int ID_GuestModel) {
        super(ID_User);
        this.ID_GuestModel = ID_GuestModel;
    }

    // getters & setters
    public String getCivilStatus() { return CivilStatus; }

    public void setCivilStatus(String civilStatus) { CivilStatus = civilStatus; }

    public String getRRSS() { return RRSS; }

    public void setRRSS(String RRSS) { this.RRSS = RRSS; }

    public String getBIO() { return BIO; }

    public void setBIO(String BIO) { this.BIO = BIO; }

    public String getAttendance() { return Attendance; }

    public void setAttendance(String Attendance) { this.Attendance = Attendance; }

    public int getID_GuestModel() { return ID_GuestModel; }

    public void setID_GuestModel(int ID_GuestModel) {
        this.ID_GuestModel = ID_GuestModel;
    }

    // toString
    @Override
    public String toString() {
        return "GuestModel{" +
                "ID_User=" + super.getID_User() + '\'' +
                ", CivilStatus=" + CivilStatus + '\'' +
                ", RRSS=" + RRSS + '\'' +
                ", BIO=" + BIO + '\'' +
                ", Attendance=" + Attendance + '\'' +
                ", ID_GuestModel=" + ID_GuestModel +
                '}';
    }

    // methods
}
