package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.views.RapportsEditView;
import router.factories.pages.EditPageFactory;
import router.pages.EditPage;
import albert.controllers.templates.MenuTemplateController;

public class RapportsEditPageFactory implements EditPageFactory {

    @Override
    public EditPage create() {
        return new RapportsController(new RapportsEditView(), new MenuTemplateController());
    }
}
