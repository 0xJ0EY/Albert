/*
 * 
 */
package table.views.tables.components;

import javafx.scene.control.Button;

// TODO: Auto-generated Javadoc
/**
 * The Class TableButton.
 * @author
 */
public class TableButton extends Button {

    /**
     * Instantiates a new table button.
     *
     * @param name the name
     * @param strategy the strategy
     */
    public TableButton(String name, TableButtonStrategy strategy) {
        super(name);

        this.getStyleClass().add("button");

        this.setOnAction(evt -> { strategy.onClick(); });
    }
}
