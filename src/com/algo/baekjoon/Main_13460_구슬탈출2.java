package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {

	static int N,M;
	static char[][] map;
	static int[] dy= {-1,0,1,0};//위 오 아래 왼
	static int[] dx= {0,1,0,-1};
	static int Ry=0,Rx=0,By=0,Bx=0;
	static boolean[][][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new boolean[N][M][N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				char text = s.charAt(j);
				if(text=='R') {
					Ry=i;
					Rx=j;
				} else if(text=='B') {
					By=i;
					Bx=j;
				}
				map[i][j] = text;
			}
		}
		System.out.println(bfs(Ry,Rx,By,Bx,0));
	}
	
	private static int bfs(int ry, int rx, int by, int bx, int cnt) {

		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(ry,rx,by,bx,cnt));
		visit[ry][rx][by][bx]=true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();

			if(p.cnt+1>10) {//이번 굴리는 판이 10초과면 할 필요 없음
				return -1;
			}
			
			for (int d = 0; d < 4; d++) {
				boolean rHole = false;//구멍에 들어갔는지 확인
				boolean bHole = false;
				
				int nextRy = p.ry;
				int nextRx = p.rx;
				int nextBy = p.by;
				int nextBx = p.bx;
				
				while(map[nextRy+dy[d]][nextRx+dx[d]]!='#') {//R 벽 닿을때까지 이동
					nextRy+=dy[d];
					nextRx+=dx[d];
					if(map[nextRy][nextRx]=='O') {
						rHole=true;
						break;
					}
				}
				while(map[nextBy+dy[d]][nextBx+dx[d]]!='#') {//B 벽 닿을때까지 이동
					nextBy+=dy[d];
					nextBx+=dx[d];
					if(map[nextBy][nextBx]=='O') {
						bHole=true;
						break;
					}
				}
				if(bHole) {//B 구멍에 빠지면 실패
					continue;//다른 경로에 정답이 있을 수 있으니 continue
				}
				if(rHole&&!bHole) {//성공
					return p.cnt+1;
				}
				if(nextRy==nextBy && nextRx==nextBx) {//R, B 같은 위치일 경우
					if(d==0) {//위
						if(p.ry>p.by) {
							nextRy-=dy[d];
						} else {
							nextBy-=dy[d];
						}
					} else if(d==1) {//오
						if(p.rx>p.bx) {
							nextBx-=dx[d];
						} else {
							nextRx-=dx[d];
						}
					} else if(d==2) {//아래
						if(p.ry>p.by) {
							nextBy-=dy[d];
						} else {
							nextRy-=dy[d];
						}
					} else if(d==3) {//왼
						if(p.rx>p.bx) {
							nextRx-=dx[d];
						} else {
							nextBx-=dx[d];
						}
					} 
				}
				if(!visit[nextRy][nextRx][nextBy][nextBx]) {
					visit[nextRy][nextRx][nextBy][nextBx]=true;
					que.offer(new Point(nextRy,nextRx,nextBy,nextBx,p.cnt+1));
				}
			}
		}
		
		return -1;
	}
	
	private static boolean safe(int y, int x) {
		if(y>=0&&y<=N&&x>=0&&x<=M)
			return true;
		else
			return false;
	}

	static class Point {
		int ry;
		int rx;
		int by;
		int bx;
		int cnt;
		
		public Point(int ry, int rx, int by, int bx, int cnt) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.cnt = cnt;
		}
	}
	
	private static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
