package query.builders;

public interface LimitQueryBuilderInterface extends QueryBuilderInterface {

    public void limit(int limit);

    public void clearLimit();

}
