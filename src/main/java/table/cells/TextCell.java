package table.cells;

import table.Row;
import table.views.CellView;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class TextCell.
 *
 */
public class TextCell implements Cell {

    /** The row. */
    private Row row;
    
    /** The value. */
    private Object value;
    
    /** The view. */
    private CellView view;
    
    /** The extra columns. */
    private ArrayList<String> extraColumns = new ArrayList<>();

    /**
     * Instantiates a new text cell.
     *
     * @param view the view
     */
    public TextCell(CellView view) {
        this.setView(view);
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#setView(table.views.CellView)
     */
    @Override
    public void setView(CellView view) {
        this.view = view;
        this.view.setCell(this);
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#setValue(java.lang.Object)
     */
    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#setRow(table.Row)
     */
    @Override
    public void setRow(Row row) {
        this.row = row;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#getView()
     */
    @Override
    public CellView getView() {
        return this.view;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#getValue()
     */
    @Override
    public Object getValue() {
        return this.value;
    }

    /* (non-Javadoc)
     * @see table.cells.Cell#getExtraColumns()
     */
    @Override
    public ArrayList<String> getExtraColumns() {
        return this.extraColumns;
    }

}
