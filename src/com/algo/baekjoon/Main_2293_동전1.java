package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {

	static int N, K;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		dp = new int[K+1];
		dp[0]=1;
		
		for (int i = 0; i < N; i++) {//동전만큼
			int coin = Integer.parseInt(br.readLine());
			//dp[i] : i를 만들 수 있는 경우의 수 dp[i]
			//dp[i] = dp[i] + dp[i-coin]
			//i를 만들 수 있는 경우의 수 = 기존 i를 만들 수 있는 경우의 수 + i에서 이번에 들어갈 동전을 뺀 값이 경우의 수
			//2동전으로 7을 만들려면 7-2인 5를 만들었던 경우의 수로 기존값에서 더하기만 하면 됨
			for (int j = coin; j < K+1; j++) {
				dp[j] += dp[j-coin];
			}
		}
		System.out.println(dp[K]);
	}
}
