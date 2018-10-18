package table.factories.header;

import table.views.HeaderView;
import table.views.header.CenterHeaderView;

public class CenterHeaderViewFactory implements HeaderViewFactory {

    private String name;

    public CenterHeaderViewFactory(String name) {
        this.name = name;
    }

    @Override
    public HeaderView create() {
        return new CenterHeaderView(this.name);
    }
}
