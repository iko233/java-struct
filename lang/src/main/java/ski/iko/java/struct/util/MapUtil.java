package ski.iko.java.struct.util;

import java.util.Map;
import java.util.Objects;

public class MapUtil {

    private MapUtil(){}

    public static boolean isEmpty(Map<?,?> map) {
        return Objects.isNull(map) || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?,?> map) {
        return Objects.nonNull(map) && !map.isEmpty();
    }
}
