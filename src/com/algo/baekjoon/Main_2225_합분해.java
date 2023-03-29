package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2225_합분해 {

	static int N,K;
	static int MOD=1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[N+1][K+1];
		
		//0개로 만들 수 있는 갯수는 0, 1개로 만들 수 있는 개수는 1(N 본인)
		for (int i = 0; i <= N; i++) {
			dp[i][0]=0;
			dp[i][1]=1;
		}
		
		//N이 1인 경우 만들 수 있는 갯수 K
		for (int i = 0; i <= K; i++) {
			dp[1][i]=i;
		}
		
		//점화식 dp[N][K] = dp[N-1][K] + dp[N][K-1]
		for (int n = 2; n <= N; n++) {
			for (int k = 2; k <= K; k++) {
				dp[n][k] = (dp[n-1][k] + dp[n][k-1])%MOD;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
