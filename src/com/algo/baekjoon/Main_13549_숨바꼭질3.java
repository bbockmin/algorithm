package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {

	static int N,K;
	static boolean[] visit;
	static int MAX = 100001;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[MAX];
		
		Queue<Point> que = new LinkedList<>(); 
		que.offer(new Point(N,0));
		visit[N] = true;
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			//탈출
			if(p.location == K) {
				System.out.println(p.cnt);
				return;
			}
			
			//이동
			if(2*p.location < MAX) {
				if(!visit[2*p.location]) {
					visit[2*p.location] = true;
					que.offer(new Point(2*p.location, p.cnt));
				}
			}
			if(p.location-1 >=0) {
				if(!visit[p.location-1]) {
					visit[p.location-1] = true;
					que.offer(new Point(p.location-1, p.cnt +1));
				}
			}
			if(p.location+1 < MAX) {
				if(!visit[p.location+1]) {
					visit[p.location+1] = true;
					que.offer(new Point(p.location+1, p.cnt +1));
				}
			}						
		}
		
	}
	
	static class Point {
		int location;
		int cnt;
		public Point(int location, int cnt) {
			super();
			this.location = location;
			this.cnt = cnt;
		}
	}
}
