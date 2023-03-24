package ee.weatherproject.ot.forecast;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class DayPlace {
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "phenomenon")
    private String phenomenon;
    @JacksonXmlProperty(localName = "tempmax")
    private String tempMax = null;
}
