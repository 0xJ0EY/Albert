package table.views.tables.components;

import javafx.scene.control.Button;
import table.Table;

public class PaginationButton extends Button {

    private Table controller;
    private int page;

    public PaginationButton(String text, int page, Table table) {
        super(text);
        this.page = page;
        this.controller = table;

        this.getStyleClass().add("pagination_btn");
        
        this.setOnAction(evt -> {
            this.controller.navigate(this.page);
        });
    }
}
