# Zorvyn SDE Intern OA

---

## Question 1: Magical Bridges

### Problem Statement

In the kingdom of Algorithmia, there are N cities numbered from 1 to N, connected by M bidirectional roads. Each road has a certain travel time associated with it.

The kingdom also has K magical bridges. Each magical bridge connects two cities and has zero travel time, but each bridge can only be used once during your entire journey. You cannot use more than K magical bridges in total.

You are a traveler starting from city 1 and want to reach city N.

Find the minimum time required to travel from city 1 to city N using at most K magical bridges.

---

### Input Format

* The first line contains three space-separated integers N, M, and K.
* The next M lines each contain three integers u, v, w representing a road between cities u and v with travel time w.
* The next K lines each contain two integers a, b representing a magical bridge between cities a and b.

---

### Output Format

* Print a single integer — the minimum time to reach city N from city 1.
* If it is impossible to reach city N, print -1.

---

### Examples

#### Example 1

```
Input:
4 4 1
1 2 10
2 4 10
1 3 5
3 4 20
1 4

Output:
0
```

#### Example 2

```
Input:
4 4 1
1 2 10
2 4 10
1 3 5
3 4 20
2 3

Output:
15
```

#### Example 3

```
Input:
3 1 0
1 2 10

Output:
-1
```

---

### Explanation

* Example 1: Use the magical bridge from city 1 directly to city 4, taking 0 time.
* Example 2: Optimal path: 1 -> 3 (time 5) -> magical bridge to 2 (time 0) -> 4 (time 10). Total = 15.
* Example 3: No path exists from city 1 to city 3 without magical bridges.

---

### Note

* Magical bridges are bidirectional.
* You can choose to not use all K magical bridges.
* Regular roads can be used multiple times.

---

### Constraints

* 2 ≤ N ≤ 10^4
* 1 ≤ M ≤ 5 × 10^4
* 0 ≤ K ≤ 10
* 1 ≤ u, v, a, b ≤ N
* 1 ≤ w ≤ 10^6

Time Limit: 3 seconds
Memory Limit: 256 MB

---

## Question 2 : Corporate Hierarchy

### Problem Statement

A company has N employees numbered from 1 to N. Employee 1 is the CEO, and every other employee has exactly one direct manager, forming a tree structure (corporate hierarchy).

Each employee i has a productivity value P[i] which can be positive (good performer), negative (problematic), or zero.

The company wants to select a subset of employees for a special project. However, there is a constraint: if an employee is selected, their direct manager cannot be selected (and vice versa). This is because the project requires independent decision-making.

Find the maximum sum of productivity values achievable by selecting a valid subset of employees.

---

### Input Format

* First line contains a single integer N.
* Second line contains N space-separated integers representing productivity values P[1], P[2], ..., P[N].
* Next N-1 lines each contain two integers u and v representing that u is the direct manager of v.

---

### Output Format

* Print a single integer - the maximum sum of productivity values of a valid selection.

---

### Examples*

#### Example 1

```
Input:
5
1 2 3 4 5
1 2
1 3
2 4
2 5

Output:
12
```

#### Example 2

```
Input:
4
10 -5 -5 20
1 2
1 3
2 4

Output:
30
```

#### Example 3

```
Input:
3
-1 -2 -3
1 2
1 3

Output:
0
```

---

### Explanation

* Example 1:

```
        1(1)
        / \
    2(2)    3(3)
    /          \
4(4)            5(5)
```

Optimal selection: employees 3, 4, 5 with productivity 3 + 4 + 5 = 12.

* Example 2: Select employees 1 and 4: 10 + 20 = 30. (1 is not the direct manager of 4, so this is valid)

* Example 3: All employees have negative productivity. Select no one for sum = 0.

---

### Note

* An empty selection (selecting no one) is valid and has sum 0.
* The constraint is between direct manager and direct subordinate only.

---

### Constraints

* 1 ≤ N ≤ 2 × 10^5
* -10^4 ≤ P[i] ≤ 10^4

Time Limit: 2 seconds
Memory Limit: 256 MB

---

## Question 3 : Encrypted Messages

### Problem Statement

You are working on decrypting ancient messages. You have a text string T and a pattern string P. The pattern may contain two special wildcard characters:

* '?'  - matches exactly one character (any character)

* '*' matches zero or more characters (any sequence, including empty)

Find all starting positions (0-indexed) in the text where the pattern matches a substring starting at that position.

---

### Input Format

* First line contains the text string T.
* Second line contains the pattern string P.

---

### Output Format

* First line: the count of matches.
* Second line: space-separated starting positions of all matches in increasing order.
* If no matches are found, print 0 on the first line and leave the second line empty.

---

### Examples

#### Example 1

```
Input:
abcabc
a?c

Output:
2
0 3
```

#### Example 2

```
Input:
abcdefgh
a*h

Output:
1
0
```

#### Example 3

```
Input:
aaaaaa
a*a

Output:
5
0 1 2 3 4
```

#### Example 4

```
Input:
hello
x?z

Output:
0
```

---

### Explanation

* Example 1:

  * Position 0: "abc" matches "a?c" (? matches 'b')
  * Position 3: "abc" matches "a?c" (? matches 'b')

* Example 2:

  * Position 0: "abcdefgh" matches "ah" (* matches "bcdefg")

* Example 3:

  * Each position from 0 to 4 has a matching substring starting there.

---

### Note

* '*' matches any sequence including empty string.
* ? must match exactly one character.
* A pattern that is just * matches at every position.

---

### Constraints

* 1 ≤ |T| ≤ 10^5
* 1 ≤ |P| ≤ 10^3
* T contains only lowercase English letters.
* P contains lowercase English letters, ?, and *.
* P will not have consecutive * characters.

Time Limit: 3 seconds
Memory Limit: 256 MB
