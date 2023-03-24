package ee.weatherproject.ot.forecast;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Forecast {
    @JacksonXmlProperty(localName = "date", isAttribute = true)
    private String date;
    @JacksonXmlProperty(localName = "night")
    private Night night;
    @JacksonXmlProperty(localName = "day")
    private Day day;
}
