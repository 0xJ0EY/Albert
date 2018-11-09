package table.factories.header;

import table.views.HeaderView;
import table.views.header.CenterHeaderView;

/**
 * A factory for creating CenterHeaderView objects.
 *
 */
public class CenterHeaderViewFactory implements HeaderViewFactory {

    /** The name. */
    private String name;

    /**
     * Instantiates a new center header view factory.
     *
     * @param name the name
     */
    public CenterHeaderViewFactory(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see table.factories.header.HeaderViewFactory#create()
     */
    @Override
    public HeaderView create() {
        return new CenterHeaderView(this.name);
    }
}
