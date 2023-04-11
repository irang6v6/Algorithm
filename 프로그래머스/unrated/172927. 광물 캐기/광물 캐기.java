import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int n = minerals.length;
        
        //2차원 배열에 곡괭이/광물 피로도를 저장
        int[][] fatigues = {{1,1,1},{5,1,1},{25,5,1}};
        
        //fatigues에서 인덱스를 활용하기 위해 minerals_int에 int값으로 복사
        int[] minerals_int = new int[n];
        for(int i = 0;i < n; i++){
            if("diamond".equals(minerals[i])){
                minerals_int[i] = 0;
            }else if("iron".equals(minerals[i])){
                minerals_int[i] = 1;
            }else {
                minerals_int[i] = 2;
            }
        }
        
        //총 곡괭이의 수 구하기
        int num = 0;
        for(int i : picks){
            num += i;
        }
        
        //캘 수 있는 광물의 수 구하기
        int sum = minerals.length > (num * 5) ? (num * 5) : minerals.length;
        
        //다이아 개수 > 철 개수 > 돌 개수로 정렬하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int []>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1]){
                        return o2[2]-o1[2];
                    }else{
                        return o2[1]-o1[1];
                    }
                } else {
                    return o2[0]-o1[0];
                }
            }
        });
        
        //5씩 나눴을 때 {다이아 개수,철 개수,돌 개수}인 배열로 정리하고 우선순위 큐에 집어넣음
        for(int i = 0; i < sum; i += 5){
            int[] cnt = new int[3];
            for(int j = 0; j < 5; j++){
                if((i+j) < n){
                    cnt[minerals_int[i+j]]++;
                }
            }
            pq.add(cnt);
        }
        
        //피로도 계산
        int answer = 0;
        

        while(!pq.isEmpty()){
            int[] m = pq.poll();
            // System.out.println(Arrays.toString(m));
            int p = 0; //곡괭이 다이아-철-돌 순으로 선택
            if(num > 0){
                if(picks[0] > 0){
                    p = 0;
                    picks[0]--;
                    num--;
                }else if(picks[1] > 0){
                    p = 1;
                    picks[1]--;
                    num--;
                }else if(picks[2] > 0){
                    p = 2;
                    picks[2]--;
                    num--;
                }
                // System.out.println("곡괭이 : "+p);
                answer += m[0]*(fatigues[p][0]); //곡괭이-광물별 피로도 * 개수
                answer += m[1]*(fatigues[p][1]);
                answer += m[2]*(fatigues[p][2]);
            }else{
                break;
            }
            
        }
        return answer;
    }
}