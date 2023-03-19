package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {

	static int N;
	static int[][] wire;
	static int[] dp;
	static int max = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wire = new int[N][2];
		dp = new int[N];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wire[n][0] = Integer.parseInt(st.nextToken());
			wire[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// A기준으로 배열 정렬
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];//첫번째 숫자 기준으로 오름차순
			}
		});
		
		// LIS 최장증가수열의 원소 갯수 구하기 = 설치 가능한 전깃줄의 개수
		for (int i = 0; i < N; i++) {
			dp[i]=1;
			for (int j = 0; j < i; j++) {
				if(wire[i][1] > wire[j][1]) {//이전 것들 j보다 기준이 되는 i가 커야함
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		// dp를 한번 돌면서 가장 큰 수를 찾는다 = 설치 가능한 가장 큰 전깃줄 수
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		// 전체 전선 갯수 - 최대 설치 가능 전선 갯수 = 없애야 하는 최소 전선 갯수
		System.out.println(N-max);
	}
}
