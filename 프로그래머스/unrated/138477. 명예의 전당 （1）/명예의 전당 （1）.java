import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length]; //명예의 전당이 총 몇일 진행되는지
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(); //우선순위 큐 - 점수 오름차순
        int n = 0; //answer의 idx
        for (int i : score) { //출연 가수의 점수
            que.add(i);
            if (que.size() > k) { //큐의 길이가 k에서 벗어나는 제일 낮은 점수 poll
                que.poll();
            }
            answer[n++] = que.peek();//k에 속하는 최하위 점수를 저장
        }
        return answer;
    }
}
