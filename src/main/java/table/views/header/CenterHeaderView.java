package table.views.header;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import table.exceptions.ViewNotFoundException;
import table.views.HeaderView;

public class CenterHeaderView extends AnchorPane implements HeaderView {

    @FXML
    private Label label;

    private final String resource = "/views/table/header/CenterHeaderView.fxml";
    private String name;

    public CenterHeaderView(String name) {
        this.name = name;
    }

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
        this.label.setText(this.name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public AnchorPane render() {
        return this;
    }
}
