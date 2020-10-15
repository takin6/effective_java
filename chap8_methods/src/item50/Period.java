package item50;

import java.util.Date;

public class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
//    public Period(Date start, Date end) {
//        if (start.compareTo(end) > 0)
//            throw new IllegalArgumentException(start + " after " + end);
//        // Date is obsolete and should no longer be used in new code.
//        this.start = start;
//        this.end = end;
//    }
    // Repaired constructor - makes defensive copies of parameters
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }

//    public Date start() {
//        return start;
//    }
    // return defensive copies of mutable internal fields
    public Date start() {
        return new Date(start.getTime());
    }

//    public Date end() {
//        return end;
//    }
    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }
}
