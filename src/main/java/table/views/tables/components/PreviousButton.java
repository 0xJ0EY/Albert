package table.views.tables.components;

import javafx.scene.control.Button;
import table.Table;

public class PreviousButton extends Button {

    private Table controller;
    private int page;

    public PreviousButton(int minPage, int page, Table table) {

        this.setDisable(minPage >= page);

        this.page = page;
        this.controller = table;

        this.getStyleClass().add("pagination_btn");
        
        this.setOnAction(evt -> {
            this.controller.navigate(this.page - 1);
        });
    }
}
