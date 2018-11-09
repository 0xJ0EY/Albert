package table.factories.header;

import table.views.HeaderView;
import table.views.header.RightHeaderView;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating RightHeaderView objects.
 *
 */
public class RightHeaderViewFactory implements HeaderViewFactory {

    /** The name. */
    private String name;

    /**
     * Instantiates a new right header view factory.
     *
     * @param name the name
     */
    public RightHeaderViewFactory(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see table.factories.header.HeaderViewFactory#create()
     */
    @Override
    public HeaderView create() {
        return new RightHeaderView(this.name);
    }

}
