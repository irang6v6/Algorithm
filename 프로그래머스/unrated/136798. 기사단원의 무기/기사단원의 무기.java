import java.io.IOException;

public class Solution {
    public static int solution(int number, int limit, int power) {
        int sumOfWeight = 0;
        for (int i = 1; i <= number; i++) {
            int count = countDivisor(i);
            count = (count <= limit) ? count : power;
            sumOfWeight += count;
        }
        return sumOfWeight;
    }

     private static int countDivisor(int numOfKnight) {
            int count = 0;
            for (int i = 1; i * i <= numOfKnight; i++) {
                if (i * i == numOfKnight) count++;
                else if (numOfKnight % i == 0) count += 2;
            }
            return count;
        }
}
