package query.orderby;

import java.io.Serializable;

public interface OrderByStatement extends Serializable {

    public String build();

}
