package table.factories.header;

import table.views.HeaderView;
import table.views.header.CenterHeaderView;

public class CenterHeaderViewFactory implements HeaderViewFactory {

    @Override
    public HeaderView create() {
        return new CenterHeaderView();
    }
}
