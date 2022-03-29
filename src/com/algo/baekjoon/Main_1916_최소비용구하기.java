package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

	static int N,M;
	static int tBus, fBus, cnt;
	static int to, from;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		int[] data = new int[N+1];//도착지로 가는 최소비용
		boolean[] visit = new boolean[N+1];
		Arrays.fill(data, Integer.MAX_VALUE);//초기화	
		
		ArrayList<Point>[] link = new ArrayList[N+1];//저장할 리스트 선언
		for (int n = 1; n < N+1; n++) {
			link[n]=new ArrayList<Point>();
		}
		
		StringTokenizer st = null;
		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			fBus=Integer.parseInt(st.nextToken());
			tBus=Integer.parseInt(st.nextToken());
			cnt=Integer.parseInt(st.nextToken());
			link[fBus].add(new Point(tBus,cnt));
		}
		
		st = new StringTokenizer(br.readLine());
		from=Integer.parseInt(st.nextToken());
		to=Integer.parseInt(st.nextToken());
		
		data[from]=0;//출발지에서는 비용이 안들음
		PriorityQueue<Point> que = new PriorityQueue<>();
		que.offer(new Point(from,0));
		
		//도착지에 도착할때까지 계속 돌린다
		while(!que.isEmpty()) {
			Point p = que.poll();
			int currentBus=p.tB;
			int currentCnt=p.c;
			if(visit[currentBus]) continue;
			visit[currentBus]=true;
			for(Point next : link[currentBus]) {//해당 출발선으로 갈 수 있는 곳 다 탐색
				int nextCnt = currentCnt+next.c;
				if(nextCnt<data[next.tB]) {//현재와 다음 비용 더한 것이 다음배열에 저장되어 있는 값보다 작으면 바꿔야함 -> 최소를 구해야 함
					data[next.tB] = nextCnt;
					que.offer(new Point(next.tB,nextCnt));
				}
			}
		}
		System.out.println(data[to]);
	}
	static class Point implements Comparable<Point>{
		int tB;
		int c;
		public Point(int tB, int c) {
			super();
			this.tB = tB;
			this.c = c;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.c-o.c;
		}
	}
}
