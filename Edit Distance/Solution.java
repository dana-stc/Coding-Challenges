public class Solution {
    public static int minDistance(String w1, String w2) {
        int m = w1.length(), n = w2.length();
        int[] prev = new int[n + 1];
        for (int j = 0; j <= n; j++) prev[j] = j;
        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            prev = cur;
        }
        return prev[n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));          // 3
        System.out.println(minDistance("intention", "execution")); // 5
    }
}
