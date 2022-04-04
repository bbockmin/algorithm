package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226_이모티콘 {

	static int S;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S=Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[1001][1001];//y:화면의 이모티콘 개수, x:클립보드 이모티콘 개수 동시에 확인해야 함 
													//(화면의 이모티콘 개수, 클립보드 이모티콘 개수가 같아도 시간이 다를 수 있음)
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(1,0,0));//이미 화면에 이모티콘 1개 입력
		visit[1][0]=true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Point p = que.poll();
				int curr = p.current;
				int clip = p.clip;
				int t = p.time;
				if(curr==S) {
					System.out.println(t);
					return;
				}
				//모두 복사
				if(!visit[curr][curr]) {
					visit[curr][curr]=true;
					que.offer(new Point(curr,curr,t+1));
				}
				//화면에 붙이기
				if(curr+clip<=1000 && !visit[curr+clip][clip]) {
					visit[curr+clip][clip]=true;
					que.offer(new Point(curr+clip,clip,t+1));
				}
				//하나 삭제
				if(curr-1>0 && !visit[curr-1][clip]) {
					visit[curr-1][clip]=true;
					que.offer(new Point(curr-1,clip,t+1));
				}
			}
		}
	}
	static class Point {
		int current;
		int clip;
		int time;
		public Point(int current, int clip, int time) {
			super();
			this.current = current;
			this.clip = clip;
			this.time = time;
		}
	}
}
