// DP: Longest Common Substring
//
// If characters match:
//     return 1 + f(i1-1, i2-1)
//
// If characters don't match:
//     return 0
//
// IMPORTANT:
// We need to keep track of the maximum length found,
// because the answer may occur anywhere in the strings.

import java.util.Arrays;

public class dp_27_Longest_Common_Substring {

    // ---------------------------------------------------
    // Recursive Solution
    // ---------------------------------------------------
    int LCSubstring_recursion(String s1, String s2, int i1, int i2) {

        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + LCSubstring_recursion(
                    s1,
                    s2,
                    i1 - 1,
                    i2 - 1
            );
        }

        // Substring must be continuous.
        // So mismatch breaks the substring.
        return 0;
    }

    // ---------------------------------------------------
    // Memoization Solution
    // ---------------------------------------------------
    int LCSubstring_memoization(
            String s1,
            String s2,
            int i1,
            int i2,
            int[][] dp
    ) {

        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        if (s1.charAt(i1) == s2.charAt(i2)) {

            return dp[i1][i2] = 1 + LCSubstring_memoization(
                    s1,
                    s2,
                    i1 - 1,
                    i2 - 1,
                    dp
            );
        }

        // Mismatch → continuous substring breaks
        return dp[i1][i2] = 0;
    }

    // ---------------------------------------------------
    // Tabulation Solution
    // ---------------------------------------------------
    int LCSubstring_tabulation(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        int maxLength = 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    maxLength = Math.max(maxLength, dp[i][j]);

                } else {

                    // Substring must be continuous
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    // ---------------------------------------------------
    // Main
    // ---------------------------------------------------
    public static void main(String[] args) {

        dp_27_Longest_Common_Substring ob
                = new dp_27_Longest_Common_Substring();

        String s1 = "abcdxyz";
        String s2 = "xyzabcd";

        // Recursion
        System.out.println(
                ob.LCSubstring_recursion(
                        s1,
                        s2,
                        s1.length() - 1,
                        s2.length() - 1
                )
        );

        // Memoization
        int m = s1.length();
        int n = s2.length();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        System.out.println(
                ob.LCSubstring_memoization(
                        s1,
                        s2,
                        s1.length() - 1,
                        s2.length() - 1,
                        matrix
                )
        );

        // Tabulation
        System.out.println(
                ob.LCSubstring_tabulation(s1, s2)
        );
    }

}
