package query.builders;

public interface JoinQueryBuilderInterface extends QueryBuilderInterface {

    public void join(String table, String key, String operator, String value);

    public void leftJoin(String table, String key, String operator, String value);

    public void rightJoin(String table, String key, String operator, String value);

}
