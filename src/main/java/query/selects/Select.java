package query.selects;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Select.
 * @author
 */
public class Select implements Serializable {

    /** The key. */
    private String key;

    /**
     * Instantiates a new select.
     *
     * @param key the key
     */
    public Select(String key) {
        this.key = key;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

}
