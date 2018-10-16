package table.factories.columns;

import table.views.ColumnView;
import table.views.columns.TextColumnView;

public class TextColumnViewFactory implements ColumnViewFactory {

    @Override
    public ColumnView create() {
        return new TextColumnView();
    }

}
