package table.dao.db.builders;

public interface LimitQueryBuilderInterface extends QueryBuilderInterface {

    public void limit(int limit);

    public void clearLimit();

}
