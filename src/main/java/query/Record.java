package query;

import java.util.ArrayList;
import java.util.HashMap;

public class Record {

    private HashMap<String, Object> objects;

    public Record(HashMap<String, Object> objects) {
        this.objects = objects;
    }

    public HashMap<String, Object> getValues() {
        return this.objects;
    }

    public ArrayList<String> getKeys() {
        return new ArrayList<>(this.objects.keySet());
    }

    public ArrayList<Object> getObjects() {
        return new ArrayList<>(this.objects.values());
    }
}
