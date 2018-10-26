package table.views.tables;

import javafx.scene.control.Button;
import table.Table;

public class PaginationButton extends Button {

    private Table controller;
    private int page;

    public PaginationButton(String text, int page, Table table) {
        super(text);
        this.page = page;
        this.controller = table;
        
        this.setOnAction(evt -> {
            this.controller.navigate(this.page);
        });
    }
}
