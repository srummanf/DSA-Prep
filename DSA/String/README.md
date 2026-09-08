
# String Algorithms & Patterns — FAANG Interview Roadmap

A structured **GeeksforGeeks-style roadmap** for mastering String DSA, with representative LeetCode problems for each pattern.


| Priority | Algorithm / Pattern            | What to Learn                                             | Representative LeetCode Problems                                                                                                                                                                                                                                                                                 |
| ---------- | -------------------------------- | ----------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 🔴**P0** | **String Fundamentals**        | Character manipulation, frequency, substring, subsequence | [Valid Anagram](https://leetcode.com/problems/valid-anagram/), [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/), [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)                                                                                                |
| 🔴**P0** | **Two Pointers**               | Process strings from both ends or maintain two indices    | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/), [Reverse String](https://leetcode.com/problems/reverse-string/), [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)                                                                                    |
| 🔴**P0** | **Hashing + Strings**          | Frequency maps, sets, anagrams, duplicate detection       | [Group Anagrams](https://leetcode.com/problems/group-anagrams/), [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/), [Word Pattern](https://leetcode.com/problems/word-pattern/)                                                                                                            |
| 🔴**P0** | **Sliding Window**             | Fixed and variable-size windows                           | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/), [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/), [Permutation in String](https://leetcode.com/problems/permutation-in-string/)              |
| 🔴**P0** | **Prefix / Suffix**            | Prefix matching, prefix/suffix properties                 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/), [Find the Index of the First Occurrence](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/), [Prefix and Suffix Search](https://leetcode.com/problems/prefix-and-suffix-search/)                  |
| 🔴**P0** | **Palindrome**                 | Two pointers, expand-around-center, palindrome DP         | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/), [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/), [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)                                                |
| 🔴**P0** | **String DP**                  | DP across one or two strings                              | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/), [Edit Distance](https://leetcode.com/problems/edit-distance/), [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/), [Interleaving String](https://leetcode.com/problems/interleaving-string/) |
| 🔴**P0** | **Trie**                       | Prefix tree, insert/search/prefix operations              | [Implement Trie](https://leetcode.com/problems/implement-trie-prefix-tree/), [Design Add and Search Words](https://leetcode.com/problems/design-add-and-search-words-data-structure/), [Word Search II](https://leetcode.com/problems/word-search-ii/)                                                           |
| 🟠**P1** | **Stack + Strings**            | Stack-based parsing and string construction               | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/), [Decode String](https://leetcode.com/problems/decode-string/), [Remove All Adjacent Duplicates](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)                                                                  |
| 🟠**P1** | **Greedy + Strings**           | Frequency-based and lexicographical optimization          | [Reorganize String](https://leetcode.com/problems/reorganize-string/), [Remove K Digits](https://leetcode.com/problems/remove-k-digits/), [Partition Labels](https://leetcode.com/problems/partition-labels/)                                                                                                    |
| 🟠**P1** | **Backtracking + Strings**     | Generate and explore possible strings                     | [Letter Combinations](https://leetcode.com/problems/letter-combinations-of-a-phone-number/), [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/), [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)                                                      |
| 🟠**P1** | **KMP**                        | LPS array and linear-time pattern matching                | [Find First Occurrence](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/), [Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/)                                                                                                              |
| 🟠**P1** | **Rabin-Karp / Rolling Hash**  | Hash-based substring and pattern matching                 | [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/), [Longest Duplicate Substring](https://leetcode.com/problems/longest-duplicate-substring/)                                                                                                                                       |
| 🟠**P1** | **Z Algorithm**                | Z-array and prefix-based pattern matching                 | [Find First Occurrence](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/), [Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/)                                                                                                              |
| 🟡**P2** | **Lexicographical Techniques** | Ordering, smallest/largest strings and subsequences       | [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/), [Smallest Subsequence](https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/), [Next Permutation](https://leetcode.com/problems/next-permutation/)                                                     |
| 🟡**P2** | **String Rotation**            | Rotation and cyclic string properties                     | [Rotate String](https://leetcode.com/problems/rotate-string/), [Repeated Substring Pattern](https://leetcode.com/problems/repeated-substring-pattern/)                                                                                                                                                           |
| 🟡**P2** | **Manacher's Algorithm**       | Linear-time longest palindrome                            | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/), [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)                                                                                                                                   |
| 🟢**P3** | **Suffix Array**               | Sorted suffixes and advanced substring queries            | [Longest Duplicate Substring](https://leetcode.com/problems/longest-duplicate-substring/), [Last Substring in Lexicographical Order](https://leetcode.com/problems/last-substring-in-lexicographical-order/)                                                                                                     |
| 🟢**P3** | **Aho-Corasick**               | Multiple-pattern matching using Trie + failure links      | [Multi Search](https://leetcode.com/problems/multi-search/), [Stream of Characters](https://leetcode.com/problems/stream-of-characters/)                                                                                                                                                                         |

---

# Recommended Study Order

### Phase 1 — Core String Patterns

**String Basics → Two Pointers → Hashing → Sliding Window**

Focus on becoming fast at recognizing these patterns.

### Phase 2 — Intermediate

**Prefix/Suffix → Palindromes → Stack → Greedy → Backtracking**

These cover a large portion of practical string interview questions.

### Phase 3 — Advanced Foundations

**Trie → String DP**

These deserve dedicated practice because they introduce substantially different problem-solving techniques.

### Phase 4 — Dedicated String Algorithms

**KMP → Rabin-Karp/Rolling Hash → Z Algorithm**

Learn the underlying mechanics, not just the implementation.

### Phase 5 — Advanced / Optional

**Manacher → Suffix Array → Aho-Corasick**

Study these after the core roadmap is solid.

---

## Priority Guide


| Level                | Focus                                                                      | Target                       |
| ---------------------- | ---------------------------------------------------------------------------- | ------------------------------ |
| 🔴**P0 — Master**   | Basics, Two Pointers, Hashing, Sliding Window, Palindrome, String DP, Trie | **Must know for FAANG**      |
| 🟠**P1 — Strong**   | Stack, Greedy, Backtracking, KMP, Rabin-Karp, Z Algorithm                  | **Strongly recommended**     |
| 🟡**P2 — Learn**    | Rolling Hash concepts, Lexicographical, Rotation, Manacher                 | **Good for harder problems** |
| 🟢**P3 — Advanced** | Suffix Array, Suffix Tree, Aho-Corasick                                    | **Optional / specialized**   |

### Suggested Practice Strategy

For each **P0/P1 topic**, solve approximately:

**2 Easy → 4 Medium → 1–2 Hard**

Do not move on simply because you can implement the algorithm. Move on when you can **identify the pattern from the problem statement without being told which algorithm to use**.
