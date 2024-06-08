package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_goorm_195689_구름찾기깃발 {

	static int N;//N*N
	static int K;//찾아야 하는 깃발의 값
	static int[][] map;
	static int answer = 0;
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;//구름표시
				}
			}
		}
		
		//1.깃발 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == -1) continue;
				
				int cnt = 0;
				for (int d = 0; d < 8; d++) {
					int ny = i+dy[d]; 
					int nx = j+dx[d];
					
					if(!safe(ny,nx)) continue;
					if(map[ny][nx] == -1) {
						cnt++;
					}
				}
				if(cnt==K) {
					answer++;
				}
				
			}
		}
		
//		print(map);
		
		System.out.println(answer);
		
	}
	private static void print(int[][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static boolean safe(int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<N) {
			return true;
		} else {
			return false;
		}
	}
}
