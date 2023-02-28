package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_가장큰정사각형 {

	static int n, m;
	static int[][] map;
	static int[][] dp;
	static int maxlenght = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 1) {
					//이전 것들도 1인지 확인
					if((i>0 && j>0) && (dp[i-1][j] > 0 &&dp[i][j-1] > 0 && dp[i-1][j-1] > 0)) {
						//이전 것들도 다 1이면 이전것들 중에서 제일 작은 변의 크기와 본인 변의 크기 1을 더함
						dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]) + 1;
					} else {
						//이전 것들 중 0이 있으면 본인 변의 크기 1만 고려
						dp[i][j] = 1;
					}
					
					//최대값
					maxlenght = Math.max(maxlenght, dp[i][j]);
				}
			}
		}
		
		System.out.println(maxlenght*maxlenght);
	}
}
