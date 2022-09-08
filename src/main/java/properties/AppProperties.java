package properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:app.properties"})
public interface AppProperties extends Config {

    @Key("headerCookie")
    String headerCookie();

    @Key("url_GET")
    String url_GET();

    @Key("url_POST")
    String url_POST();

    @Key("httpTimeout")
    int httpTimeout();

    @Key("dataRaw")
    String dataRaw();

}
