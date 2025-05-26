package makingSocial.model;

public class hostModel extends userModel {

    // attributes
    private int ID_Host; // PK

    // constructor / constructor
    public hostModel(int ID_User, String NickName, String Password, String PassWordConfirm, String E_Mail, int Age, String Name, int ID_Host) {
        super(ID_User, NickName, Password, PassWordConfirm, E_Mail, Age, Name);
        this.ID_Host = ID_Host;
    }

    //getters & setters
    public int getID_Host() {
        return ID_Host;
    }

    public void setID_Host(int ID_Host) {
        this.ID_Host = ID_Host;
    }

    // toString
    @Override
    public String toString() {
        return "hostModel{" +
                "ID_Host=" + ID_Host + '\'' +
                ", ID_User=" + super.getID_User() +
                "}";
    }

    // methods

}