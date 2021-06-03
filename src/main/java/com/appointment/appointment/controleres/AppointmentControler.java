package com.appointment.appointment.controleres;


import com.appointment.appointment.dto.AppointmentDTO;
import com.appointment.appointment.entity.AppointmentEntity;
import com.appointment.appointment.session.AppointmentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AppointmentControler {


    @Autowired
    AppointmentSession appointmentSession;

    @PostMapping(value = "/data", consumes = "application/json")
    public void getJsonDataAppointment(@RequestBody ArrayList<AppointmentDTO> var) {

        for (int i = 0; i < var.size(); i++) {

            if (!appointmentSession.findById(var.get(i).getId())) {
                ////// for inserting data in database
                if (manageAppointments(var.get(i))) {
                    appointmentSession.addAppointmentTime(var.get(i));
                    System.out.println("We insert data in database");

                } else {
                    System.err.println("We can't insert data in database,try change of time of appointment");
                }


            } else {
                ////// for updating Data

                if (manageAppointments(var.get(i))) {
                    appointmentSession.updateAppointmentData(var.get(i));
                    System.out.println("We updated our data in our database");

                } else {
                    System.err.println("We can't update our data in the database,try change times for new times");
                }





            }


        }

    }
  // we using this function for managing time of appointments in the information and enter valid dates.
    public Boolean manageAppointments(AppointmentDTO appointmentDTO) {
        List<AppointmentEntity> appointmentEntities = appointmentSession.findAllOfAppointmentTime();
        int i = 0;
        for (AppointmentEntity appointmentEntity : appointmentEntities) {
            if (manageTimes(changeStringToDate(appointmentDTO.getStart()), changeStringToDate(appointmentDTO.getEnd()), changeStringToDate(appointmentEntity.getStart()), changeStringToDate(appointmentEntity.getEnd())) ||  appointmentEntity.getIdNumber()==appointmentDTO.getId()  ) {
                i++;
            }

        }
        if (i == appointmentEntities.size()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean manageTimes(Date dateStart1, Date dateEnd1, Date dateStart2, Date dateEnd2) {
        if (dateStart1.before(dateStart2)) {
            if (dateEnd1.before(dateStart2)) {
                return true;
            } else {
                return false;
            }

        } else if (dateStart1.after(dateStart2)) {

            if (dateStart1.before(dateEnd2)) {
                return false;
            } else {
                return true;
            }


        } else {
            return false;
        }


    }

    public Date changeStringToDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date=sdf.parse(dateString);
            return date;
        }
        catch(Exception e){
          System.err.println("Enter date correctly");
            return null;
        }

    }





}
