package lesson_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class ReadForecast {
    public static void main(String[] args) throws Exception {
        currentWeather();

        forecast();

    }

    private static void forecast() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=ROJT0Gu381yyUQZLSSRSpEU3ugiGT3oa&metric=true")
                .build();
        Response response = client.newCall(request).execute();

        String body = response.body().string();
        ;
        System.out.println ("Response:" +
                body);

        JSONObject obj = new JSONObject(body);

        JSONArray arr = obj.getJSONArray("DailyForecasts"); // notice that "posts": [...]
        for (int i = 0; i < arr.length(); i++)
        {
            var day = arr.getJSONObject(i);
            var val = day.getJSONObject("Temperature")
                    .getJSONObject("Minimum").getDouble("Value");
            String date = day.getString("Date");
            String phrase = day.getJSONObject("Day").getString("IconPhrase");
            System.out.println ("In city Saint-Petersburg on date "
                    + date.substring(0,10) + " we wait " + phrase + " weather, temperature - " + val);
        }
    }

    private static void currentWeather() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Builder()
                .url("http://dataservice.accuweather.com/currentconditions/v1/295212?apikey=ROJT0Gu381yyUQZLSSRSpEU3ugiGT3oa&metric=true")
                .build();
        Response response = client.newCall(request).execute();

        String body = response.body().string();
        ;
        System.out.println ("Response:" +
                body);
        ObjectMapper objectMapper = new ObjectMapper();
        var res = objectMapper.readValue(body, WeatherResponse[].class);
        System.out.println (res[0].WeatherText + " " + res[0].Temperature.Metric.Value + " C");
    }


}
