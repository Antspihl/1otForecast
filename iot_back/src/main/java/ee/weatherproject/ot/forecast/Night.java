package ee.weatherproject.ot.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Night {
    @JacksonXmlProperty(localName = "phenomenon")
    private String phenomenon;
    @JacksonXmlProperty(localName = "tempmin")
    private String tempmin;
    @JacksonXmlProperty(localName = "tempmax")
    private String tempmax;
    @JacksonXmlProperty(localName = "text")
    private String text;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "place")
    private List<NightPlace> places;

}
