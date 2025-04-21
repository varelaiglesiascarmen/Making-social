package makingSocial.model;

public class Event extends HostUser{
    // attribute
    private String event_ID;
    private int date;
    private int schedule;
    private String location;
    private String dressCode;
    private int allowedAge;
    private String themed;
    private boolean access = true;
    // hereda de hostUser
    private String host_ID;

    //getters & setters
    public int getDate() {
        return date;
    }

    public void setDate(int newDate) {
        this.date = newDate;
    }

    public String getEvent_ID() {
        return event_ID;
    }

    public void setEvent_ID(String newEvent_ID) {
        this.event_ID = newEvent_ID;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int newSchedule) {
        this.schedule = newSchedule;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String newDressCode) {
        this.dressCode = newDressCode;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean newAccess) {
        this.access = newAccess;
    }

    public String getThemed() {
        return themed;
    }

    public void setThemed(String newThemed) {
        this.themed = newThemed;
    }

    public int getAllowedAge() {
        return allowedAge;
    }

    public void setAllowedAge(int newAllowedAge) {
        this.allowedAge = newAllowedAge;
    }

    // toString
    @Override
    public String toString() {
        return "Event{" +
                "event_ID='" + event_ID + '\'' +
                ", date=" + date +
                ", schedule=" + schedule +
                ", location='" + location + '\'' +
                ", dressCode='" + dressCode + '\'' +
                ", allowedAge=" + allowedAge +
                ", themed='" + themed + '\'' +
                ", access=" + access +
                ", host_ID='" + host_ID + '\'' +
                '}';
    }
}
