package makingSocial.model;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class HostModel extends UserModel {

    // attributes
    private int ID_Host;
    private int ID_Event;

    // constructor / constructor
    public HostModel(String NickName, String Password, String e_Mail, int Age, String Name, int ID_Host, int ID_Event) {
        super(NickName, Password, e_Mail, Age, Name);
        this.ID_Host = ID_Host;
        this.ID_Event = ID_Event;
    }

    //getters & setters
    public int getID_Host() { return ID_Host; }

    public void setID_Host(int ID_Host) { this.ID_Host = ID_Host; }

    public int getID_Event() { return ID_Event; }

    public void setID_Event(int ID_Event) { this.ID_Event = ID_Event; }

    // toString
    @Override
    public String toString() {
        return "HostModel{" +
                "ID_Host='" + ID_Host + '\'' +
                ", ID_Event='" + ID_Event + '\'' +
                '}';
    }

    // methods

}