package table.factories.columns;

import table.views.ColumnView;
import table.views.columns.IntColumnView;

public class IntColumnViewFactory implements ColumnViewFactory {

    @Override
    public ColumnView create() {
        return new IntColumnView();
    }
}
