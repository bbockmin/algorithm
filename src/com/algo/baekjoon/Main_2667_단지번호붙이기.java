package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {

	static int N;
	static int[][] home;
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int homeNumber = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		home = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				home[i][j] = s.charAt(j) - '0';//char형이라서 문자열 0뺴주기
			}
		}
		
//		arrPrint(home);
		
		//1.단지 번호 붙이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(home[i][j]==1 && !visit[i][j]) {
					homeNumber++;
					home[i][j] = homeNumber;
					visit[i][j] = true;
					bfs(i,j);
				}
			}
		}
		
		//2.단지수 배열 담기
		int[] homeLive = new int[homeNumber];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = home[i][j];//단지 번호
				if(n!=0) {
					homeLive[n-1]++;//배열에는 0부터 담기					
				}
			}
		}
		
		//3.오름차순 정렬
		Arrays.sort(homeLive);
		
		System.out.println(homeNumber);
		for (int i = 0; i < homeLive.length; i++) {
			System.out.println(homeLive[i]);
		}
	}
	
	private static void bfs(int i, int j) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(i,j));
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if(!safe(ny,nx)) {
					continue;
				}
				if(home[ny][nx]==1 && !visit[ny][nx]) {
					que.offer(new Point(ny,nx));
					visit[ny][nx] = true;
					home[ny][nx] = homeNumber;
				}
			}
		}
	}

	private static boolean safe(int y, int x) {
		if(y>=0&&y<N&&x>=0&&x<N) {
			return true;
		} else {
			return false;			
		}
	}

	public static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	private static void arrPrint(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
