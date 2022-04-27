package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16197_두동전 {

	static int N,M;
	static char[][] map;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int cCnt=0;
		int c1y=0;
		int c1x=0;
		int c2y=0;
		int c2x=0;
		for (int i = 0; i < N; i++) {
			String s= br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='o') {
					if(cCnt==0) {
						c1y=i;
						c1x=j;
						cCnt++;
					} else {
						c2y=i;
						c2x=j;
					}
				}
			}
		}
		
		bt(new Point(c1y,c1x,c2y,c2x,0));
		
		if(answer == Integer.MAX_VALUE) {//절대 떨어뜨리지 못하는 경우
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		
	}
	
	private static void bt(Point p) {
		if(p.m >= 10) {
			return;
		}
		
		//1.이동
		for (int d = 0; d < 4; d++) {
			int outSideCnt = 0;
			int nc1y=p.c1y+dy[d];
			int nc1x=p.c1x+dx[d];
			int nc2y=p.c2y+dy[d];
			int nc2x=p.c2x+dx[d];
			int move = p.m+1;
			
			//1.칸이 없으면 떨어짐
			if(!safe(nc1y,nc1x)) {
				outSideCnt++;
			}
			//1.칸이 없으면 떨어짐
			if(!safe(nc2y,nc2x)) {
				outSideCnt++;
			} 
			
			//2.map에 동전 1개만 있는지 확인
			if(outSideCnt == 2) {
				continue;
			}
			if(outSideCnt == 1) {
				answer = Math.min(answer, move);
				return;
			}
			
			//3.다음 위치가 벽이면 그 자리 그대로
			if(map[nc1y][nc1x] == '#') {
				nc1y=p.c1y;
				nc1x=p.c1x;
			}
			if(map[nc2y][nc2x] == '#') {
				nc2y=p.c2y;
				nc2x=p.c2x;
			}
			bt(new Point(nc1y,nc1x,nc2y,nc2x,move));
			
		}
	}

	private static boolean safe(int y, int x) {
		if(y>=0 && y<N && x>=0 && x<M)
			return true;
		else
			return false;
	}

	static class Point {
		int c1y;
		int c1x;
		int c2y;
		int c2x;
		int m;
		public Point(int c1y, int c1x, int c2y, int c2x, int m) {
			super();
			this.c1y = c1y;
			this.c1x = c1x;
			this.c2y = c2y;
			this.c2x = c2x;
			this.m = m;
		}
	}
}
