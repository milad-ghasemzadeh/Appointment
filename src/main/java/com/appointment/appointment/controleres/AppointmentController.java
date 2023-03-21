package com.appointment.appointment.controleres;


import com.appointment.appointment.dto.AppointmentDTO;
import com.appointment.appointment.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/add_appointments")
    public ResponseEntity<AppointmentDTO> addAppointment(AppointmentDTO appointment) {
     return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.CREATED);
    }

}
