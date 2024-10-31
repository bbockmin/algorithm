package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {

	static int N, K;//물품의 수, 버릴 수 있는 무게
	static int[][] dp;//i물품, j무게
	static int[] W;//무게
	static int[] V;//가치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		W = new int[N+1];
		V = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];//이전 행 복사
				if(j-W[i]>=0) {//버틸 수 있는 무게에서 현재 물품의 무게를 뺏을때 무게가 남았으면
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]]+V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
