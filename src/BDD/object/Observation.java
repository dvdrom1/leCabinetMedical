package BDD.object;

import java.sql.Date;

public class Observation {
    private int numPatient;
    private Date date;
    private String type;
    private String remarque;

    public Observation(Date date, String type, String remarque, int numPatient) {
        this.numPatient = numPatient;
        this.date = date;
        this.type = type;
        this.remarque = remarque;
    }

    public void setNumPatient(int numPatient) {
        this.numPatient = numPatient;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public int getNumPatient() {
        return numPatient;
    }

    public Date getDate() {
        return date;
    }

    public String getRemarque() {
        return remarque;
    }

    public String getType() {
        return type;
    }
}
