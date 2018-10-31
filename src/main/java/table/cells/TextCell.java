package table.cells;

import table.Row;
import table.views.CellView;

import java.util.ArrayList;

public class TextCell implements Cell {

    private Row row;
    private Object value;
    private CellView view;
    private ArrayList<String> extraColumns = new ArrayList<>();

    public TextCell(CellView view) {
        this.setView(view);
    }

    @Override
    public void setView(CellView view) {
        this.view = view;
        this.view.setCell(this);
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void setRow(Row row) {
        this.row = row;
    }

    @Override
    public CellView getView() {
        return this.view;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public ArrayList<String> getExtraColumns() {
        return this.extraColumns;
    }

}
