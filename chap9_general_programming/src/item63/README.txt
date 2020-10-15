ITEM 63: BEWARE THE PERFORMANCE OF STRING CONCATENATION

- Using the string concatenation operator repeatedly to concatenate n strings requires time quadratic in n

-  To achieve acceptable performance, use a StringBuilder in place of a String



SUMMARY
The moral is simple: Don’t use the string concatenation operator to combine more than a few strings unless performance is irrelevant.
Use StringBuilder’s append method instead. Alternatively, use a character array, or process the strings one at a time instead of combining them.