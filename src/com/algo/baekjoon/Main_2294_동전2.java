package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2 {

	static int N, K;
	static int[] coin;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		Arrays.fill(dp, Integer.MAX_VALUE-1);//오버플로어가 발생할 가능성이 있기 때문에 -1
		dp[0]=0;
		
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				//최소갯수 = 기존 최소 갯수와 기존 최소 갯수에 추가된 coin의 최소갯수를 뺀 것 +1 중 더 작은 것이 최소
				//+1은 coin 하나로 대체할 수 있는 갯수를 빼서 플러스 해줌
				dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
			}
		}
		System.out.println(dp[K] == Integer.MAX_VALUE-1 ? -1 : dp[K]);
		
		
	}

}
