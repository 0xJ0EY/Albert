package table.views.rows;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import table.Column;
import table.Row;
import table.exceptions.ViewNotFoundException;
import table.views.RowView;

import java.util.ArrayList;

public class BaseRowView extends HBox implements RowView {

    private final String resource = "/views/table/rows/BaseRowView.fxml";
    private Row row;

    @Override
    public void load() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(this.resource));

        loader.setController(this);
        loader.setRoot(this);

        try {
            loader.load();
        } catch (Exception ex) {
            throw new ViewNotFoundException();
        }
    }

    @Override
    public void update() {
        // Render the row items

        Object[] objects = this.row.getData();
        ArrayList<Column> cols = this.row.getTable().getCols();

        for (int i = 0; i < objects.length; i++) {
//            Object obj = objects[i];
//            Column col = cols.get(i);

//            col.match().setValue();
//






        }

        for (Object obj : this.row.getData()) {



            System.out.println("obj = " + obj);

        }




//        for ()


    }

    @Override
    public void setRow(Row row) {
        this.row = row;
    }

    @Override
    public HBox render() {
        return this;
    }
}
