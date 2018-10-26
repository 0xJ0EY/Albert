package query.builders;

public class OffsetQueryBuilder implements OffsetQueryBuilderInterface {

    private final String format = " OFFSET %d";
    private int offset = -1;

    @Override
    public void offset(int offset) {
        this.offset = offset;

    }

    @Override
    public void clearOffset() {
        this.offset = -1;
    }

    @Override
    public String build() {
        if (this.offset < 0)
            return "";

        return String.format(this.format, this.offset);
    }
}
