/*
 * 
 */
package table.views.tables.components;

import javafx.scene.control.Button;
import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PreviousButton.
 * @author
 */
public class PreviousButton extends Button {

    /** The controller. */
    private Table controller;
    
    /** The page. */
    private int page;

    /**
     * Instantiates a new previous button.
     *
     * @param minPage the min page
     * @param page the page
     * @param table the table
     */
    public PreviousButton(int minPage, int page, Table table) {

        this.setDisable(minPage >= page);

        this.setText("<");

        this.page = page;
        this.controller = table;

        this.getStyleClass().add("pagination_btn");
        
        this.setOnAction(evt -> {
            this.controller.navigate(this.page - 1);
        });
    }
}
