ITEM 49: CHECK PARAMETERS FOR VALIDITY

- For public and protected methods, use the Javadoc @throws tag to document the exception that will be thrown if a restriction on parameter values is violated

- The Objects.requireNonNull method, added in Java 7, is flexible and convenient, so there’s no reason to perform null checks manually anymore.

- For an unexported method, you, as the package author, control the circumstances under which the method is called,
  so you can and should ensure that only valid parameter values are ever passed in.
  Therefore, nonpublic methods can check their parameters using assertions

- An important exception is the case in which the validity check would be expensive or impractical and the check is performed implicitly in the process of doing the computation.
    ex) Collections.sort(List

SUMMARY
To summarize, each time you write a method or constructor, you should think about what restrictions exist on its parameters.
You should document these restrictions and enforce them with explicit checks at the beginning of the method body.
It is important to get into the habit of doing this. The modest work that it entails will be paid back with interest the first time a validity check fails.
