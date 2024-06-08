package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_goorm_195691_폭탄구현하기2 {

	static int N;
	static int K;
	static String[][] map;
	static int[][] boom;
	static int answer = Integer.MIN_VALUE;
	static int[] dy = {-1,0,0,0,1};
	static int[] dx = {0,1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new String[N][N];
		boom = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		//폭탄 떨어트리기
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int boomy = Integer.parseInt(st.nextToken())-1;
			int boomx = Integer.parseInt(st.nextToken())-1;
			
			for (int d = 0; d < 5; d++) {
				int ny = boomy+dy[d];
				int nx = boomx+dx[d];
				if(!safe(ny,nx)) continue;
				
				if("#".equals(map[ny][nx])) {
					continue;
				} else if("0".equals(map[ny][nx]) ) {
					boom[ny][nx] += 1;
				} else if("@".equals(map[ny][nx]) ) {
					boom[ny][nx] += 2;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(boom[i][j],answer);
			}
		}
		System.out.println(answer);
		
	}
	private static boolean safe(int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<N) {
			return true;
		} else {
			return false;
		}
	}
}
