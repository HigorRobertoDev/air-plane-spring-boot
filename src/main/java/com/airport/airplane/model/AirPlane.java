package com.airport.airplane.model;

public class AirPlane {
    private int id;
    private String nameAirplane;
    private float widthAirplane;
    private float heigthAirplane;
    private int passengerCapacity;
    private int idAirport;

    public AirPlane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
