package by.yarchynskaya;

import java.sql.*;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        LOG.info("\n");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "1111");
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM BOOKS join AUTHORS on BOOKS.author = AUTHORS.author_id");
        while (rs.next()) {
            System.out.println("КНИГА: " + rs.getString("title"));
            System.out.println("\tАвтор: " + rs.getString("fio"));
            System.out.println("\tИздана в: " + rs.getString("released"));
        }
    }
}
