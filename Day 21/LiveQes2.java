/*
Question ->
 * you are given two integers X and Y . 
In one operation , you can select integer i, such that ith bit is set in the binary representation of X, and reduce X by 2^i ( means 2 ka power i).

It is given that you can apply the operation any number of times(possibly zero).
Find the greatest Integer obtained from X, which is strictly less than Y.


Input format:
The first line contains an integer X, denoting the value of X.
The second line contains an integer Y, denoting the value of Y.

constraints:
1 <= X <= 10^9
1 <= Y <= 10^9


 
SAMPLE INPUT:                                 SAMPLE OUTPUT :                             EXPLANATION:


EXAMPLE 1 -
2                                                  2                                       X is already less than Y.
3                                                                                          so answer will be 2 only.



EXAMPLE 2-
3                                                  1                                      we can remove 2 from X, (X is 11 in binary and 1st bit is on). 
2                                                                                          Thus answer will be 1.



EXAMPLE 3-
13                                                9                                         we can remove 4 from X,(X is 1101 in binary, and 2nd bit is on).
10                                                                                           Thus answer will be 9.
 */

public class LiveQes2 {

}
