package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B24060 {
	static int count, K, A[], tmp[];

	public static void merge(int p, int q, int r) {
		if (count > K) {
			return;
		}

		int i = p;
		int j = q + 1;
		int t = 0;

		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				tmp[t++] = A[i++];
			} else {
				tmp[t++] = A[j++];
			}
		}
		while (i <= q) {
			tmp[t++] = A[i++];
		}
		while (j <= r) {
			tmp[t++] = A[j++];
		}

		i = p;
		t = 0;
		while (i <= r) {
			count++;
			if (count == K) {
				System.out.println(tmp[t]);
				break;
			} else
				A[i++] = tmp[t++];
		}
	}

	public static void merge_sort(int p, int r) {
		if (count > K)
			return;
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(p, q);
			merge_sort(q + 1, r);
			merge(p, q, r);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int size = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		A = new int[size];
		tmp = new int[size];

		input = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			A[i] = Integer.parseInt(input[i]);
		}

		count = 0;
		merge_sort(0, A.length - 1);
		if (count < K)
			System.out.println(-1);
	}

}
