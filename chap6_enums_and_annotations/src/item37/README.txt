ITEM 37: USE ENUMMAP INSTEAD OF ORDINAL INDEXING


SUMMARY
In summary, it is rarely appropriate to use ordinals to index into arrays: use EnumMap instead.
If the relationship you are representing is multidimensional, use EnumMap<..., EnumMap<...>>.
This is a special case of the general principle that application programmers should rarely, if ever, use Enum.ordinal