import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:postgresql://localhost:5432/postgres",
                                     "postgres", "Vera123");) {

            Statement statement = connection.createStatement();
            //statement.execute("CREATE TABLE IF NOT EXISTS abc (id int)");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                Car car = new Car(id, name, country);
                System.out.println(car);
            }

            System.out.println("Подключено");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}




