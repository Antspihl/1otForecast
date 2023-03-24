package ee.weatherproject.ot.forecast;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class NightPlace {
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "phenomenon")
    private String phenomenon;
    @JacksonXmlProperty(localName = "tempmin")
    private String tempMin;
}
