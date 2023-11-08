package ski.iko.java.struct.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractThreadLocalMap<K,V> implements Map<K,V> {
    private final ThreadLocal<Map<K,V>> threadLocalMap = new ThreadLocal<>();

    public Map<K,V> getMap(){
        return threadLocalMap.get();
    }

    @Override
    public int size() {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)){
            return 0;
        }
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        Map<K, V> map = getMap();
        return Objects.isNull(map) || map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)){
            return false;
        }
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)){
            return false;
        }
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)){
            return null;
        }
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            map = new HashMap<>();
            threadLocalMap.set(map);
        }
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            return null;
        }
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            return ;
        }
        map.putAll(m);
    }

    @Override
    public void clear() {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            return ;
        }
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            return new HashSet<>(0);
        }
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            return new ArrayList<>(0);
        }
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Map<K, V> map = getMap();
        if (Objects.isNull(map)) {
            return new HashSet<>(0);
        }
        return map.entrySet();
    }

    public void removeThreadLocal(){
        this.threadLocalMap.remove();
    }

}
