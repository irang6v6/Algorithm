import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] numbers;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s2 = s.split(" ");
        N = Integer.parseInt(s2[0]);
        M = Integer.parseInt(s2[1]);
        numbers = new int[M];

        sb = new StringBuilder();
        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i : numbers) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            numbers[cnt] = i;
            perm(cnt + 1);
        }
    }
}
