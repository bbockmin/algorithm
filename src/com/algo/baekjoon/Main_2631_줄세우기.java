package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;

public class Main_2631_줄세우기 {

	static int N;
	static int[] arr;
	static int[] dp;
	static int max = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, 1); //각 오름차순 길이에 본인도 포함해서 1로 세팅
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && dp[j]+1>dp[i]) {
					//0~j까지 중에서 i가 더 큰수를 찾고, 그 인덱스의 dp도 +1했을떄 i보다 커야 dp[i]에 넣는 조건으로 충족
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(dp[i], max);//최장 증가 수열의 길이
		}
		
		System.out.println(N-max);
	}
}
