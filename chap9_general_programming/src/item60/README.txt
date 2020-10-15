ITEM 60: AVOID FLOAT AND DOUBLE IF EXACT ANSWERS ARE REQUIRED

- The float and double types are designed primarily for scientific and engineering calculations.
  They perform binary floating-point arithmetic, which was carefully designed to furnish accurate approximations quickly over a broad range of magnitudes.
- The float and double types are particularly ill-suited for monetary calculations

- There are, however, two disadvantages to using BigDecimal:
  it’s a lot less convenient than using a primitive arithmetic type, and it’s a lot slower.
  The latter disadvantage is irrelevant if you’re solving a single short problem, but the former may annoy you.

- An alternative to using BigDecimal is to use int or long, depending on the amounts involved, and to keep track of the decimal point yourself.
  In this example, the obvious approach is to do all computation in cents instead of dollars. Here’s a straightforward transformation that takes this approach:

SUMMARY
In summary, don’t use float or double for any calculations that require an exact answer.
Use BigDecimal if you want the system to keep track of the decimal point and you don’t mind the inconvenience and cost of not using a primitive type.
Using BigDecimal has the added advantage that it gives you full control over rounding, letting you select from eight rounding modes whenever an operation that entails rounding is performed.
This comes in handy if you’re performing business calculations with legally mandated rounding behavior.
If performance is of the essence, you don’t mind keeping track of the decimal point yourself, and the quantities aren’t too big, use int or long.
If the quantities don’t exceed nine decimal digits, you can use int; if they don’t exceed eighteen digits, you can use long.
If the quantities might exceed eighteen digits, use BigDecimal.