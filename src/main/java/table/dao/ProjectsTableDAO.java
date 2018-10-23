package table.dao;

import table.Row;
import table.dao.db.DB;

import java.util.ArrayList;

public class ProjectsTableDAO implements TableDAO {

    private int offset = 0;

    private DB query = DB.table("projects");

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int count() {
        return 0;
    }

    public ArrayList<Row> fetch(int limit) {


        return new ArrayList<Row>();
    }

}
