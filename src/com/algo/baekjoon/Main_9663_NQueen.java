package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_NQueen {

	static int N;
	static int queen[];
	static int cnt=0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		queen = new int[N];
		
		dfs(0);//0행부터 퀸을 배치
		System.out.println(cnt);
		
	}
	private static void dfs(int row) {
		//경우의 수 달성 조건
		if(row == N) {//0부터 시작한 row가 N까지 간거면 퀸 배치가 다 됐다는 것
			cnt++;
			return;
		}
		
		//반복
		for (int i = 0; i < N; i++) {//1~N열까지 체크
			queen[row]=i;//[row,i]
			
			if(check(row)) {//상하좌우대각선에 퀸이 없는지 체크하고 넘어감
				dfs(row+1);//다음 행
			}
			
		}
		
	}
	private static boolean check(int row) {
		for (int i = 0; i < row; i++) {//기준행에서 이전행들만 체크(앞으로 놓을 자리를 체크하기 위함)
			//기준행에서 이전행과 같은 열의 위치에 있으면 안됨
			if(queen[row]==queen[i]) {
				return false;
			}
			//대각선에 있으면 안됨
			//'기준행-이전행'과 '기준열-이전열'의 차이가 같으면 대각선에 위치해 있는 것
			if(Math.abs(row-i)==Math.abs(queen[row]-queen[i])) {
				return false;
			}
		}

		return true;
	}
}
