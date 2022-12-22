import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, M;
    static int[] numbers, list;
    static boolean[] isSelected;
    static StringBuilder sb;

    static Set<String> set=new HashSet<>();

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
        perm(0);
//        comb(0,0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            StringBuilder sb2=new StringBuilder();
            for (int i : numbers) {
                sb2.append(i).append(" ");
            }
            String checkDuplicate=sb2.toString();
            if(!set.contains(checkDuplicate)){
                sb.append(checkDuplicate).append("\n");
                set.add(checkDuplicate);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSelected[i]) {
                continue;
            }
            numbers[cnt] = list[i];
            perm(cnt + 1);
        }
    }
}
