package table.factories.header;

import table.views.HeaderView;
import table.views.header.RightHeaderView;

public class RightHeaderViewFactory implements HeaderViewFactory {

    private String name;

    public RightHeaderViewFactory(String name) {
        this.name = name;
    }

    @Override
    public HeaderView create() {
        return new RightHeaderView(this.name);
    }

}
