package LeetCode;

import java.util.Arrays;

//274.H-Index -배열
/*H-Index란 연구자의 평가를 값으로 구한 것이다. 
 * 연구자가 총 n개의 논문을 냈을때, 각 논문이 인용(citations)된 횟수가 최소 h번인 논문 h개 index값을 추출한다. 
 */
public class LC274 {
	public int hIndex(int[] citations) {
		// 오름차순 정렬
		sort(citations);

		//인덱스는 0부터, 값은 끝부터 교차로 비교해서 대소가 바뀔때 
		 for (int i = citations.length; i > 0; i --) {
            if (citations[citations.length - i] >= i) {
                return i;
            }}
		return 0;
	}

	//퀵정렬
	public static void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) {
		int value = a[end];
		int i = start - 1;
		for (int j = start; j <= end - 1; ++j)
			if (a[j] < value)
				swap(a, ++i, j);
		swap(a, i + 1, end);
		return i + 1;
	}

	static void quickSort(int[] a, int start, int end) {
		if (start >= end)
			return;
		int middle = partition(a, start, end);
		quickSort(a, start, middle - 1);
		quickSort(a, middle + 1, end);
	}
}
