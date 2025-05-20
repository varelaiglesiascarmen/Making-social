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
        this.Date = date;
        this.Schedule = schedule;
        this.Location = location;
        this.PostalCode = postalCode;
        this.DressCode = dressCode;
        this.Theme = theme;
        this.Description = description;
        this.AllowedAge = allowedAge;
        this.Access = access;
        this.ID_Host = ID_Host;
    }

    // getters & setters

    public int getID_Event() { return ID_Event; }

    public void setID_Event(int ID_Event) { this.ID_Event = ID_Event; }

    public LocalDate getDate() { return Date; }

    public void setDate(LocalDate date) { this.Date = date; }

    public LocalTime getSchedule() { return Schedule; }

    public void setSchedule(LocalTime schedule) { this.Schedule = schedule; }

    public String getLocation() { return Location; }

    public void setLocation(String location) { this.Location = location; }

    public int getPostalCode() { return PostalCode; }

    public void setPostalCode(int postalCode) { this.PostalCode = postalCode; }

    public boolean isDressCode() { return DressCode; }

    public void setDressCode(boolean dressCode) { this.DressCode = dressCode; }

    public boolean isTheme() { return Theme; }

    public void setTheme(boolean theme) { this.Theme = theme; }

    public String getDescription() { return Description; }

    public void setDescription(String description) { this.Description = description; }

    public int getAllowedAge() { return AllowedAge; }

    public void setAllowedAge(int allowedAge) { this.AllowedAge = allowedAge; }

    public int getID_Host() { return ID_Host; }

    public void setID_Host(int ID_Host) { this.ID_Host = ID_Host; }

    public boolean isAccess() { return Access; }

    public void setAccess(boolean access) { this.Access = access; }

    // toString
    @Override
    public String toString() {
        return "EventModel{" +
                "ID_Event=" + ID_Event + '\'' +
                ", Date=" + Date + '\'' +
                ", Schedule=" + Schedule + '\'' +
                ", Location='" + Location + '\'' +
                ", PostalCode=" + PostalCode + '\'' +
                ", DressCode=" + DressCode + '\'' +
                ", Theme=" + Theme + '\'' +
                ", Description='" + Description + '\'' +
                ", AllowedAge=" + AllowedAge + '\'' +
                ", Access=" + Access + '\'' +
                ", ID_Host=" + ID_Host +
                '}';
    }

    // methods
}
