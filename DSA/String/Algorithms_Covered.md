# String Algorithms Covered

This checklist is based on the Java solutions currently in this folder. It records the technique that is implemented, rather than relying only on a file name.

## String processing fundamentals

- [x] Character-frequency arrays / counting - [Rearrange Characters to Make Target String](Intuition/RearrangeCharactersToMakeTargetString.java), [Minimum Length After Deletions](MinLengthOfStringAfterDeletingFrontBack.java)
- [x] HashSet and HashMap lookups for dictionary and substring checks - [Replace Sentence With Root](ReplaceSentenceWithRoot.java), [String Matching](hasSubString.java)
- [x] Prefix scanning and prefix replacement - [Replace Sentence With Root](ReplaceSentenceWithRoot.java)
- [x] Sorting strings and comparing the first and last strings - [Longest Common Prefix](LongestCommonPrefix.java)
- [x] Run-length encoding / in-place string compression - [String Compression](StringCompression.java)
- [x] Manual parsing of a formatted string - [Fraction Addition and Subtraction](fraction-addition-and-subtraction.java)
- [x] GCD reduction using Euclid's algorithm - [Fraction Addition and Subtraction](fraction-addition-and-subtraction.java)
- [x] Subsequence and substring checking - [Is Subsequence](isSubsequence.java), [String Matching](hasSubString.java)

## Two pointers, windows, and prefix/suffix counting

- [x] Fixed-size, word-aligned sliding window with a frequency map - [Substring with Concatenation of All Words](SubStringWithConcatenationOfAllWords.java)
- [x] Two-pointer reversal - [Reverse String in Parentheses](ReverseStringInParenthesis.java)
- [x] Prefix/suffix frequency counting with a partition scan - [Minimum Deletions to Make String Balanced](MinDeletionToMakeStringBalanced.java)

## Stack-based and greedy algorithms

- [x] Monotonic stack with remaining-frequency tracking - [Smallest Lexicographic String](smallestLexicographicString.java)
- [x] Stack matching for nested parentheses - [Reverse String in Parentheses](ReverseStringInParenthesis.java)
- [x] Greedy ordering of removals, using a stack-like `StringBuilder` - [Maximum Points on Removing Substrings](MaxPointOnRemovalSubString.java)

## Pattern matching and hashing

- [x] Naive pattern matching - [Pattern Matching](Knuth_Morris_Pratt_Algo_PatternMatching.java)
- [x] Rabin-Karp rolling hash - [RKA](Rabin%20Karp%20Algorithm/RKA.java)
- [x] Binary search on answer length + duplicate-substring detection with a set - [Longest Duplicate Substring](KMP/LongestDuplicateSubstring.java)
- [x] Binary search on answer length + polynomial rolling hash - [Longest Duplicate Substring](Rabin%20Karp%20Algorithm/LongestDuplicateSubstring.java)

> Note: the files named `Knuth_Morris_Pratt_Algo_PatternMatching.java` use the naive `O(nm)` matching approach at present. A full KMP implementation would additionally build and use an LPS/prefix table.

## Recursion, backtracking, and dynamic programming

- [x] Backtracking with valid-state pruning - [Generate Parentheses](GenerateParenthesis.java)
- [x] DFS backtracking with a visited-state set - [de Bruijn Sequence](deBruijnSequence.java)
- [x] Memoized recursion / word-break-style dynamic programming - [Concatenated Words](Array%20based%20pattern%20checking/Concatenated%20Words%20DP.java)

## Other techniques practised

- [x] Caesar, Vigenere, and Vernam cipher transformations - [Encryption](Encryption.java)
- [x] Efficient mutable string operations with `StringBuilder` - [StringBuilder notes](docs/StringBuilder.md)
