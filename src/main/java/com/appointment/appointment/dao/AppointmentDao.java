package com.appointment.appointment.dao;

import com.appointment.appointment.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<AppointmentEntity,Long> {

    public AppointmentEntity findAppointmentEntityByIdNumberEquals(int idNumber);

}
