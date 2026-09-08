/**
 * str --> M
 * pat --> N
 *
 * for(i : 0 to M-N){
 *    int j;
 *
 *    for(j : 0 to N-1){
 *        if(str[i+j] != pat[j])
 *            break;
 *    }
 *
 *    if(j == N)
 *        return i;    // Pattern found at i
 * }
 */

class Knuth_Morris_Pratt_Algo_PatternMatching {

    public static void Patternsearch(String str, String pat) {

        int M = str.length();
        int N = pat.length();

        for (int i = 0; i <= M - N; i++) {

            int j;

            for (j = 0; j < N; j++) {

                if (str.charAt(i + j) != pat.charAt(j))
                    break;
            }

            if (j == N)
                System.out.println("Pattern found at index " + i);
        }
    }

    public static void main(String[] args) {

        Patternsearch("abcabcabc", "abc");
    }
}

