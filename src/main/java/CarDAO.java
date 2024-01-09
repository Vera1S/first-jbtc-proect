import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    private final Connection connection;

    public List<Car> getAllCars() throws SQLException {
        List<Car> list = new ArrayList<>();

        Statement statement = connection.createStatement(); //создание "состояния"
        ResultSet resultSet = statement.executeQuery("SELECT * FROM car"); //делаем запрос

        while (resultSet.next()) {
            int id = resultSet.getInt("id"); //получить число из поля "id"
            String name = resultSet.getString("name");
            String country = resultSet.getString("country");
            Car car = new Car(id, name, country);
            list.add(car);
        }
        return list;
    }

    public void insertNewCar(Car car) throws SQLException {
        Statement statement = connection.createStatement();
        int id = car.getId();
        String name = car.getName();
        String country = car.getCountry();

        String fistInsert = "INSERT INTO  car VALUES (" + id + ", '" + name + "', '" + country + "')";
        //statement.execute("INSERT INTO  car VALUES ("+ id + "',' " + name + " ', '"+ country + "')");
        statement.execute(fistInsert);
       // System.out.println(fistInsert);

    }

    public void updateCar(Car car) throws SQLException {
        Statement statement = connection.createStatement();
        int id = car.getId();
        String name = car.getName();
        String country = car.getCountry();

       String secondUpdate = "UPDATE car SET name = 'BMW'" + name + "', country = 'German'" + country + "' WHERE id = '1'" + id;
        statement.execute(secondUpdate);
    }
    public void deletCar(Car car) throws SQLException {
        Statement statement = connection.createStatement();
        int id = car.getId();
        String name = car.getName();
        String country = car.getCountry();

        String thirdCar = "DELETE FROM car WHERE id = '3'"+ id;
        statement.execute(thirdCar);

    }


    public CarDAO(Connection connection) {

        this.connection = connection;
    }
}
