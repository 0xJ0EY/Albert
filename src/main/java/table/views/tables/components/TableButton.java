package table.views.tables.components;

import javafx.scene.control.Button;

public class TableButton extends Button {

    public TableButton(String name, TableButtonStrategy strategy) {
        super(name);

        this.setOnAction(evt -> { strategy.onClick(); });
    }
}
