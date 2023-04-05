package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_16938_캠프준비 {

	static int N;
	static long L, R, X;
	static long[] A;
	static Stack<Long> Q = new Stack<>();//2~N길이의 난이도 조합을 담을 스택
	static int answer = 0;//조건이 맞는 경우의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		R = Long.parseLong(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		A = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 2; i <=N; i++) {//캠프에 사용할 문제가 2개이상
			back(0,i);//0번째부터 i갯수의 문제 조합 찾기
		}
		System.out.println(answer);
	}
	private static void back(int number, int cnt) {
		
		if(Q.size()==cnt) {//탈출조건
			long sum=0;
			long min = Long.MAX_VALUE;
			long max = Long.MIN_VALUE;
			for (int i = 0; i < cnt; i++) {
				sum += Q.get(i);
				min = Math.min(min, Q.get(i));
				max = Math.max(max, Q.get(i));
			}
			if(L<=sum && sum<=R && (max-min)>=X) {
				answer++;
			}
			return;
			
		}
		for (int i = number; i < N; i++) {
			Q.push(A[i]);//문제 난이도
			back(i+1,cnt);
			Q.pop();
		}
	}
}
