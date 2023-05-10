package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2410_2의멱수의합 {

	static int N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//N이 홀수일 경우, N-1의 가능 조합 끝에 1씩 더해주면 됨
		//N이 짝수일 경우, N-1의 가능 조합에 1 더해준 것과 N/2의 가능 조합에 2를 곱해준 값을 합치면 됨
		
		long[] dp = new long[1000001];
		dp[1]=1;
		dp[2]=2;
		for (int i = 3; i < 1000001; i++) {
			if(i%2 != 0) {
				dp[i] = dp[i-1];
			} else {
				dp[i] = (dp[i-1] + dp[i/2]) % 1000000000;
			}
		}
		
		System.out.println(dp[N]);
	}
}
