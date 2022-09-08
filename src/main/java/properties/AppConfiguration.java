package properties;

import org.aeonbits.owner.ConfigCache;

import java.util.Map;

public class AppConfiguration {

    public static AppProperties appProp() {
        return ConfigCache.getOrCreate(AppProperties.class, new Map[0]);
    }
}
