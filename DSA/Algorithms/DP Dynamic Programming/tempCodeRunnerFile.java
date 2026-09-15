
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