package LeetCode;

public class LC1094 {
	//Car Pooling - 버스에 최대 승객수를 넘었는지 안넘었는지 구하기 
	//시작복잡도는 ... ㅎ 

	public static boolean LC1094(int[][] trips,int capacity) {
		int[] status=new int[1000];

		for(int i=0;i<trips.length;i++) {
			int from=trips[i][1];
			int to=trips[i][2];
			int passengers=trips[i][0];
			for(int j=from;j<to;j++) {
				status[j]+=passengers;
				if(status[j]>capacity) return false;
			}
		}return true;
	}

//	public static void main(String[] args) {
//		int[][] trips= {{3,3,7},{4,7,9},{8,3,9}};
//		System.out.println(LC1094(trips,11));
//	}

}
