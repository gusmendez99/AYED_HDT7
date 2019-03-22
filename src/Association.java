import java.util.Map;

public class Association<K,V> extends Object implements Comparable, Map.Entry{

    private K key;
    private V value;

    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Association ob = (Association) o;
        return key.toString().compareToIgnoreCase(ob.key.toString());
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Object setValue(Object value) {
        V val = (V) value;
        return this.value = val;
    }
}
