package router.factories.pages.rapports;

import albert.controllers.RapportsController;
import albert.controllers.templates.MenuTemplateController;
import albert.views.RapportsCreateView;
import albert.views.RapportsEditView;
import router.factories.pages.CreatePageFactory;
import router.factories.pages.EditPageFactory;
import router.pages.CreatePage;
import router.pages.EditPage;

public class RapportsCreatePageFactory implements CreatePageFactory {

    @Override
    public CreatePage create() {
        return new RapportsController(new RapportsCreateView(), new MenuTemplateController());
    }
}
