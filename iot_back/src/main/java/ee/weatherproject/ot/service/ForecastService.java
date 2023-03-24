package ee.weatherproject.ot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.weatherproject.ot.forecast.Forecasts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ForecastService {
    private static final String API_URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

    private final RestTemplate restTemplate;

    private final ObjectMapper xmlMapper;

    public Forecasts getForecast() throws IOException {
        var res = restTemplate.getForEntity(API_URL, String.class);
        return xmlMapper.readValue(res.getBody(), Forecasts.class);
    }

}

