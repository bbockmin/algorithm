package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2251_물통 {

	static int maxA,maxB,maxC;
	static ArrayList<Integer> cWater;
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxA = Integer.parseInt(st.nextToken());
		maxB = Integer.parseInt(st.nextToken());
		maxC = Integer.parseInt(st.nextToken());
		
		cWater = new ArrayList<>();
		
		move();
		
		Collections.sort(cWater);
		for (int i = 0; i < cWater.size(); i++) {
			System.out.print(cWater.get(i)+" ");
		}
	}
	private static void move() {
		Queue<Buttle> que = new LinkedList<>();
		visit = new boolean[maxA+1][maxB+1][maxC+1];//용량이 0~maxA,0~maxB,0~maxC까지 있어서 +1해줘야 함
		
		que.offer(new Buttle(0,0,maxC));//초기상태
		while(!que.isEmpty()) {
			Buttle b = que.poll();
			
			if(visit[b.A][b.B][b.C]) {
				continue;//방문한 적 있으면 넘기기				
			}
			
			if(b.A==0) {
				cWater.add(b.C);
			}
			
			visit[b.A][b.B][b.C] = true;//방문
			
			//다른 한 통이 비거나
			//다른 한 통이 가득 차는 경우를 다 고려해야 함
			//A->B
			if(b.A+b.B<=maxB) {//A가 비는 경우
				que.offer(new Buttle(0,b.A+b.B,b.C));
			} else {//B가 가득 차는 경우
				que.offer(new Buttle(b.A-(maxB-b.B),maxB,b.C));
			}
			//A->C
			if(b.A+b.C<=maxC) {//A가 비는 경우
				que.offer(new Buttle(0,b.B,b.A+b.C));
			} else {//C가 가득 차는 경우
				que.offer(new Buttle(b.A-(maxC-b.C),b.B,maxC));
			}
			//B->A
			if(b.B+b.A<=maxA) {
				que.offer(new Buttle(b.A+b.B,0,b.C));
			} else {
				que.offer(new Buttle(maxA,b.B-(maxA-b.A),b.C));
			}
			//B->C
			if(b.B+b.C<=maxC) {
				que.offer(new Buttle(b.A, 0, b.B+b.C));
			} else {
				que.offer(new Buttle(b.A,b.B-(maxC-b.C),maxC));
			}
			//C->A
			if(b.C+b.A<=maxA) {
				que.offer(new Buttle(b.A+b.C, b.B, 0));
			} else {
				que.offer(new Buttle(maxA, b.B, b.C-(maxA-b.A)));
			}
			//C->B
			if(b.C+b.B<=maxB) {
				que.offer(new Buttle(b.A, b.B+b.C, 0));
			} else {
				que.offer(new Buttle(b.A, maxB, b.C-(maxB-b.B)));
			}
		}
	}
	
	static class Buttle {
		int A;
		int B;
		int C;
		public Buttle(int a, int b, int c) {
			super();
			A = a;
			B = b;
			C = c;
		}
	}
}
