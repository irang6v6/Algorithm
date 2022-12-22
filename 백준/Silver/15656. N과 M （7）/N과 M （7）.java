import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] numbers, list;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s2 = s.split(" ");
        N = Integer.parseInt(s2[0]);
        M = Integer.parseInt(s2[1]);
        numbers = new int[M]; //고른 숫자
        isSelected = new boolean[N + 1];
        list = new int[N];
        s = br.readLine();
        s2 = s.split(" ");

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(list);

        sb = new StringBuilder();
//        perm(0);
        comb(0,0);
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
        for (int i = 0; i < N; i++) {
            numbers[cnt] = list[i];
            comb(cnt + 1, i);
        }
    }
}
