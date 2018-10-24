package table.dao.db.selects;

import java.io.Serializable;

public class Select implements Serializable {

    private String key;
    private Object type;

    public Select(String key, Object type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public Object getType() {
        return type;
    }
}
