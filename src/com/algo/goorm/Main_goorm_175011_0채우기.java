package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_goorm_175011_0채우기 {

	static int N;
	static int[][] map;
	static int answer = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int y_0 = 0;
		int x_0 = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					y_0 = i;
					x_0 = j;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {//세로
			answer += map[i][x_0];
			answer += map[y_0][i];
		}
		System.out.println(answer);
	}
}
