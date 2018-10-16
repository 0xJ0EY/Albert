package table.factories.rows;

import table.views.RowView;
import table.views.rows.BaseRowView;

public class BaseRowFactory implements RowViewFactory {

    @Override
    public RowView create() {
        return new BaseRowView();
    }
}
