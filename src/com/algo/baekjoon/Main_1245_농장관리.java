package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1245_농장관리 {

	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int result = 0;
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static boolean flag;//자신보다 큰 높이가 있는지 판단
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(!visit[n][m]) {
					flag = true;
					dfs(n,m);
					if(flag) {
						result++;					
					}
				}
			}
		}
		System.out.println(result);
	}
	
	private static void dfs(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(safe(ny,nx)) {
				if(map[y][x] < map[ny][nx]) {
					//현재 높이보다 큰 높이다 주변에 있으면 산봉오리 아님
					flag = false;
				}
				if(!visit[ny][nx] && map[y][x] == map[ny][nx]) {
					//한번도 방문 안하고 현재 높이와 주변 높이가 같은 높이면 방문체크를 함
					visit[ny][nx] = true;
					dfs(ny,nx);
				}
			}
		}
		return;
	}

	private static boolean safe(int i, int j) {
		if(i>=0&&i<N&&j>=0&&j<M) {
			return true;
		} else {
			return false;
		}
	}
}
