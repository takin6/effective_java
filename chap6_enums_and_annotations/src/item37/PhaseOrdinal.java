package item37;

// Using ordinal() to index array of arrays - DON'T DO THIS!

public enum PhaseOrdinal {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // Rows indexed by from-ordinal, cols by to-ordinal
        private static final Transition[][] TRANSITIONS = {
                { null, MELT, SUBLIME},
                { FREEZE, null, BOIL},
                { DEPOSIT,CONDENSE,null}
        };

        public static Transition from(PhaseOrdinal from, PhaseOrdinal to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }


}
