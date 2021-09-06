package br.com.sbs.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnectiona(){
        try {
            String url = "jdbc:mysql://localhost:3306/walletDb?useTimezone=true&serverTimezone=UTC";
            String usuario = "root";
            String senha = "Alura@123";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
