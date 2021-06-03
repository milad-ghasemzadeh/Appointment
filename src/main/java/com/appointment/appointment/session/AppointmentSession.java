package com.appointment.appointment.session;

import com.appointment.appointment.dto.AppointmentDTO;
import com.appointment.appointment.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppointmentSession {
    public AppointmentEntity addAppointmentTime(AppointmentDTO appointmentDTO);
    public List<AppointmentEntity> findAllOfAppointmentTime();
    public boolean findById(int id);
    public AppointmentEntity updateAppointmentData(AppointmentDTO appointmentDTO);

}
