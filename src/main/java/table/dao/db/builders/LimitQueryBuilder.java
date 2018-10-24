package table.dao.db.builders;

public class LimitQueryBuilder implements LimitQueryBuilderInterface {

    private final String format = " LIMIT %d";
    private int limit = -1;

    @Override
    public void limit(int limit) {
        this.limit = limit;
    }

    @Override
    public String build() {
        if (limit < 0)
            return "";

        return String.format(this.format, this.limit);
    }

    @Override
    public void clearLimit() {
        this.limit = -1;
    }
}
