package query;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Record.
 *
 */
public class Record {

    /** The objects. */
    private HashMap<String, Object> objects;

    /**
     * Instantiates a new record.
     *
     * @param objects the objects
     */
    public Record(HashMap<String, Object> objects) {
        this.objects = objects;
    }

    /**
     * Gets the values.
     *
     * @return the values
     */
    public HashMap<String, Object> getValues() {
        return this.objects;
    }

    /**
     * Gets the keys.
     *
     * @return the keys
     */
    public ArrayList<String> getKeys() {
        return new ArrayList<>(this.objects.keySet());
    }

    /**
     * Gets the objects.
     *
     * @return the objects
     */
    public ArrayList<Object> getObjects() {
        return new ArrayList<>(this.objects.values());
    }
}
