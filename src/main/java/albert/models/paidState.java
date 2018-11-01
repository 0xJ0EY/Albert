package albert.models;

public enum paidState {
    paid {
        public String toString() {
            return "Betaald";
        }
    },

    notPaid {
        public String toString() {
            return "Niet betaald";
        }
    },
    waiting {
        public String toString() {
            return "In afwachting";
        }
    }
}
