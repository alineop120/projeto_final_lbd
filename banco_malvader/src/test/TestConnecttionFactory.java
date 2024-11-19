package test;

import dao.ConnectionFactory;
import java.sql.*;

public class TestConnecttionFactory {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(ConnectionFactory.getConection());
        /**
         * Saída do terminal:
         * com.mysql.cj.jdbc.ConnectionImpl@2e377400
         */
    }
}
