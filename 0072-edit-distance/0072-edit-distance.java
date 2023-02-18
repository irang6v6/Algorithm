import java.util.Arrays;

class Solution {
    public static int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 1; i <= word1Length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2Length; i++) {
            dp[0][i] = i;
        }
        for (int word1Index = 1; word1Index <= word1Length; word1Index++) {
            for (int word2Index = 1; word2Index <= word2Length; word2Index++) {
                if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
                    dp[word1Index][word2Index] = dp[word1Index - 1][word2Index - 1];
                } else {
                    dp[word1Index][word2Index] = Math.min(dp[word1Index - 1][word2Index], Math.min(dp[word1Index][word2Index - 1], dp[word1Index - 1][word2Index - 1])) + 1;
                }
            }
        }
        return dp[word1Length][word2Length];
    }

}
