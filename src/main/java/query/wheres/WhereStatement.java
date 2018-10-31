package query.wheres;

import java.io.Serializable;

public interface WhereStatement extends Serializable {

    public String create(boolean first);

}
