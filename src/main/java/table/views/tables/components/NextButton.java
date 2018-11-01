package table.views.tables.components;

import javafx.scene.control.Button;
import table.Table;

public class NextButton extends Button {

    private Table controller;
    private int page;

    public NextButton(int maxPage, int page, Table table) {

        this.setDisable(maxPage <= page);

        this.page = page;
        this.controller = table;

        this.getStyleClass().add("pagination_btn");
        
        this.setOnAction(evt -> {
            this.controller.navigate(this.page + 1);
        });
    }
}
