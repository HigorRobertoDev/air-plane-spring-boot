package com.airport.airplane.dto.airplane.input;

public class AirPlaneDTO {

    public String nameAirplane;
    public float widthAirplane;
    public float heigthAirplane;
    public int passengerCapacity;
    public int idAirport;

    public AirPlaneDTO() {
    }

    public String getNameAirplane() {
        return nameAirplane;
    }

    public void setNameAirplane(String nameAirplane) {
        this.nameAirplane = nameAirplane;
    }

    public float getWidthAirplane() {
        return widthAirplane;
    }

    public void setWidthAirplane(float widthAirplane) {
        this.widthAirplane = widthAirplane;
    }

    public float getHeigthAirplane() {
        return heigthAirplane;
    }

    public void setHeigthAirplane(float heigthAirplane) {
        this.heigthAirplane = heigthAirplane;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }
}
