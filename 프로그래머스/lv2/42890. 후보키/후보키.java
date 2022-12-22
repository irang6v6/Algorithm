import java.io.IOException;
import java.util.*;

public class Solution {
    static boolean[] checkValid;
    static int C, R;
    static int[] columns;
    static String[][] relations;
    static int answer = 0;
    static List<Set<Integer>> candidateKeys = new ArrayList<>();

    public static int solution(String[][] relation) {
        C = relation[0].length;
        R = relation.length;
        checkValid = new boolean[C];
        relations = relation;

        for (int i = 1; i <= C; i++) {
//            System.out.println("-----" + i + "개 뽑는 조합-----");
            columns = new int[i];
            comb(0, 0, i);
        }

        return candidateKeys.size();
    }

    private static void comb(int start, int count, int total) { //총 몇 개 뽑을건지
        if (count == total) {
            if (checkUniqueness(columns)) {
//                System.out.println("후보값 발견!!" + Arrays.toString(columns));
                checkMinimality(columns);
                for (int c : columns) {
                    checkValid[c] = true;
                }
            }
            return;
        }
        for (int i = start; i < C; i++) {

            columns[count] = i;
            comb(i + 1, count + 1, total);
        }
    }

    private static void checkMinimality(int[] columns) {
        Set<Integer> list = new HashSet<>();
        for (int i : columns) {
            list.add(i);
        }
        for (Set<Integer> candidate : candidateKeys) {
            if (list.containsAll(candidate)) {
                return;
            }
        }
        candidateKeys.add(list);
    }

    private static boolean checkUniqueness(int[] columns) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            String s = "";
            for (int c : columns) {
                s += relations[i][c];
            }
//            System.out.println("s: " + s);
            if (set.add(s)) {
                if (i == R - 1) {
                    return true;
                }
                continue;
            } else {
                return false;
            }
        }
        return false;
    }

}
