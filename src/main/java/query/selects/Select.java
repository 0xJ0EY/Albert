package query.selects;

import java.io.Serializable;

public class Select implements Serializable {

    private String key;

    public Select(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
