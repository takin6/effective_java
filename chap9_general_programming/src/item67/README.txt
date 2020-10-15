ITEM 67: OPTIMIZE JUDICIOUSLY

- More computing sins are committed in the name of efficiency (without necessarily achieving it) than for any other single reason—including blind stupidity.
- We should forget about small efficiencies, say about 97% of the time: premature optimization is the root of all evil.
- We follow two rules in the matter of optimization:
  Rule 1. Don’t do it.
  Rule 2 (for experts only). Don’t do it yet—that is, not until you have a perfectly clear and unoptimized solution.

- Strive to write good programs rather than fast ones.
  Good programs embody the principle of information hiding: where possible, they localize design decisions within individual components,
  so individual decisions can be changed without affecting the remainder of the system

- Strive to avoid design decisions that limit performance.

- Consider the performance consequences of your API design decisions

- It is a very bad idea to warp an API to achieve good performance.

- Once you’ve carefully designed your program and produced a clear, concise, and well-structured implementation, then it may be time to consider optimization, assuming you’re not already satisfied with the performance of the program.

- measure performance before and after each attempted optimization.


SUMMARY
To summarize, do not strive to write fast programs—strive to write good ones; speed will follow.
But do think about performance while you’re designing systems, especially while you’re designing APIs, wire-level protocols, and persistent data formats.
When you’ve finished building the system, measure its performance. If it’s fast enough, you’re done.
If not, locate the source of the problem with the aid of a profiler and go to work optimizing the relevant parts of the system.
The first step is to examine your choice of algorithms: no amount of low-level optimization can make up for a poor choice of algorithm.
Repeat this process as necessary, measuring the performance after every change, until you’re satisfied.

