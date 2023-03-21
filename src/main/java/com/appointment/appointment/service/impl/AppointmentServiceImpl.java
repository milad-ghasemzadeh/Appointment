package com.appointment.appointment.service.impl;

import com.appointment.appointment.dto.AppointmentDTO;
import com.appointment.appointment.entity.Appointment;
import com.appointment.appointment.mapper.AppointmentMapper;
import com.appointment.appointment.repository.AppointmentRepository;
import com.appointment.appointment.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentMapper appointmentMapper,
                                  AppointmentRepository appointmentRepository) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {

        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        appointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDto(appointment);
    }
}
