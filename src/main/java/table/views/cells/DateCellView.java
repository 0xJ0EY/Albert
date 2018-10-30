package table.views.cells;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.Cell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCellView extends AnchorPane implements CellView<String> {

    @FXML
    private Label label;

    private final String resource = "/views/table/cells/TextCellView.fxml";
    private Cell value;

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
        String input = this.value.getObject().toString();



        // Format the string

        try {
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSX");

            Date date = parser.parse(input);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

            String output = formatter.format(date);

            this.label.setText(output);

        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Priority getPriority() {
        return Priority.ALWAYS;
    }

    @Override
    public void setCell(Cell cell) {
        this.value = cell;
    }

    @Override
    public boolean match(Object object) {
        return true;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

}
