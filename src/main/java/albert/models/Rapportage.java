package albert.models;

import java.util.Date;

public class Rapportage {

    private String name;
    private int id;
    private Date startDate;
    private Date endDate;

    public void setName(String name) { this.name = name;   }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }
}
