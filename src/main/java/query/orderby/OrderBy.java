package query.orderby;

/**
 * The Class OrderBy.
 *
 */
public class OrderBy implements OrderByStatement {

    /** The name. */
    private String name;
    
    /** The direction. */
    private String direction;

    /**
     * Instantiates a new order by.
     *
     * @param name the name
     * @param direction the direction
     */
    public OrderBy(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    /* (non-Javadoc)
     * @see query.orderby.OrderByStatement#build()
     */
    @Override
    public String build() {
        return this.name + " " + this.direction;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the direction.
     *
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the direction.
     *
     * @param direction the new direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
