package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁전투 {

	static int N,M;
	static char[][] map;
	static boolean[][] visit;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visit = new boolean[M][N];
		for (int n = 0; n < M; n++) {
			String s = br.readLine();
			map[n]=s.toCharArray();
		}
		
		System.out.println(power('W')+" "+power('B'));
	}
	private static int power(char team) {
		result = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j]==team) {
					go(i,j,team);
				}
			}
		}
		
		return result;
	}
	private static void go(int i, int j, char team) {
		int human = 1;
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(i,j));
		visit[i][j]=true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny=p.i+dy[d];
				int nx=p.j+dx[d];
				
				if(!safe(ny,nx)) continue;
				if(visit[ny][nx]) continue;
				if(map[ny][nx]==team) {
					que.offer(new Point(ny, nx));
					visit[ny][nx]=true;
					human++;
				}
			}
		}
		
		result += Math.pow(human, 2);
	}
	private static boolean safe(int y, int x) {
		if(y>=0&&y<M&&x>=0&&x<N)
			return true;
		else
			return false;
	}
	static class Point {
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
