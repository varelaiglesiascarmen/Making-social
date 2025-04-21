package makingSocial.model;

public class Event{
    // attribute
        // id evento
        private String event_ID;
        // fecha
        private int date;
        // horario
        private int schedule;
        // localizacion
        private String location;
        // etiqueta
        private String dressCode;
        // edad permitida
        private int allowedAge;
        // tematica
        private String themed;
        // true = private event
        private boolean access = true;
        // id anfitrion
        private String host_ID;

    // constructor
    public Event(String event_ID, int date, int schedule, String location, String dressCode, int allowedAge, String themed, boolean access, String host_ID) {
        this.event_ID = event_ID;
        this.date = date;
        this.schedule = schedule;
        this.location = location;
        this.dressCode = dressCode;
        this.allowedAge = allowedAge;
        this.themed = themed;
        this.access = access;
        this.host_ID = host_ID;
    }

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
