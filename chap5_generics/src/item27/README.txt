ITEM 27: ELIMINATE UNCHECKED WARNINGS

- If you can’t eliminate a warning, but you can prove that the code that provoked the warning is typesafe, then (and only then) suppress the warning with an @SuppressWarnings("unchecked") annotation.


SUMMARY
In summary, unchecked warnings are important. Don’t ignore them.
Every unchecked warning represents the potential for a ClassCastException at runtime.
Do your best to eliminate these warnings.
If you can’t eliminate an unchecked warning and you can prove that the code that provoked it is typesafe,
suppress the warning with a @SuppressWarnings("unchecked") annotation in the narrowest possible scope.
Record the rationale for your decision to suppress the warning in a comment.