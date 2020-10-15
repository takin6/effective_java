ITEM 70: USE CHECKED EXCEPTIONS FOR RECOVERABLE CONDITIONS AND RUNTIME EXCEPTIONS FOR PROGRAMMING ERRORS

- Java provides three kinds of throwables: checked exceptions, runtime exceptions, and errors.
  - checked exceptions : コンパイル時にチェックされる例外
  - unchecked exceptions : コンパイル時にチェックされない例外

- The cardinal rule in deciding whether to use a checked or an unchecked exception is this:
    "use checked exceptions for conditions from which the caller can reasonably be expected to recover"

- There are two kinds of unchecked throwables: runtime exceptions and errors.

- Use runtime exceptions to indicate programming errors.
  - errors are reserved for use by the JVM to indicate resource deficiencies, invariant failures, or other conditions that make it impossible to continue execution.

- it’s best not to implement any new Error subclasses.
  Therefore, all of the unchecked throwables you implement should subclass RuntimeException


SUMMARY
To summarize, throw checked exceptions for recoverable conditions and unchecked exceptions for programming errors.
When in doubt, throw unchecked exceptions. Don’t define any throwables that are neither checked exceptions nor runtime exceptions.
Provide methods on your checked exceptions to aid in recovery.
