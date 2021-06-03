package com.appointment.appointment.session;

import com.appointment.appointment.dao.AppointmentDao;
import com.appointment.appointment.dto.AppointmentDTO;
import com.appointment.appointment.entity.AppointmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentSessionImp  implements  AppointmentSession{


     private AppointmentEntity appointmentEntity;

    @Autowired
    AppointmentDao appointmentDao;

    @Override
    public AppointmentEntity addAppointmentTime(AppointmentDTO appointmentDTO) {
        List<AppointmentEntity> sampleExsists=findAllOfAppointmentTime();
        if(sampleExsists.size()!=0){
            appointmentEntity= new AppointmentEntity();
            appointmentEntity.setCreatedAt(appointmentDTO.getCreatedAt());
            appointmentEntity.setId(sampleExsists.size()+1);
            appointmentEntity.setEnd(appointmentDTO.getEnd());
            appointmentEntity.setIdNumber(appointmentDTO.getId());
            appointmentEntity.setStart(appointmentDTO.getStart());
            appointmentEntity.setUpdatedAt(appointmentDTO.getUpdatedAt());
            appointmentDao.save(appointmentEntity);

        }
        else{


            appointmentEntity= new AppointmentEntity();
            appointmentEntity.setCreatedAt(appointmentDTO.getCreatedAt());
            appointmentEntity.setId(1);
            appointmentEntity.setEnd(appointmentDTO.getEnd());
            appointmentEntity.setIdNumber(appointmentDTO.getId());
            appointmentEntity.setStart(appointmentDTO.getStart());
            appointmentEntity.setUpdatedAt(appointmentDTO.getUpdatedAt());
            System.out.println("we'are in the SessionImp 1 "+  appointmentEntity ) ;
            appointmentDao.save(appointmentEntity);
        }


        return appointmentEntity;

    }

    @Override
    public List<AppointmentEntity> findAllOfAppointmentTime() {
      return appointmentDao.findAll();
    }

    @Override
    public boolean findById(int id) {
        AppointmentEntity appointmentEntity;
        appointmentEntity=appointmentDao.findAppointmentEntityByIdNumberEquals(id);
        if(appointmentEntity!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public AppointmentEntity updateAppointmentData(AppointmentDTO appointmentDTO) {
        AppointmentEntity appointmentEntityPreviousDetails;
        appointmentEntityPreviousDetails=appointmentDao.findAppointmentEntityByIdNumberEquals(appointmentDTO.getId());
        appointmentEntityPreviousDetails.setStart(appointmentDTO.getStart());
        appointmentEntityPreviousDetails.setEnd(appointmentDTO.getEnd());
        appointmentEntityPreviousDetails.setUpdatedAt(appointmentDTO.getUpdatedAt());
        appointmentDao.saveAndFlush(appointmentEntityPreviousDetails);
        return appointmentEntityPreviousDetails;



    }



}
