package ee.weatherproject.ot.forecast;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;


@Data
@JacksonXmlRootElement(localName = "forecasts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecasts {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "forecast")
    private List<Forecast> forecast;
}

