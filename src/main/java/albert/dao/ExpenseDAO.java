package albert.dao;

import albert.models.Expense;
import albert.models.Invoice;
import albert.models.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO implements DAO{
    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public Object loadById(long id) {
        return null;
    }

    @Override
    public void create(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public ArrayList<Invoice> extractFromResultSet(ResultSet rs) throws SQLException {
        return null;
    }
    public List<Expense> getByProject(Project project){
        return null;
    }
}
