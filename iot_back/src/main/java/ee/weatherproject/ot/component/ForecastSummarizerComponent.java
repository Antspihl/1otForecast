package ee.weatherproject.ot.component;

import ee.weatherproject.ot.service.ForecastService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
@RequiredArgsConstructor
public class ForecastSummarizerComponent {

    private final ForecastService forecastService;

    @Scheduled(fixedRate = 60, initialDelay = 0, timeUnit = TimeUnit.MINUTES)
    public void reportCurrentTime() {
        int tempMinSum = 0;
        int tempMaxSum = 0;

        try {
            var forecast = forecastService.getForecast().getForecast().get(0);
            log.info(forecast.toString());

            var nightPlaces = forecast.getNight().getPlaces();
            var dayPlaces = forecast.getDay().getPlaces();

            int tempMinAmount = nightPlaces.size();
            int tempMaxAmount = dayPlaces.size();
            int tempAmount = Integer.max(tempMaxAmount, tempMinAmount);

            for (int i = 0; i < tempAmount; i++) {
                if (i < tempMinAmount) {
                    tempMinSum += Integer.parseInt(nightPlaces.get(i).getTempMin());
                }
                if (i < tempMaxAmount) {
                    tempMaxSum += Integer.parseInt(dayPlaces.get(i).getTempMax());
                }
            }

            String result = String.format("Average min temperature: %d,%nAverage max temperature: %d",
                    tempMinSum / tempMinAmount, tempMaxSum / tempMaxAmount);
            log.info(result);
            writeToFile(result, forecast.getDate());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String input, String filename) throws IOException {
        // FIXME constant
        log.info(filename);
        var dayAndHour = Instant.now().truncatedTo(ChronoUnit.MINUTES).toString().substring(10, 13);
        filename = String.format("src/main/resources/reports/%s-%s.txt", filename, dayAndHour);
        log.info(filename);

        File newFile = new File(filename);
        var created = newFile.createNewFile();

        if (created) {
            log.info("File created: " + newFile.getName());
        } else {
            log.info("File already exists.");
        }

        try (FileWriter myWriter = new FileWriter(filename)) {
            myWriter.write(input);
        }

        log.info("Successfully wrote to the file.");

    }

}
