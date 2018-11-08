package query.builders;

import query.orderby.OrderBy;

import java.util.ArrayList;

public class OrderByQueryBuilder implements OrderByQueryBuilderInterface {

    private ArrayList<OrderBy> orderBy = new ArrayList<>();

    @Override
    public void orderBy(String value, String direction) {
        this.orderBy.add(new OrderBy(value, direction));
    }

    @Override
    public void clearOrderBy() {
        this.orderBy = new ArrayList<>();
    }

    @Override
    public String build() {
        ArrayList<String> parts = new ArrayList<>();

        for (OrderBy order : this.orderBy)
            parts.add(order.build());

        return this.orderBy.size() > 0 ? " ORDER BY " + String.join(", ", parts) : "";
    }
}
