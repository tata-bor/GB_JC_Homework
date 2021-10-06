package lesson_8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherRepository {

    public Weather[] SelectByCity(String name){
        var result = new ArrayList<Weather>();
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:weather.db");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select city, local_date, weather_text, temperature from forecasts where city = ?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                var value = new Weather();
                value.city = rs.getString(1);
                value.localDate = rs.getString(2);
                value.weatherText = rs.getString(3);
                value.temperature = rs.getDouble(4);
                result.add(value);
            }
            var resultArray = new Weather[result.size()];
            result.toArray(resultArray);
            return resultArray;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void Write(Weather weather){
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:weather.db");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into forecasts (city, local_date, weather_text, temperature) values (?, ?, ?, ?)");
            preparedStatement.setString(1, weather.city);
            preparedStatement.setString(2, weather.localDate);
            preparedStatement.setString(3, weather.weatherText);
            preparedStatement.setDouble(4, weather.temperature);
            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
