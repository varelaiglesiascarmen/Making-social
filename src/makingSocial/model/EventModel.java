package makingSocial.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventModel {
    // attribute
        // id evento
        private int ID_Event;
        // fecha
        private LocalDate Date;
        // horario
        private LocalTime Schedule;
        // localizacion
        private String Location;
        // codigo postal
        private int PostalCode;
        // etiqueta
        private boolean DressCode= true;
        // temática
        private boolean Theme= true;
        // opcion si (dresscode y tematica)
        private String Description;
        // edad permitida
        private int AllowedAge;
        // true = private event
        private boolean Access = true;
        // id anfitrion
        private int ID_Host;

    // constructor
    public EventModel(int ID_Event, LocalDate date, LocalTime schedule, String location, int postalCode, boolean dressCode, boolean theme, String description, int allowedAge, boolean access, int ID_Host) {
        this.ID_Event = ID_Event;
        Date = date;
        Schedule = schedule;
        Location = location;
        PostalCode = postalCode;
        DressCode = dressCode;
        Theme = theme;
        Description = description;
        AllowedAge = allowedAge;
        Access = access;
        this.ID_Host = ID_Host;
    }

    // getters & setters

    public int getID_Event() { return ID_Event; }

    public void setID_Event(int ID_Event) { this.ID_Event = ID_Event; }

    public LocalDate getDate() { return Date; }

    public void setDate(LocalDate date) { Date = date; }

    public LocalTime getSchedule() { return Schedule; }

    public void setSchedule(LocalTime schedule) { Schedule = schedule; }

    public String getLocation() { return Location; }

    public void setLocation(String location) { Location = location; }

    public int getPostalCode() { return PostalCode; }

    public void setPostalCode(int postalCode) { PostalCode = postalCode; }

    public boolean isDressCode() { return DressCode; }

    public void setDressCode(boolean dressCode) { DressCode = dressCode; }

    public boolean isTheme() { return Theme; }

    public void setTheme(boolean theme) { Theme = theme; }

    public String getDescription() { return Description; }

    public void setDescription(String description) { Description = description; }

    public int getAllowedAge() { return AllowedAge; }

    public void setAllowedAge(int allowedAge) { AllowedAge = allowedAge; }

    public int getID_Host() { return ID_Host; }

    public void setID_Host(int ID_Host) { this.ID_Host = ID_Host; }

    public boolean isAccess() { return Access; }

    public void setAccess(boolean access) { Access = access; }

    // toString
    @Override
    public String toString() {
        return "EventModel{" +
                "ID_Event=" + ID_Event +
                ", Date=" + Date +
                ", Schedule=" + Schedule +
                ", Location='" + Location + '\'' +
                ", PostalCode=" + PostalCode +
                ", DressCode=" + DressCode +
                ", Theme=" + Theme +
                ", Description='" + Description + '\'' +
                ", AllowedAge=" + AllowedAge +
                ", Access=" + Access +
                ", ID_Host=" + ID_Host +
                '}';
    }

    // methods
}
