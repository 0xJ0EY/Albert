package query.builders;

public interface OrderByQueryBuilderInterface extends QueryBuilderInterface {

    public void orderBy(String value, String direction);

    public void clearOrderBy();

}
