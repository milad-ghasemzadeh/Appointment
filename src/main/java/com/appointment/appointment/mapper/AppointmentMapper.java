package com.appointment.appointment.mapper;

import com.appointment.appointment.dto.AppointmentDTO;
import com.appointment.appointment.entity.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AppointmentMapper extends EntityMapper<AppointmentDTO, Appointment> {


    AppointmentDTO toDto(Appointment appointment);

    Appointment toEntity(AppointmentDTO appointmentDTO);

}
