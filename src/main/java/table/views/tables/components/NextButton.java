/*
 * 
 */
package table.views.tables.components;

import javafx.scene.control.Button;
import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class NextButton.
 *
 */
public class NextButton extends Button {

    /** The controller. */
    private Table controller;
    
    /** The page. */
    private int page;

    /**
     * Instantiates a new next button.
     *
     * @param maxPage the max page
     * @param page the page
     * @param table the table
     */
    public NextButton(int maxPage, int page, Table table) {

        this.setDisable(maxPage <= page);

        this.setText(">");

        this.page = page;
        this.controller = table;

        this.getStyleClass().add("pagination_btn");
        
        this.setOnAction(evt -> {
            this.controller.navigate(this.page + 1);
        });
    }
}
