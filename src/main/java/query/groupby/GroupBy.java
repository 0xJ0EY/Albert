package query.groupby;

public class GroupBy implements GroupByStatement {

    private String value;

    public GroupBy(String value) {
        this.value = value;
    }

    @Override
    public String build() {
        return this.value;
    }
}
