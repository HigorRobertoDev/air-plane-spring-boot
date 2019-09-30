package com.airport.airplane.dao;

import com.airport.airplane.connection.jdbc.SingleConnection;
import com.airport.airplane.model.AirPlane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AirPlaneDao {
    private Connection connection;

    @Autowired
    public AirPlaneDao() {
        connection = SingleConnection.getConnection();
    }

    public AirPlane save(AirPlane airPlane) {
        try {
            String sql = "insert into airplane (name_airplane, width_airplane, heigth_airplane, passenger_capacity, id_airport) values (?, ?, ?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // Parâmetros sendo adicionado
            insert.setString(1, airPlane.getNameAirplane());
            insert.setFloat(2, airPlane.getWidthAirplane());
            insert.setFloat(3, airPlane.getHeigthAirplane());
            insert.setInt(4, airPlane.getPassengerCapacity());
            insert.setInt(5, airPlane.getIdAirport());
            insert.execute(); // SQL sendo executado no banco de dados
            connection.commit(); // Salva no banco

            ResultSet result = insert.getGeneratedKeys();
            if (result != null && result.next())
                airPlane.setId(result.getInt(1));
        } catch (Exception e) {
            try {
                connection.rollback(); // reverte operação caso tenha erros
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return airPlane;
    }

    public List<AirPlane> findByPagination(String min, String max) {
        List<AirPlane> airPlaneList = new ArrayList<>();

        try {
            String sql = "select * from airplane limit ?, ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(min));
            statement.setInt(2, Integer.parseInt(max));
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                AirPlane airPlane = new AirPlane();
                airPlane.setId(result.getInt("id"));
                airPlane.setNameAirplane(result.getString("name_airplane"));
                airPlane.setWidthAirplane(result.getFloat("width_airplane"));
                airPlane.setHeigthAirplane(result.getFloat("heigth_airplane"));
                airPlane.setPassengerCapacity(result.getInt("passenger_capacity"));
                airPlane.setIdAirport(result.getInt("id_airport"));

                airPlaneList.add(airPlane);
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return airPlaneList;
    }

    public AirPlane findById(int id) {
        AirPlane airPlane = new AirPlane();
        try {
            String sql = "select * from airplane where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result != null && result.next()) {
                airPlane.setId(result.getInt("id"));
                airPlane.setNameAirplane(result.getString("name_airplane"));
                airPlane.setWidthAirplane(result.getFloat("width_airplane"));
                airPlane.setHeigthAirplane(result.getFloat("heigth_airplane"));
                airPlane.setPassengerCapacity(result.getInt("passenger_capacity"));
                airPlane.setIdAirport(result.getInt("id_airport"));
            }

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return airPlane;
    }

}
