import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static int solution(int[] topping) {
        int answer = 0;
        //토핑의 종류와 개수 구하기
        Set<Integer> member1 = new HashSet<>(); //모든 토핑을 한 사람에게 몰아줌
        Map<Integer, Integer> count = new HashMap<>();//토핑의 개수 저장
        for (int i = 0; i < topping.length; i++) {
            member1.add(topping[i]);
            count.put(topping[i], count.getOrDefault(topping[i], 0) + 1);
        }
        //앞에서부터 동생이 토핑 하나씩 가져감
        Set<Integer> member2 = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            count.put(topping[i], count.get(topping[i]) - 1);//토핑 count--;
            member2.add(topping[i]); //동생 토핑 종류++;
            if (count.get(topping[i]) == 0) {
                member1.remove(topping[i]); //토핑 count == 0이 됐을 경우 형 토핑 종류--;
            }
            if (member1.size() == member2.size()) { //형의 토핑 종류와 동생의 토핑 종류 비교해서 같으면 answer++;
                answer++;
            }
        }
        return answer;
    }
}
