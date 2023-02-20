package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467_용액 {

	static int N;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static int one, two;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		while(left < right) {
			int sum = arr[left]+arr[right];
			int abs = Math.abs(sum);
			if(min > abs) {
				min = abs;
				one = left;
				two = right;
			}
			
			if(sum >= 0) {//0에 가까워지려면 양수가 줄어들어야 함
				right--;
			} else {//sum < 0 : 0에 가까워지려면 음수가 줄어들어야 함
				left++;
			}
		}
		System.out.println(arr[one]+" "+arr[two]);
	}
}
