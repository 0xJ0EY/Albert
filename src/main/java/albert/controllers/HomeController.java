package albert.controllers;

import router.pages.OverviewPage;
import router.templates.TemplateController;
import router.pages.DetailPage;
import router.views.PageView;
import router.Request;
import router.response.Response;
import router.response.ViewResponse;
import table.Column;
import table.Table;
import table.factories.cells.IntCellViewFactory;
import table.factories.cells.TextCellViewFactory;
import table.factories.header.LeftHeaderViewFactory;
import table.factories.header.RightHeaderViewFactory;
import table.strategies.DatabaseStrategy;
import table.views.tables.BaseTableView;

public class HomeController extends PageController implements OverviewPage, DetailPage {

    private Table overviewTable;

    public HomeController(
            PageView view,
            TemplateController template
    ) {
        super(view, template);
    }

    @Override
    public Response overview(Request request) {

        this.overviewTable = new Table(new DatabaseStrategy(), new BaseTableView());

        this.overviewTable.addCol(
            new Column(
                new LeftHeaderViewFactory("Voornaam"),
                new TextCellViewFactory()
            )
        );

        this.overviewTable.addCol(
            new Column(
                    new LeftHeaderViewFactory("Achternaam"),
                    new TextCellViewFactory()
            )
        );

        this.overviewTable.addCol(
            new Column(
                new LeftHeaderViewFactory("Straat"),
                new TextCellViewFactory()
            )
        );

        this.overviewTable.addCol(
            new Column(
                new RightHeaderViewFactory("Leeftijd"),
                new IntCellViewFactory()
            )
        );

        this.overviewTable.addRow("Joey", "De Ruiter", "Valkenburgerweg 7", 20);
        this.overviewTable.addRow("Johhny", "De Ruiter", "Valkenburgerweg 7", 50);

        return new ViewResponse(this);
    }

    @Override
    public Response detail(Request request) {
        return new ViewResponse(this);
    }

    public Table getOverviewTable() {
        return this.overviewTable;
    }
}
