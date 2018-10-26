package table.factories.header;

import table.views.HeaderView;
import table.views.header.LeftHeaderView;

public class LeftHeaderViewFactory implements HeaderViewFactory {

    private String name;

    public LeftHeaderViewFactory(String name) {
        this.name = name;
    }

    @Override
    public HeaderView create() {
        return new LeftHeaderView(this.name);
    }

}
