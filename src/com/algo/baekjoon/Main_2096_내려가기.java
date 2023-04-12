package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기 {

	static int N;
	static int[][] map;
	static int[][] maxMap;
	static int[][] minMap;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		maxMap = new int[N][3];
		minMap = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==0) {
					maxMap[i][j]=map[i][j];
					minMap[i][j]=map[i][j];
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			maxMap[i][0] = Math.max(maxMap[i-1][0], maxMap[i-1][1])+map[i][0];
			maxMap[i][1] = Math.max(Math.max(maxMap[i-1][0], maxMap[i-1][1]), maxMap[i-1][2])+map[i][1];
			maxMap[i][2] = Math.max(maxMap[i-1][1], maxMap[i-1][2])+map[i][2];
			
			minMap[i][0] = Math.min(minMap[i-1][0], minMap[i-1][1])+map[i][0];
			minMap[i][1] = Math.min(Math.min(minMap[i-1][0], minMap[i-1][1]), minMap[i-1][2])+map[i][1];
			minMap[i][2] = Math.min(minMap[i-1][1], minMap[i-1][2])+map[i][2];
		}
		
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxMap[N-1][i]);
			min = Math.min(min, minMap[N-1][i]);
		}
		System.out.println(max+" "+min);
	}
}
