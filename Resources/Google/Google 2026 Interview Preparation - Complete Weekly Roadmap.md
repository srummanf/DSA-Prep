# Google 2026 Interview Preparation - Complete Weekly Roadmap

> **Target**: Crack Google L3/L4/L5 by 2026
> **Duration**: 24 weeks (6 months intensive preparation)
> **Daily Time Commitment**: 3-4 hours minimum

---

## 📑 Table of Contents

1. [Important Links & Resources](#-important-links--resources)
2. [Must-Know Algorithms & Patterns](#-must-know-algorithms--patterns)
3. [Pre-Preparation Checklist](#-pre-preparation-checklist-week-0)
4. [Phase 1: Foundations (Weeks 1-6)](#phase-1-foundations-weeks-1-6)
5. [Phase 2: Core Data Structures (Weeks 7-12)](#phase-2-core-data-structures-weeks-7-12)
6. [Phase 3: Advanced Algorithms (Weeks 13-18)](#phase-3-advanced-algorithms-weeks-13-18)
7. [Phase 4: Problem Solving & System Design (Weeks 19-22)](#phase-4-problem-solving--system-design-weeks-19-22)
8. [Phase 5: Interview Prep & Mock Interviews (Weeks 23-24)](#phase-5-interview-prep--mock-interviews-weeks-23-24)
9. [Weekly Tracking Template](#-weekly-tracking-template)
10. [Daily Routine](#-daily-routine)
11. [Success Metrics](#-success-metrics)

---

## 🔗 Important Links & Resources

### Essential Platforms

- **LeetCode**: https://leetcode.com
- **CSES Problem Set**: https://cses.fi/problemset
- **AtCoder**: https://atcoder.jp
- **Codeforces**: https://codeforces.com
- **CP-Algorithms**: https://cp-algorithms.com
- **USACO Guide**: https://usaco.guide

### LeetCode Study Plans (Must Complete)

- **Dynamic Programming**: https://leetcode.com/studyplan/dynamic-programming/
- **DP Grandmaster**: https://leetcode.com/studyplan/dynamic-programming-grandmaster/
- **Graph Theory**: https://leetcode.com/studyplan/graph-theory/
- **Binary Search**: https://leetcode.com/studyplan/binary-search/
- **Top 100 Liked**: https://leetcode.com/studyplan/top-100-liked/
- **Top Interview 150**: https://leetcode.com/studyplan/top-interview-150/
- **LeetCode 75**: https://leetcode.com/studyplan/leetcode-75/

### Problem Lists (Must Solve)

- **Blind 75**: https://leetcode.com/discuss/post/460599/blind-75-leetcode-questions
- **Google 30 Days**: https://leetcode.com/company/google/?favoriteSlug=google-thirty-days
- **Google Discussion**: https://leetcode.com/discuss/topic/google/
- **Premium Algo 100**: https://leetcode.com/studyplan/premium-algo-100/

### Video Resources

- **Striver A2Z DSA**: https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
- **Vivek Gupta DP**: https://www.youtube.com/playlist?list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy
- **Aditya Verma DP**: https://www.youtube.com/playlist?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go

### Google Specific

- **Googleyness FAQ**: https://leetcode.com/discuss/post/5963463/googlyness-frequently-asked-questions
- **Google Interview Questions**: https://leetcode.com/company/google/

### Advanced Resources

- **Backtracking Framework**: https://labuladong.online/algo/en/essential-technique/backtrack-framework/
- **AtCoder DP Contest**: https://atcoder.jp/contests/dp/tasks

### Books & Documentation

- **Claude API Docs**: https://docs.claude.com
- **System Design Primer**: https://github.com/donnemartin/system-design-primer
- **Cracking the Coding Interview** (Book)

---

## 🎯 Must-Know Algorithms & Patterns

### Core Algorithm Patterns (Master These First)

#### 1️⃣ **Two Pointers** ⭐⭐⭐

**When to use**: Array/string problems with pairs, subarrays, or partitioning
**Variants**:

- **Opposite Direction**: Start from both ends (Two Sum Sorted, Container With Most Water)
- **Same Direction (Fast & Slow)**: Cycle detection, middle element (Linked List Cycle)
- **Sliding Window Fixed**: Fixed size subarray problems
- **Sliding Window Variable**: Variable size with constraints (Longest Substring)

**Must-Solve**:

- Two Sum II, 3Sum, 4Sum, Remove Duplicates from Sorted Array
- Container With Most Water, Trapping Rain Water
- Linked List Cycle, Happy Number

**Time Complexity**: O(n) typically
**Template**:

```python
left, right = 0, len(arr) - 1
while left < right:
    # process arr[left] and arr[right]
    # move pointers based on condition
```

---

#### 2️⃣ **Sliding Window** ⭐⭐⭐

**When to use**: Contiguous subarray/substring problems with optimal conditions
**Types**:

- **Fixed Size Window**: Exact k elements
- **Variable Size Window**: Longest/shortest with constraint
- **Shrinking Window**: Find minimum satisfying condition

**Must-Solve**:

- Longest Substring Without Repeating Characters
- Minimum Window Substring, Sliding Window Maximum
- Permutation in String, Longest Repeating Character Replacement
- Fruit Into Baskets, Max Consecutive Ones III

**Time Complexity**: O(n)
**Template**:

```python
left = 0
for right in range(len(arr)):
    # add arr[right] to window
    while window_invalid:
        # remove arr[left] from window
        left += 1
    # update result
```

---

#### 3️⃣ **Fast & Slow Pointers (Floyd's Algorithm)** ⭐⭐⭐

**When to use**: Cycle detection, middle element, linked list problems
**Applications**:

- Detect cycle in linked list
- Find cycle start point
- Find middle of linked list
- Palindrome linked list check

**Must-Solve**:

- Linked List Cycle I & II
- Find the Duplicate Number
- Happy Number, Middle of Linked List
- Palindrome Linked List

**Time Complexity**: O(n), Space: O(1)

---

#### 4️⃣ **Binary Search** ⭐⭐⭐

**When to use**: Sorted data, monotonic functions, search space reduction
**Variants**:

- **Classic Search**: Find exact target
- **Lower/Upper Bound**: First/last occurrence
- **Search Space on Answer**: Binary search on result range
- **Rotated Array Search**: Modified binary search

**Must-Solve**:

- Binary Search, Search Insert Position
- Find First and Last Position, Search in Rotated Sorted Array
- Find Minimum in Rotated Sorted Array
- Koko Eating Bananas, Minimum Time to Complete Trips
- Capacity To Ship Packages, Split Array Largest Sum

**Time Complexity**: O(log n)
**Template**:

```python
left, right = 0, len(arr) - 1
while left <= right:
    mid = left + (right - left) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```

---

#### 5️⃣ **Depth-First Search (DFS)** ⭐⭐⭐

**When to use**: Tree/graph traversal, backtracking, path finding
**Traversal Orders**:

- **Preorder**: Root → Left → Right (carry-forward)
- **Inorder**: Left → Root → Right (BST sorted order)
- **Postorder**: Left → Right → Root (bubble-up)

**Must-Solve**:

- All tree traversals (recursive & iterative)
- Path Sum I/II/III, Binary Tree Maximum Path Sum
- Number of Islands, Clone Graph
- All Paths from Source to Target

**Time Complexity**: O(V + E) for graphs, O(n) for trees

---

#### 6️⃣ **Breadth-First Search (BFS)** ⭐⭐⭐

**When to use**: Shortest path (unweighted), level-order traversal, minimum steps
**Applications**:

- Level order tree traversal
- Shortest path in grid/graph
- Minimum depth/steps problems
- Surrounding region problems

**Must-Solve**:

- Binary Tree Level Order Traversal, Zigzag Level Order
- Minimum Depth of Binary Tree
- Word Ladder, Rotting Oranges
- 01 Matrix, Walls and Gates

**Time Complexity**: O(V + E)
**Template**:

```python
queue = deque([start])
visited = {start}
while queue:
    node = queue.popleft()
    for neighbor in get_neighbors(node):
        if neighbor not in visited:
            queue.append(neighbor)
            visited.add(neighbor)
```

---

#### 7️⃣ **Dynamic Programming (5 Core Patterns)** ⭐⭐⭐

**Pattern 1: Linear DP (1D)**

- Problems: Climbing Stairs, House Robber, Decode Ways
- Template: `dp[i]` depends on `dp[i-1]`, `dp[i-2]`, etc.

**Pattern 2: 0/1 Knapsack**

- Problems: Subset Sum, Partition Equal Subset, Target Sum
- Template: `dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])`

**Pattern 3: Unbounded Knapsack**

- Problems: Coin Change, Coin Change II, Rod Cutting
- Template: Can use items unlimited times

**Pattern 4: Longest Common Subsequence (LCS)**

- Problems: LCS, Edit Distance, Longest Palindromic Subsequence
- Template: `dp[i][j]` based on matching `s1[i]` and `s2[j]`

**Pattern 5: Longest Increasing Subsequence (LIS)**

- Problems: LIS, Russian Doll Envelopes, Maximum Length of Pair Chain
- Template: O(n²) DP or O(n log n) binary search

**Must-Solve**:

- Climbing Stairs, Min Cost Climbing Stairs, House Robber I/II
- Coin Change I/II, Target Sum, Partition Equal Subset Sum
- Longest Common Subsequence, Edit Distance
- Longest Increasing Subsequence (both solutions)
- Unique Paths I/II, Minimum Path Sum

---

#### 8️⃣ **Backtracking** ⭐⭐⭐

**When to use**: Generate all combinations/permutations, constraint satisfaction
**Common Patterns**:

- Subsets/Combinations
- Permutations
- Sudoku/N-Queens type problems
- Word search in grid

**Must-Solve**:

- Subsets, Subsets II, Combinations, Combination Sum I/II
- Permutations, Permutations II
- Letter Combinations of Phone Number
- Palindrome Partitioning, Word Search

**Time Complexity**: Exponential O(2ⁿ) or O(n!)
**Template**:

```python
def backtrack(path, choices):
    if is_valid_solution(path):
        result.append(path[:])
        return
    for choice in choices:
        # make choice
        path.append(choice)
        backtrack(path, new_choices)
        # undo choice
        path.pop()
```

---

#### 9️⃣ **Monotonic Stack/Queue** ⭐⭐

**When to use**: Next greater/smaller element, sliding window max/min
**Applications**:

- Next Greater/Smaller Element
- Largest Rectangle in Histogram
- Sliding Window Maximum (monotonic deque)
- Trapping Rain Water

**Must-Solve**:

- Next Greater Element I/II, Daily Temperatures
- Largest Rectangle in Histogram, Maximal Rectangle
- Sliding Window Maximum
- Trapping Rain Water

**Time Complexity**: O(n)

---

#### 🔟 **Union-Find (Disjoint Set Union)** ⭐⭐

**When to use**: Connected components, cycle detection, dynamic connectivity
**Optimizations**:

- Path compression
- Union by rank/size

**Must-Solve**:

- Number of Provinces, Redundant Connection
- Accounts Merge, Most Stones Removed
- Number of Islands II (if available)

**Time Complexity**: O(α(n)) ≈ O(1) amortized

---

### Additional Important Patterns

#### 1️⃣1️⃣ **Topological Sort** ⭐⭐

**When to use**: DAG ordering, dependency resolution, course scheduling
**Algorithms**: Kahn's (BFS), DFS-based

**Must-Solve**:

- Course Schedule I/II, Course Schedule IV
- Alien Dictionary, Sequence Reconstruction

---

#### 1️⃣2️⃣ **Dijkstra's Algorithm** ⭐⭐

**When to use**: Shortest path in weighted graph (non-negative weights)

**Must-Solve**:

- Network Delay Time, Path with Maximum Probability
- Cheapest Flights Within K Stops

**Time Complexity**: O((V + E) log V) with heap

---

#### 1️⃣3️⃣ **Trie (Prefix Tree)** ⭐⭐

**When to use**: Prefix matching, autocomplete, word search

**Must-Solve**:

- Implement Trie, Word Search II
- Design Add and Search Words Data Structure

---

#### 1️⃣4️⃣ **Heap (Priority Queue)** ⭐⭐

**When to use**: Top K elements, Kth largest/smallest, merge K sorted

**Must-Solve**:

- Kth Largest Element, Top K Frequent Elements
- Merge K Sorted Lists, Find Median from Data Stream

---

#### 1️⃣5️⃣ **Binary Tree Patterns** ⭐⭐⭐

**10 Recursion Types**:

1. Bubble-up (bottom-up): Max depth, diameter
2. Carry-forward (top-down): Path sum, max ancestor diff
3. Divide & conquer: Merge trees, construct tree
4. Backtracking: All paths, path sum II
5. State aggregation: Invert tree, flatten
6. Multi-tree recursion: Same tree, merge trees

**Must-Solve**:

- Invert Binary Tree, Maximum Depth, Diameter
- Lowest Common Ancestor, Validate BST
- Serialize/Deserialize, Binary Tree Maximum Path Sum

---

#### 1️⃣6️⃣ **Graph Advanced Patterns** ⭐⭐

- **Strongly Connected Components**: Kosaraju's, Tarjan's
- **Minimum Spanning Tree**: Kruskal's, Prim's
- **Bellman-Ford**: Negative weight shortest path
- **Floyd-Warshall**: All pairs shortest path

---

#### 1️⃣7️⃣ **Bit Manipulation Patterns** ⭐

**Key Operations**:

- Set bit: `n | (1 << i)`
- Clear bit: `n & ~(1 << i)`
- Toggle bit: `n ^ (1 << i)`
- Check bit: `(n & (1 << i)) != 0`
- Remove rightmost set bit: `n & (n - 1)`

**Must-Solve**:

- Single Number I/II/III, Number of 1 Bits
- Power of Two, Counting Bits

---

#### 1️⃣8️⃣ **Prefix Sum / Difference Array** ⭐⭐

**When to use**: Range sum queries, subarray sum problems

**Must-Solve**:

- Subarray Sum Equals K, Contiguous Array
- Range Sum Query - Immutable/Mutable

---

#### 1️⃣9️⃣ **Greedy Algorithms** ⭐⭐

**When to use**: Optimization with local optimal choices leading to global optimum

**Must-Solve**:

- Jump Game I/II, Gas Station
- Task Scheduler, Partition Labels
- Meeting Rooms II, Minimum Number of Arrows

---

#### 2️⃣0️⃣ **String Matching Algorithms** ⭐

- **KMP**: Pattern matching in O(n + m)
- **Rabin-Karp**: Rolling hash pattern matching
- **Z-Algorithm**: Pattern matching variants

---

### Pattern Recognition Cheatsheet


| Problem Keyword                | Pattern              | Example                |
| -------------------------------- | ---------------------- | ------------------------ |
| "contiguous subarray"          | Sliding Window       | Max sum subarray       |
| "pairs with sum"               | Two Pointers         | Two Sum Sorted         |
| "cycle in linked list"         | Fast & Slow Pointers | Detect Cycle           |
| "sorted array search"          | Binary Search        | Search Insert Position |
| "all paths/combinations"       | Backtracking         | Subsets, Permutations  |
| "shortest path (unweighted)"   | BFS                  | Word Ladder            |
| "tree traversal"               | DFS                  | Inorder Traversal      |
| "optimize for minimum/maximum" | DP                   | Coin Change            |
| "next greater/smaller"         | Monotonic Stack      | Daily Temperatures     |
| "connected components"         | Union-Find or DFS    | Number of Islands      |
| "kth largest/smallest"         | Heap                 | Kth Largest Element    |
| "prefix matching"              | Trie                 | Implement Trie         |
| "dependency ordering"          | Topological Sort     | Course Schedule        |
| "weighted shortest path"       | Dijkstra             | Network Delay Time     |

---

## 📋 Pre-Preparation Checklist (Week 0)

- [ ]  Set up LeetCode Premium account
- [ ]  Create accounts on CSES, AtCoder, Codeforces
- [ ]  Set up local coding environment (IDE, debugger)
- [ ]  Join Google interview prep communities
- [ ]  Review Big O notation and complexity analysis
- [ ]  Bookmark all resource links from your document

---

## Phase 1: Foundations (Weeks 1-6)

### Week 1: Arrays & Two Pointers

**Goal**: Master array manipulation and sliding window patterns

**Topics**:

- Two pointer technique (fast/slow, left/right)
- Sliding window (fixed and variable size)
- Prefix sum arrays
- Kadane's algorithm

**Practice** (15-20 problems):

- LeetCode: Two Sum, 3Sum, Container With Most Water, Trapping Rain Water
- Sliding Window Maximum, Minimum Window Substring
- Subarray Sum Equals K, Maximum Subarray
- **Daily**: Solve 3 easy, 2 medium problems

**Resources**:

- Striver A2Z Arrays section
- LeetCode Top 100 Liked (Arrays section)

---

### Week 2: Hashing & Strings Basics

**Goal**: Efficient lookups and string manipulation

**Topics**:

- HashMap/HashSet operations
- Frequency counting patterns
- Anagram problems
- Basic string traversal

**Practice** (15-20 problems):

- Group Anagrams, Valid Anagram, Longest Substring Without Repeating
- First Unique Character, Ransom Note
- Isomorphic Strings, Word Pattern
- **Focus**: O(1) lookup time optimization

**Resources**:

- CP-Algorithms (Hashing section)
- LeetCode String tag (Easy-Medium)

---

### Week 3: Linked Lists

**Goal**: Master all 7 linked list patterns

**Topics**:

- Fast & Slow pointers (Floyd's cycle detection)
- Reversing techniques (iterative & recursive)
- Dummy node technique
- List merging and partitioning

**Practice** (12-15 problems):

- All problems from your LinkedList patterns document
- Focus on: Reverse Linked List, Detect Cycle, Merge K Sorted Lists
- LeetCode: Copy List with Random Pointer, LRU Cache
- **Master**: Drawing and visualizing pointer movements

**Resources**:

- Your provided LinkedList patterns
- Visualgo for visual learning

---

### Week 4: Stack & Queue

**Goal**: Understand monotonic structures and BFS patterns

**Topics**:

- Monotonic stack/queue
- Next Greater/Smaller element patterns
- Queue-based BFS
- Deque applications

**Practice** (12-15 problems):

- Daily Temperatures, Largest Rectangle in Histogram
- Sliding Window Maximum (using deque)
- Implement Queue using Stacks, Min Stack
- **Pattern Recognition**: When to use stack vs queue

**Resources**:

- LeetCode Stack/Queue study plan
- Aditya Verma Stack playlist

---

### Week 5: Binary Search

**Goal**: Master all binary search variants

**Topics**:

- Classic binary search
- Search in rotated arrays
- Binary search on answer space
- Peak finding patterns

**Practice** (15-20 problems):

- LeetCode Binary Search study plan (complete it)
- Search in Rotated Sorted Array I & II
- Find Peak Element, Koko Eating Bananas
- Minimum in Rotated Sorted Array
- **Key**: Writing bug-free binary search every time

**Resources**:

- Your binary search study plan link
- USACO Guide Binary Search section

---

### Week 6: Bit Manipulation & Math

**Goal**: Handle bitwise operations and number theory

**Topics**:

- All 8 bit manipulation patterns from your doc
- XOR properties and applications
- Prime numbers (Sieve of Eratosthenes)
- GCD/LCM, modular arithmetic
- Basic combinatorics

**Practice** (15-20 problems):

- All problems from your Bit Manipulation section
- All problems from your Maths section
- Single Number series, Power of Two
- **Master**: Bit masking and setting/clearing bits

**Resources**:

- Your Bit Manipulation & Maths patterns document
- CP-Algorithms (Number Theory)

---

## Phase 2: Core Data Structures (Weeks 7-12)

### Week 7-8: Trees (Part 1 - Basics & Traversals)

**Goal**: Master all tree recursion types and traversals

**Week 7 Topics**:

- Tree traversals (Inorder, Preorder, Postorder - recursive & iterative)
- Level order traversal (BFS)
- Bubble-up (bottom-up) recursion
- Carry-forward (top-down) recursion

**Week 7 Practice** (12-15 problems):

- Binary Tree Inorder/Preorder/Postorder Traversal
- Level Order Traversal, Zigzag Level Order
- Maximum Depth, Minimum Depth
- Path Sum I & II, Binary Tree Paths

**Week 8 Topics**:

- Divide and conquer on trees
- Backtracking in trees
- State aggregation patterns
- BST properties and operations

**Week 8 Practice** (12-15 problems):

- Invert Binary Tree, Merge Two Binary Trees
- Validate BST, Lowest Common Ancestor
- Diameter of Binary Tree, Balanced Binary Tree
- Serialize and Deserialize Binary Tree
- **Master**: All 10 recursion types from your document

**Resources**:

- Your Trees recursion types document
- Striver Tree series
- LeetCode Tree study plan

---

### Week 9-10: Advanced Trees & Tree DP

**Goal**: Master complex tree patterns and dynamic programming

**Week 9 Topics**:

- Binary lifting / LCA optimization
- Tree rerooting technique
- Distance between nodes
- Subtree queries

**Week 9 Practice** (10-12 problems):

- All CSES Tree problems from your document:
  - Distance Queries, Tree Diameter
  - Tree Distances I & II
  - Subordinates, Company Queries I & II

**Week 10 Topics**:

- Tree DP (matching, independent set)
- Path queries on trees
- Tree construction problems
- Morris traversal

**Week 10 Practice** (10-12 problems):

- House Robber III, Tree Matching (CSES)
- Path Sum III, Binary Tree Maximum Path Sum
- Construct Binary Tree from Preorder/Inorder
- **Focus**: CSES tree section completion

**Resources**:

- CSES Tree section
- Vivek Gupta Tree DP videos
- CP-Algorithms Trees

---

### Week 11: Heaps & Priority Queues

**Goal**: Master all 6 heap patterns

**Topics**:

- Min/Max heap operations
- Top K elements pattern
- Merge K sorted structures
- Two heaps for medians
- Greedy heap applications

**Practice** (15-20 problems):

- All problems from your Heaps section
- Kth Largest Element, Top K Frequent Elements
- Find Median from Data Stream
- Merge K Sorted Lists, Task Scheduler
- Meeting Rooms II, Course Schedule III
- **Pattern**: When to use heap vs sorting

**Resources**:

- Your Heaps patterns document
- LeetCode Heap/Priority Queue tag

---

### Week 12: Graphs (Part 1 - Traversals & Basic Algorithms)

**Goal**: Master graph fundamentals

**Topics**:

- Graph representations (adjacency list/matrix)
- DFS and BFS traversals
- Connected components
- Cycle detection (directed & undirected)
- Topological sort (Kahn's algorithm & DFS)

**Practice** (15-20 problems):

- Number of Islands, Clone Graph
- Course Schedule I & II
- Detect Cycle in Directed/Undirected Graph
- Pacific Atlantic Water Flow
- All Paths from Source to Target
- **Focus**: Problems from your Graphs Patterns 1-4

**Resources**:

- LeetCode Graph study plan
- CSES Graph section (start)
- Striver Graph series

---

## Phase 3: Advanced Algorithms (Weeks 13-18)

### Week 13-14: Graphs (Part 2 - Shortest Paths & Advanced)

**Goal**: Master shortest path algorithms and advanced patterns

**Week 13 Topics**:

- Dijkstra's algorithm
- Bellman-Ford algorithm
- Floyd-Warshall
- 0-1 BFS

**Week 13 Practice** (12-15 problems):

- Network Delay Time, Cheapest Flights Within K Stops
- Path with Maximum Probability
- All CSES shortest path problems from your doc
- Shortest Path in Binary Matrix

**Week 14 Topics**:

- Union-Find (DSU) with path compression
- Minimum Spanning Tree (Kruskal's, Prim's)
- Strongly Connected Components (Kosaraju's, Tarjan's)
- Eulerian & Hamiltonian paths

**Week 14 Practice** (12-15 problems):

- Number of Provinces, Redundant Connection
- Min Cost to Connect All Points
- Critical Connections in a Network
- Reconstruct Itinerary
- **Complete**: All 12 graph patterns from your document

**Resources**:

- CSES Graph section (complete)
- CP-Algorithms Graphs
- USACO Guide (Graphs)

---

### Week 15-16-17: Dynamic Programming (Core Patterns)

**Goal**: Master all 11 DP patterns

**Week 15 - Basic DP**:

**Topics**:

- Fibonacci/Simple recurrence
- 0/1 Knapsack
- Unbounded Knapsack

**Practice** (15-20 problems):

- Climbing Stairs, Min Cost Climbing Stairs
- Partition Equal Subset Sum, Target Sum
- Coin Change I & II
- Rod Cutting, Unbounded Knapsack
- All CSES DP problems: Dice Combinations, Minimizing Coins

**Week 16 - String & Sequence DP**:

**Topics**:

- LCS (Longest Common Subsequence)
- LIS (Longest Increasing Subsequence)
- Edit Distance
- Palindrome DP

**Practice** (15-20 problems):

- Longest Common Subsequence, Edit Distance
- Longest Increasing Subsequence (O(n log n) solution)
- Longest Palindromic Subsequence/Substring
- Palindrome Partitioning II
- Uncrossed Lines, Delete Operation for Two Strings

**Week 17 - Advanced DP**:

**Topics**:

- Grid DP
- Interval DP (MCM pattern)
- Bitmask DP
- Tree DP
- Digit DP

**Practice** (20-25 problems):

- Unique Paths I & II, Minimum Path Sum
- Burst Balloons, Minimum Cost to Merge Stones
- Traveling Salesman, Elevator Rides (CSES)
- House Robber III, Tree Matching (CSES)
- Count Numbers with Unique Digits
- **Complete**: AtCoder Educational DP Contest (all 26 problems)

**Resources**:

- Your DP patterns document (all 11 patterns)
- Aditya Verma DP playlist
- Vivek Gupta DP workshop
- AtCoder DP contest
- LeetCode DP study plans (both)

---

### Week 18: Advanced String Algorithms

**Goal**: Master pattern matching and string DP

**Topics**:

- KMP algorithm
- Rabin-Karp
- Z-algorithm
- Trie (Prefix Tree)
- String hashing

**Practice** (12-15 problems):

- All problems from your Strings section
- Implement strStr(), Shortest Palindrome
- Implement Trie, Word Search II
- Longest Happy Prefix
- String Matching (CSES)
- **Master**: Building and using Tries

**Resources**:

- Your Strings patterns document
- CP-Algorithms String section
- CSES String algorithms

---

## Phase 4: Problem Solving & System Design (Weeks 19-22)

### Week 19: Mixed Problem Solving (Medium-Hard)

**Goal**: Build speed and pattern recognition

**Strategy**:

- Solve 4-5 problems daily from mixed topics
- Focus on LeetCode Medium-Hard
- Time yourself (45 min per problem max)

**Practice** (25-30 problems):

- LeetCode Premium Google Tagged (30 days list)
- LeetCode Top 100 Liked (any unsolved)
- Random medium problems from weak areas
- **Goal**: Recognize pattern within 5 minutes

**Resources**:

- LeetCode Google tagged problems
- Your Google company problems link

---

### Week 20: Contest & Competitive Programming

**Goal**: Build speed under pressure

**Strategy**:

- Participate in 2 LeetCode Weekly Contests
- 2 Codeforces Div 2/3 contests
- 1 AtCoder Beginner Contest
- Upsolve all problems you couldn't solve

**Practice**:

- Virtual contests on past LeetCode weeklies
- Codeforces problemset (rating 1400-1800)
- **Focus**: Time management and avoiding silly mistakes

**Resources**:

- LeetCode Weekly Contest
- Codeforces contest archive
- AtCoder Past Contests

---

### Week 21: System Design & OOD Basics

**Goal**: Prepare for design rounds (L4/L5)

**Topics**:

- Design principles (SOLID)
- Common design patterns
- Scalability concepts
- Database fundamentals
- Caching strategies
- Load balancing

**Practice**:

- Design LRU Cache (implement from scratch)
- Design HashSet/HashMap
- Design Twitter, TinyURL, Rate Limiter
- Read 5-10 system design interview questions

**Resources**:

- "Designing Data-Intensive Applications" (key chapters)
- System Design Primer (GitHub)
- Educative System Design course

---

### Week 22: Hard Problems & Weak Area Focus

**Goal**: Build confidence with hard problems

**Strategy**:

- Solve 15-20 LeetCode Hard problems
- Revisit your weakest topic and solve 10 more problems
- Focus on problems you struggled with earlier

**Practice**:

- Median of Two Sorted Arrays
- Trapping Rain Water II
- Word Ladder II, Alien Dictionary
- Sliding Window Maximum
- Serialize Binary Tree
- **Track**: Problems that took > 45 min

---

## Phase 5: Interview Prep & Mock Interviews (Weeks 23-24)

### Week 23: Mock Interviews & Problem Review

**Goal**: Simulate real interview conditions

**Strategy**:

- 4-6 mock interviews with peers or Pramp/Interviewing.io
- Practice explaining solutions out loud
- Review all bookmarked/flagged problems
- Solve Blind 75 problems you haven't done

**Focus**:

- Communication skills
- Asking clarifying questions
- Thinking out loud
- Handling hints from interviewer

**Practice** (20 problems):

- Any unsolved from Blind 75
- Any unsolved from LeetCode Top 100
- Redo hard problems from earlier weeks
- **Time limit**: 45 min including explanation

---

### Week 24: Final Review & Googleyness Prep

**Goal**: Polish everything and prep for behavioral

**Technical Review**:

- Review all patterns and templates
- Practice writing code on whiteboard/paper
- Quick revision of all data structure implementations
- Review time/space complexities

**Behavioral Prep**:

- Prepare STAR stories for:
  - Leadership
  - Teamwork/Collaboration
  - Handling ambiguity
  - Innovation/Problem-solving
  - Failure/Learning experiences
- Review your Googleyness FAQ link
- Practice Googleyness questions

**Googleyness Topics**:

- Team collaboration examples
- Handling disagreements
- Taking initiative
- Learning from failures
- Comfort with ambiguity

**Final Days**:

- Light practice (2-3 easy/medium per day)
- Get good sleep
- Stay confident

**Resources**:

- Your Googleyness FAQ link
- "Cracking the Coding Interview" behavioral section

---

## 📊 Weekly Tracking Template

```
Week #: [Topic]
Problems Solved: [ ] / Target
Concepts Mastered: 
- [ ] Concept 1
- [ ] Concept 2
- [ ] Concept 3

Struggled With:
- Problem X: [reason]
- Pattern Y: [need more practice]

Next Week Focus:
- [specific goal]
```

---

## 🎯 Daily Routine

**Morning (1-1.5 hours)**:

- 1 medium problem from current week's topic
- Review previous day's problems

**Evening (1.5-2 hours)**:

- 1-2 problems from current topic
- Watch 1 video tutorial if stuck
- Document learnings and patterns

**Weekend (3-4 hours/day)**:

- Catch up on incomplete problems
- Contest participation
- Review and consolidate week's learnings

---

## 📈 Success Metrics

### After 12 weeks:

- [ ]  Solved 200+ problems
- [ ]  Can recognize patterns in < 5 minutes
- [ ]  70%+ accuracy on medium problems
- [ ]  Completed CSES problem set core sections

### After 18 weeks:

- [ ]  Solved 350+ problems
- [ ]  50%+ accuracy on hard problems
- [ ]  Can solve mediums in < 30 minutes
- [ ]  Completed AtCoder DP contest

### After 24 weeks:

- [ ]  Solved 500+ problems
- [ ]  Ready for Google interviews
- [ ]  Strong system design fundamentals
- [ ]  Confident in all core topics

---

## ⚠️ Important Notes

1. **Quality > Quantity**: Understand WHY a solution works
2. **Pattern Recognition**: After solving, identify the pattern
3. **Code Templates**: Maintain a template document for common patterns
4. **Consistency**: Daily practice is better than weekend marathons
5. **Rest**: Take one day off per week to avoid burnout
6. **Weak Areas**: Spend extra time on topics you find difficult
7. **Real Interviews**: Start applying after Week 20-22

---

## 🔗 Quick Reference Links

**Must Complete**:

- [ ]  LeetCode Top 100 Liked
- [ ]  LeetCode Top Interview 150
- [ ]  Blind 75
- [ ]  CSES Problem Set (core problems)
- [ ]  AtCoder DP Contest
- [ ]  Google 30-day tagged problems

**Study Plans**:

- LeetCode Dynamic Programming (both)
- LeetCode Graph Theory
- LeetCode Binary Search

---

## 💪 Motivation Reminders

- Google interviews are pattern-based - master the patterns
- Every hard problem becomes easy after solving similar ones
- Consistency beats intensity
- You're preparing for one of the best companies - it's worth it!
- "Success is the sum of small efforts repeated day in and day out"

**Let's crack Google 2026! 🚀**
