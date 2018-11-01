package albert.models;

public enum PaidState {
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
