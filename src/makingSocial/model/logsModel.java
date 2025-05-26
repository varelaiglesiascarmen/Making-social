package makingSocial.model;

public class logsModel {
    // attributes
    private int ID_GuestModel;
    private int ID_Event;

    // constructor
    public logsModel(int ID_GuestModel, int ID_Event) {
        this.ID_GuestModel = ID_GuestModel;
        this.ID_Event = ID_Event;
    }

    // getters & setters
    public int getID_GuestModel() {
        return ID_GuestModel;
    }

    public void setID_GuestModel(int ID_GuestModel) {
        this.ID_GuestModel = ID_GuestModel;
    }

    public int getID_Event() {
        return ID_Event;
    }

    public void setID_Event(int ID_Event) {
        this.ID_Event = ID_Event;
    }

    // toString
    @Override
    public String toString() {
        return "logsModel{" +
                "ID_GuestModel=" + ID_GuestModel + '\'' +
                ", ID_Event=" + ID_Event +
                "}";
    }

    // methods
}
