package albert.models;

/**
 * The Enum PaidState.
 *
 */
public enum PaidState {

    /** The paid. */
    PAID("Betaald"),
    
    /** The not paid. */
    NOT_PAID("Niet betaald"),
    
    /** The waiting. */
    WAITING("In afwachting");

    /** The status. */
    private final String status;

    /**
     * Instantiates a new paid state.
     *
     * @param status the status
     */
    private PaidState(String status) {
        this.status = status;

    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    public String toString() {
        return this.status;
    }

}
