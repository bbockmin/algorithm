package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080_행렬 {

	static int N,M;
	static int[][] A;
	static int[][] B;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = s.charAt(j) -'0';
			}
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = s.charAt(j) -'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A[i][j]!=B[i][j] && (i+2<N && j+2<M)) {
					for (int y = i; y < i+3; y++) {
						for (int x = j; x < j+3; x++) {
							if(A[y][x]==0) {
								A[y][x]=1;
							} else {
								A[y][x]=0;
							}
						}
					}
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A[i][j]!=B[i][j]) {
					cnt=-1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
