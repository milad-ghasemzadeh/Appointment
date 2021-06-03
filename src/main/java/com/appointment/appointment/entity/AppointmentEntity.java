package com.appointment.appointment.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="appointment")
public class AppointmentEntity  implements Serializable{
    private int id;
    private String Start;
    private String end;
    private String createdAt;
    private String updatedAt;
    private int idNumber;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "START" )
    public String getStart() {
        return Start;
    }
    public void setStart(String start) {
        Start = start;
    }


    @Column(name = "END" )
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }



    @Column(name = "CREATEDAT")
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    @Column(name = "UPDATEDAT")
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Column(name = "IDNUMBER")
    public int getIdNumber() { return idNumber; }
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }


}
