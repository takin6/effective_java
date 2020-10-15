ITEM 53: USE VARARGS JUDICIOUSLY

- VARARGS: variable arity methods
- Varargs were designed for printf
- Exercise care when using varargs in performance-critical situations.
  Every invocation of a varargs method causes an array allocation and initialization.
  If you have determined empirically that you can’t afford this cost but you need the flexibility of varargs, there is a pattern that lets you have your cake and eat it too.
  Suppose you’ve determined that 95 percent of the calls to a method have three or fewer parameters.
  Then declare five overloadings of the method, one each with zero through three ordinary parameters, and a single varargs method for use when the number of arguments exceeds three:

  public void foo() { }
  public void foo(int a1) { }
  public void foo(int a1, int a2) { }
  public void foo(int a1, int a2, int a3) { }
  public void foo(int a1, int a2, int a3, int... rest) { }

SUMMARY
In summary, varargs are invaluable when you need to define methods with a variable number of arguments.
Precede the varargs parameter with any required parameters, and be aware of the performance consequences of using varargs.