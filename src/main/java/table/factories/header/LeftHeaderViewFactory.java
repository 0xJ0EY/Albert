package table.factories.header;

import table.views.HeaderView;
import table.views.header.LeftHeaderView;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating LeftHeaderView objects.
 *
 */
public class LeftHeaderViewFactory implements HeaderViewFactory {

    /** The name. */
    private String name;

    /**
     * Instantiates a new left header view factory.
     *
     * @param name the name
     */
    public LeftHeaderViewFactory(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see table.factories.header.HeaderViewFactory#create()
     */
    @Override
    public HeaderView create() {
        return new LeftHeaderView(this.name);
    }

}
