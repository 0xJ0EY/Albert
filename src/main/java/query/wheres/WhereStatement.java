package query.wheres;

import java.io.Serializable;

/**
 * The Interface WhereStatement.
 *
 */
public interface WhereStatement extends Serializable {

    /**
     * Creates the.
     *
     * @param first the first
     * @return the string
     */
    public String create(boolean first);

}
