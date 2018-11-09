package albert.components;

import javafx.scene.control.Label;
import router.action.TemplateAction;


/**
 * The Class ActionTemplateButton.
 * Creates the actionbutton
 *
 */
public class ActionTemplateButton extends Label {

    /**
     * Instantiates a new action template button.
     *
     * @param text the text
     * @param action the action
     */
    public ActionTemplateButton(String text, TemplateAction action) {
        super(text);

        this.getStyleClass().add("template_action");

        this.setOnMouseClicked((evt) -> { action.onClick(); });

    }
}
