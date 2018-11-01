package albert.components;

import javafx.scene.control.Label;
import router.action.TemplateAction;

public class ActionTemplateButton extends Label {

    public ActionTemplateButton(String text, TemplateAction action) {
        super(text);

        this.getStyleClass().add("template_action");

        this.setOnMouseClicked((evt) -> { action.onClick(); });

    }
}
