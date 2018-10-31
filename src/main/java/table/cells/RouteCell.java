package table.cells;

import albert.controllers.PageController;
import router.Route;
import table.Row;
import table.views.CellView;

import java.util.ArrayList;

public class RouteCell implements Cell {

    private Row row;
    private Object value;
    private CellView view;

    private Route route;
    private PageController page;

    public RouteCell(String route, PageController page, CellView view) {
        this.route = new Route(route);
        this.page = page;
        this.setView(view);
    }

    @Override
    public void setView(CellView view) {
        this.view = view;
        this.view.setCell(this);
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public void setRow(Row row) {
        this.row = row;
    }

    private String getRoute() {
        return this.route.buildUrl(this.row.getValues());
    }

    public void nav() {
        this.page.getRouter().nav(this.getRoute());
    }

    @Override
    public CellView getView() {
        return this.view;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public ArrayList<String> getExtraColumns() {
        return this.route.getArgs();
    }

}
