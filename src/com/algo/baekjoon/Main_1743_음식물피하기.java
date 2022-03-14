package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1743_음식물피하기 {

	static int N,M,K,r,c;
	static int[] dy= {0,0,1,-1};
	static int[] dx= {1,-1,0,0};
	static int[][] map;
	static int maxWaste;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			map[r][c]=-1;
		}
		
//		print(map);
		maxWaste=0;
		int max=0;
		Queue<Point> que = new LinkedList<>();
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=M; j++) {
				//음식물 발견
				max=0;
				if(map[i][j]==-1) {
					que.offer(new Point(i,j));
					map[i][j] = 1;
					max++;
				}
				//개수확인
				while(!que.isEmpty()) {
					Point p = que.poll();
					for (int d = 0; d < 4; d++) {
						int ny=p.y+dy[d];
						int nx=p.x+dx[d];
						if(!safe(ny,nx)) continue;
						if(map[ny][nx]!=-1) continue;
						que.offer(new Point(ny,nx));
						map[ny][nx]=1;
						max++;
					}
				}
				maxWaste=Math.max(max, maxWaste);
			}
		}
		System.out.println(maxWaste);
	}
	private static boolean safe(int y, int x) {
		if(y>=1&&y<=N&&x>=1&&x<=M) {
			return true;			
		} else {
			return false;
		}
	}
	private static void print(int[][] map) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
			
		}
	}
	static class Point{
		int y;
		int x;
		
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

}
