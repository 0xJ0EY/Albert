/*
 * 
 */
package table.views.tables.components;

import javafx.scene.control.Button;
import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginationButton.
 * @author
 */
public class PaginationButton extends Button {

    /** The controller. */
    private Table controller;
    
    /** The page. */
    private int page;

    /**
     * Instantiates a new pagination button.
     *
     * @param text the text
     * @param page the page
     * @param table the table
     */
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
