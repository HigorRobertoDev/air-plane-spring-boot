package com.airport.airplane.connection.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

    // URL do banco de dados
    private static String url = "jdbc:mysql://localhost:33060/dbairplane?useSSL=false";

    // Senha do banco  de dados
    private static String password = "1234";

    // User do banco de dados
    private static String user = "root";

    // Classe de conexão com o banco de dados
    private static Connection connection = null;

    private static void conectar() {
        try {
            // Verifica de já existe conexão
            if (connection == null) {

                // Registra o driver do banco de dados
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Faz a conexão com o banco de dados
                connection = DriverManager.getConnection(url, user, password);

                // Configuração para não commitar automaticamente os dados no banco de dados
                connection.setAutoCommit(false);

                System.out.println("Conectou com sucesso");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        conectar();
        return connection;
    }

}
