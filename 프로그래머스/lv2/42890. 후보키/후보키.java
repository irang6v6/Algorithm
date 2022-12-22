import java.io.IOException;
import java.util.*;

public class Solution {
    static int C, R;
    static int[] columns;
    static String[][] relations;
    static List<Set<Integer>> candidateKeys = new ArrayList<>();

    public static int solution(String[][] relation) {
        C = relation[0].length;
        R = relation.length;
        relations = relation;

        for (int i = 1; i <= C; i++) {
            columns = new int[i];
            comb(0, 0, i);
        }

        return candidateKeys.size();
    }

    private static void comb(int start, int count, int total) { //총 몇 개 뽑을건지
        if (count == total) {
            if (checkUniqueness(columns)) {
                checkMinimality(columns);
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
            String data = "";
            for (int c : columns) {
                data += relations[i][c];
            }
            if(!set.add(data)) {
                return false;
            }
        }
        return true;
    }
}
