package lesson_6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

import org.json.*;

public class ReadForecast {
    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=ROJT0Gu381yyUQZLSSRSpEU3ugiGT3oa&metric=true")
                .build();
        Response response = client.newCall(request).execute();

        String body = response.body().string();;
        System.out.println ("Response:" +
                body);

        JSONObject obj = new JSONObject(body);

        JSONArray arr = obj.getJSONArray("DailyForecasts"); // notice that "posts": [...]
        for (int i = 0; i < arr.length(); i++)
        {
            var val = arr.getJSONObject(i).getJSONObject("Temperature")
                    .getJSONObject("Minimum").getDouble("Value");
            String date = arr.getJSONObject(i).getString("Date");
            System.out.println ("Date: " + date + " Temperature Min: " + val);
        }
    }
}
