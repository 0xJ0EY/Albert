package table.dao.db.util;

public class SqlFormatter {

    public static String formatValue(Object val) {
        Object obj = val.getClass();

        if (obj == String.class) {
            return '"' + val.toString() + '"';
        }

        return val.toString();
    }

}
