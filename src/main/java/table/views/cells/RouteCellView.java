package table.views.cells;

import config.Config;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import table.cells.Cell;
import table.cells.RouteCell;
import table.cells.TextCell;
import table.exceptions.ViewNotFoundException;
import table.views.CellView;

public class RouteCellView extends AnchorPane implements CellView {

    @FXML
    private Label label;

    private final String resource = "/views/table/cells/RouteCellView.fxml";
    private RouteCell controller;

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

        Object value = this.controller.getValue();

        this.label.setText(value != null ? value.toString() : Config.get("table", "settings.empty"));
    }

    @Override
    public Priority getPriority() {
        return Priority.ALWAYS;
    }

    @Override
    public void setCell(Cell cell) {
        this.controller = (RouteCell) cell;
    }

    @Override
    public AnchorPane render() {
        return this;
    }

    @FXML
    public void onClickCell() {
        this.controller.nav();
    }

}