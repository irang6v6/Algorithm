package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int gcdVal = arr[1] - arr[0];

		for (int m = 2; m < n; m++) {
			gcdVal = gcd(gcdVal, arr[m] - arr[m - 1]);
		}
		
		for (int i = 2; i <= gcdVal/2; i++) {
			if(gcdVal % i==0) {
				sb.append(i +" ");
			}
		}
		
		sb.append(gcdVal);
		
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
