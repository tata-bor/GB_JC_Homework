package lesson_8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherApi {
    public WeatherResponse[] Load(String geoCode) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/currentconditions/v1/"+ geoCode
                        + "?apikey=ROJT0Gu381yyUQZLSSRSpEU3ugiGT3oa&metric=true")
                .build();
        Response response = client.newCall(request).execute();

        String body = response.body().string();
        ;
        System.out.println ("Response:" +
                body);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(body, WeatherResponse[].class);
    }
}
