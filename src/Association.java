import java.util.Map;

/**
 * Class that extends from Comparable, used to represent the link of a word in english and the same word in spanish
 * @param <K> the word in english
 * @param <V> the word in spanish
 * @author Gustavo Méndez
 * @since 21/03/2019
 * @version 1.0
 */
public class Association<K extends Comparable<K>,V> implements Comparable<Association<K,V>>{

    //Key = english
    private K key;
    //Value = spanish
    private V value;

    /**
     * Constructs a new Asociation with an specific key and value
     * @param key the key of the association (word in english)
     * @param value the value of the association (word in spanish)
     */
    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Get the Association key
     * @return the generic key, specifically the word in english
     */
    public Object getKey() {
        return key;
    }

    /**
     * Get the Association value
     * @return the word in spanish
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets an specific value to the Association
     * @param value the value to set to the Association
     * @return the added value
     */
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
