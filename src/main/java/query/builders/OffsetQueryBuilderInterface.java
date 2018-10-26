package table.dao.db.builders;

public interface OffsetQueryBuilderInterface extends QueryBuilderInterface {

    public void offset(int offset);

    public void clearOffset();

}
