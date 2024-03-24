package ru.ssu.task7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void createNewDatabase(String url) {

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                ResultSet result = meta.getTables(null, null, "employeesAge", new String[] { "TABLE" });
                if (result.next()) {
                    System.out.println("Table 'employeesAge' already exists");
                } else {
                    // Create the table if it doesn't exist
                    String sql = "CREATE TABLE employeesAge (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "employeeName TEXT," +
                            "age INT)";

                    stmt.execute(sql);
                    System.out.println("Table created successfully");
                    System.out.println("Inserting values into the table...");
                    String insertValuesSql = "INSERT INTO employeesAge (employeeName, age) VALUES ('Кирилл', 18), ('Саша', 20), ('Катя', 25)";
                    stmt.executeUpdate(insertValuesSql);
                    System.out.println("Inserted values into the table...");
                }

                result = meta.getTables(null, null, "departmentSalary", new String[] { "TABLE" });
                if (result.next()) {
                    System.out.println("Table 'departmentSalary' already exists");
                } else {
                    // Create the table if it doesn't exist
                    String sql = "CREATE TABLE departmentSalary (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "employeeName TEXT," +
                            "departmentName TEXT," +
                            "salary INT)";

                    stmt.execute(sql);
                    System.out.println("Table created successfully");
                    System.out.println("Inserting values into the table...");
                    String insertValuesSql = "INSERT INTO departmentSalary (employeeName, departmentName, salary) " +
                            "VALUES ('Кирилл', 'IT', 30000), ('Иван', 'IT', 20000), ('Маша', 'HR', 40000)";
                    stmt.executeUpdate(insertValuesSql);
                    System.out.println("Inserted values into the table...");
                }

                result = meta.getTables(null, null, "departmentEmployee", new String[] { "TABLE" });
                if (result.next()) {
                    System.out.println("Table 'departmentEmployee' already exists");
                } else {
                    // Create the table if it doesn't exist
                    String sql = "CREATE TABLE departmentEmployee (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "employeeName TEXT," +
                            "departmentId INT)";

                    stmt.execute(sql);
                    System.out.println("Table created successfully");
                    System.out.println("Inserting values into the table...");
                    String insertValuesSql = "INSERT INTO departmentEmployee (employeeName, departmentId) " +
                            "VALUES ('Кирилл', 1), ('Иван', 1), ('Маша', 2)";
                    stmt.executeUpdate(insertValuesSql);
                    System.out.println("Inserted values into the table...");
                }

                result = meta.getTables(null, null, "departmentLocation", new String[] { "TABLE" });
                if (result.next()) {
                    System.out.println("Table 'departmentLocation' already exists");
                } else {
                    // Create the table if it doesn't exist
                    String sql = "CREATE TABLE departmentLocation (" +
                            "departmentid INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "departmentName TEXT," +
                            "location TEXT)";

                    stmt.execute(sql);
                    System.out.println("Table created successfully");
                    System.out.println("Inserting values into the table...");
                    String insertValuesSql = "INSERT INTO departmentLocation (departmentName, location) " +
                            "VALUES ('IT', 'Саратов'), ('HR', 'Москва')";
                    stmt.executeUpdate(insertValuesSql);
                    System.out.println("Inserted values into the table...");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:./test.sqlite";
        createNewDatabase(url);
        System.out.println("Больше 20");
        try (Connection con = DriverManager.getConnection(url)) {

            try (Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM employeesAge WHERE age > 20")) {
                while (rs.next()) {
                    System.out.println(rs.getString("employeeName"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("===================\nСредняя по отделу");
        try (Connection con = DriverManager.getConnection(url)) {

            try (Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(
                            "SELECT departmentName, AVG(salary) FROM departmentSalary GROUP BY departmentName")) {
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("===================\nЧеловек отдел город");

        try (Connection con = DriverManager.getConnection(url)) {

            try (Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(
                            "SELECT employeeName, departmentName, location FROM departmentEmployee JOIN departmentLocation ON departmentEmployee.departmentId == departmentLocation.departmentId")) {
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
