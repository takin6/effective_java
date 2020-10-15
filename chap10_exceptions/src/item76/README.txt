ITEM 76: STRIVE FOR FAILURE ATOMICITY

- Generally speaking, a failed method invocation should leave the object in the state that it was in prior to the invocation. A method with this property is said to be failure-atomic.

SUMMARY
In summary, as a rule, any generated exception that is part of a method’s specification should leave the object in the same state it was
in prior to the method invocation. Where this rule is violated, the API documentation should clearly indicate what state the object will be left in.
Unfortunately, plenty of existing API documentation fails to live up to this ideal.