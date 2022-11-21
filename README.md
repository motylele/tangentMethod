# Newton's tangent method

Java written program that simulates Newton's tangent method. We change the problem of finding the zero of a function $f : [a,b] \rightarrow R$ into determining the zero of the
tangent to the graph of this function.

## Input specification
In first row of standard input user enters number from $1$ to $4$, depending on the selected example, 
or $x$ if he want to end the program. If we want to enter other example a different example
than those that are in the standard program, you have to modify the source code to add the expected
function and its derivative. In the next line we give the value of first approximation of $x_0$,
such that $f'(x_0) \neq 0$. Then insert the value $\epsilon > 0$.

## Output specification
The program simulates Newton's tangent method; find the root of the function using the tangents to the graph
of the function $f : [a, b] \rightarrow R$ and returns the number of steps needed to find the zero with
accuracy to $\epsilon$ and the zero point.

## Example
$f(x) = x^3 + x + 1, x_0 = -1, \epsilon = 0.25$

### Input
3 </br>
1 </br>
0,025 </br>

### Output
2: -0.686046511627907
