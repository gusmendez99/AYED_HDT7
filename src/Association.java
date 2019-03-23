import java.util.Map;

public class Association<K extends Comparable<K>,V> implements Comparable<Association<K,V>>{

    //Key = english
    private K key;
    //Value = spanish
    private V value;

    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(Object value) {
        V val = (V) value;
        return this.value = val;
    }

    @Override
    public int compareTo(Association<K, V> o) {
        Association ob = (Association) o;
        return key.toString().compareToIgnoreCase(ob.key.toString());
    }
}
