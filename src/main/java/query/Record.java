package query;

import java.util.ArrayList;

public class Record {

    private ArrayList<Object> objects;

    public Record(ArrayList<Object> objects) {
        this.objects = objects;
    }

    public ArrayList<Object> getObjects() {
        return objects;
    }
}
