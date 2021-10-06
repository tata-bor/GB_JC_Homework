package lesson_8;

import java.io.IOException;

public class WeatherLauncher {
    public static void main(String[] args) throws Exception {

        // write
        recieveCityWeatherAndSave("295212", "Saint-Petersburg");
        recieveCityWeatherAndSave("294021", "Moscow");

        // load
        var rep = new WeatherRepository();
        var res = rep.SelectByCity("Moscow");
        for(int index = 0; index < res.length; index++) {
            System.out.println("city " + res[index].city + " weather " + res[index].weatherText
                + " temperature " + res[index].temperature + " date " + res[index].localDate);
        }
    }

    private static void recieveCityWeatherAndSave(String code, String city) throws IOException {

        var api = new WeatherApi();
        var apiResults = api.Load(code);
        var rep = new WeatherRepository();
        for(int index = 0; index < apiResults.length; index++){

            var weather = new Weather();
            weather.weatherText = apiResults[index].WeatherText;
            weather.localDate = apiResults[index].LocalObservationDateTime;
            weather.city = city;
            weather.temperature = apiResults[index].Temperature.Metric.Value;
            rep.Write(weather);
        }
    }
}
