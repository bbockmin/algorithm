package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림 {

	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int cnt = 0;
	static int area = 0;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	static int maxArea = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visit[i][j] && map[i][j]==1) {
					cnt++;
					map[i][j] = cnt;
					visit[i][j] = true;
					area = 1;
					bfs(i,j);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxArea);
	}
	private static void bfs(int i, int j) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(i,j));
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if(!safe(ny,nx)) continue;
				if(!visit[ny][nx] && map[ny][nx]==1) {
					visit[ny][nx]=true;
					area++;
					que.offer(new Point(ny,nx));
				}
			}
		}
		maxArea = Math.max(area, maxArea);
	}
	
	private static boolean safe(int y, int x) {
		if(y>=0&&y<n&&x>=0&&x<m)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
