ITEM 39: PREFER ANNOTATIONS TO NAMING PATTERNS

- it was common to use naming patterns to indicate that some program elements demanded special treatment by a tool or framework.



-  tests that succeed only if they throw a particular exception. We’ll need a new annotation type for this:



SUMMARY
That said, with the exception of toolsmiths, most programmers will have no need to define annotation types.
But all programmers should use the predefined annotation types that Java provides (Items 40, 27).
Also, consider using the annotations provided by your IDE or static analysis tools.
Such annotations can improve the quality of the diagnostic information provided by these tools.
Note, however, that these annotations have yet to be standardized, so you may have some work to do if you switch tools or if a standard emerges.