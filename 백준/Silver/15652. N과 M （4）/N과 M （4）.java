import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s2 = s.split(" ");
        N = Integer.parseInt(s2[0]);
        M = Integer.parseInt(s2[1]);
        numbers = new int[M];
        isSelected = new boolean[N + 1];

        sb = new StringBuilder();
        //perm(0);
        comb(0,1);
        System.out.println(sb);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            for (int i : numbers) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i);
        }
    }
}
