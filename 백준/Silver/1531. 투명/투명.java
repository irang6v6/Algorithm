import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        int[][] arr = new int[101][101];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            inputArr = input.split(" ");
            int leftX = Integer.parseInt(inputArr[0]);
            int leftY = Integer.parseInt(inputArr[1]);
            int rightX = Integer.parseInt(inputArr[2]);
            int rightY = Integer.parseInt(inputArr[3]);

            for (int j = leftX; j <= rightX; j++) {
                for (int k = leftY; k <= rightY; k++) {
                    arr[j][k]++;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] > M) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}