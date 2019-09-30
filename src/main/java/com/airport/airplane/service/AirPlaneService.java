package com.airport.airplane.service;

import com.airport.airplane.dao.AirPlaneDao;
import com.airport.airplane.dto.airplane.input.AirPlaneDTO;
import com.airport.airplane.model.AirPlane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirPlaneService {

    @Autowired
    private final AirPlaneDao airPlaneDao;

    public AirPlaneService(AirPlaneDao airPlaneDao) {
        this.airPlaneDao = airPlaneDao;
    }

    public AirPlane save(AirPlaneDTO input) {
        AirPlane airPlane = new AirPlane();
        airPlane.setNameAirplane(input.getNameAirplane());
        airPlane.setWidthAirplane(input.getWidthAirplane());
        airPlane.setHeigthAirplane(input.getHeigthAirplane());
        airPlane.setPassengerCapacity(input.getPassengerCapacity());
        airPlane.setIdAirport(input.getIdAirport());

        return airPlaneDao.save(airPlane);
    }

    public AirPlane findAirPlaneById(int id) {
        return airPlaneDao.findById(id);
    }

    public List<AirPlane> findByPagination(String min, String max) {
        return airPlaneDao.findByPagination(min, max);
    }

}
