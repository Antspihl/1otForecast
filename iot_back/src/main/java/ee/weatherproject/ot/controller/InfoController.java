package ee.weatherproject.ot.controller;

import ee.weatherproject.ot.forecast.Forecasts;
import ee.weatherproject.ot.service.ForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class InfoController {

    private final ForecastService forecastService;

    @GetMapping(produces = "application/json", path = "/forecast")
    public ResponseEntity<Forecasts> getForecast() {
        try {
            var forecasts = forecastService.getForecast();
            return new ResponseEntity<>(forecasts, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
