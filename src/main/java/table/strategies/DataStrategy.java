package table.strategies;

import table.Table;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataStrategy.
 *
 */
public interface DataStrategy {

    /**
     * Gets the max page.
     *
     * @return the max page
     */
    public int getMaxPage();

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage();

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit();

    /**
     * Sets the page.
     *
     * @param page the new page
     */
    public void setPage(int page);

    /**
     * Sets the table.
     *
     * @param table the new table
     */
    public void setTable(Table table);

    /**
     * Sets the limit.
     *
     * @param limit the new limit
     */
    public void setLimit(int limit);

    /**
     * Gets the table.
     *
     * @return the table
     */
    public Table getTable();

    /**
     * Fetch.
     */
    public void fetch();

    /**
     * Order by.
     *
     * @param column the column
     * @param direction the direction
     */
    public void orderBy(String column, String direction);

    /**
     * Search.
     *
     * @param str the str
     */
    public void search(String str);

}
