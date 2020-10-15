ITEM 75: INCLUDE FAILURE-CAPTURE INFORMATION IN DETAIL MESSAGES


SUMMARY
As suggested in Item 70, it may be appropriate for an exception to provide accessor methods for its failure-capture information (lowerBound, upperBound, and index in the above example).
It is more important to provide such accessor methods on checked exceptions than unchecked,
because the failure-capture information could be useful in recovering from the failure.
It is rare (although not inconceivable) that a programmer might want programmatic access to the details of an unchecked exception.
Even for unchecked exceptions, however, it seems advisable to provide these accessors on general principle (Item 12, page 57).