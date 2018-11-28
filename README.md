## Java Rubik's Cube Solver

### Overview
This program uses a BFS algorithm to find the shortest solution for solving a Rubik's cube given the starting scrambled state. It prunes moves that would return it to any previous state to try and start minimizing the number of possible states.

### Performance
The performance of this algorithm is honestly not great. If given enough time (and memory...) it will eventually solve the cube in the shortest number of moves. However, in my own personal testing, I could not get a solution for more than 5 moves, not because the algorithm failed but because my patience did.

### Next steps
The reason I wrote this in Java is because that's the language I originally learned BFS in at school. I would like to reimplement this in a couple programming languages (Python and C would be my first choices), and use this as an opportunity to evaluate the algorithm, as well as the efficiency of a couple different programming languages at solving this problem.
