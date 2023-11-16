package ski.iko.java.struct.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

    public static <T> Stream<T> toStream(Collection<T> collection) {
        if (isEmpty(collection)) {
            return Stream.empty();
        }
        return collection.stream();
    }

    @SafeVarargs
    public static <T> int size(Collection<T>... collections){
        int size=0;
        for (Collection<T> collection : collections) {
            size += size(collection);
        }
        return size;
    }

    @SafeVarargs
    public static <T> Collection<T> concat(Collection<T>... collections) {
        List<T> result = new ArrayList<>(size(collections));
        for (Collection<T> collection : collections) {
            if (collection != null) {
                result.addAll(collection);
            }
        }
        return result;
    }

    @SafeVarargs
    public static <T> List<T> newArrayList(T...objects) {
        if (objects == null || objects.length == 0) {
            return new ArrayList<>(0);
        }
        List<T> list = new ArrayList<>(objects.length);
        for (T object : objects) {
            list.add(object);
        }
        return list;
    }

    public static <T> Collection<T> nullToEmpty(Collection<T> collection) {
        return collection == null ? new ArrayList<>() : collection;
    }

    public static <T> T getFirst(Collection<T> collection) {
        if (isEmpty(collection)) {
            return null;
        }
        return collection.iterator().next();
    }

    public static <T> T getLast(Collection<T> collection) {
        if (isEmpty(collection)) {
            return null;
        }
        T last = null;
        for (T t : collection) {
            last = t;
        }
        return last;
    }

    public static boolean containsAny(Collection<?> source, Collection<?> targets) {
        for (Object target : targets) {
            if (source.contains(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAll(Collection<?> source, Collection<?> targets) {
        return source.containsAll(targets);
    }

}
