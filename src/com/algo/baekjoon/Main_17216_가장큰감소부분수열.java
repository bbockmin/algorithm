package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17216_가장큰감소부분수열 {

	static int N;
	static int[] arr;
	static int[] dp;
	static int max=0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		
		for (int n = 0; n < N; n++) {
			arr[n]=Integer.parseInt(st.nextToken());
			dp[n]=arr[n];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j]>arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
