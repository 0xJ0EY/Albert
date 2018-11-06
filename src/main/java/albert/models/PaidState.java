package albert.models;

public enum PaidState {

    PAID("Betaald"),
    NOT_PAID("Niet betaald"),
    WAITING("In afwachting");

    private final String status;

    private PaidState(String status) {
        this.status = status;

    }

    public String toString() {
        return this.status;
    }

}
