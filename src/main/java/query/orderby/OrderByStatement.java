package query.orderby;

import java.io.Serializable;

/**
 * The Interface OrderByStatement.
 *
 */
public interface OrderByStatement extends Serializable {

    /**
     * Builds the.
     *
     * @return the string
     */
    public String build();

}
