package ski.iko.java.struct.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class CollectionUtil {
    private CollectionUtil() {
    }

    public static List<?> constantEmptyList() {
        return Collections.emptyList();
    }

    public static List<?> emptyList(){
        return new ArrayList<>(0);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return Objects.nonNull(collection) && !collection.isEmpty();
    }

}
