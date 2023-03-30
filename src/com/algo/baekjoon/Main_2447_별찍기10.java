package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2447_별찍기10 {

	static int N;
	static String[][] map;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new String[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = " ";
			}
		}
		star(map, 0, 0, N);//map, y좌표, x좌표, N
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.append(map[i][j]);
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	private static void star(String[][] map, int y, int x, int n) {
		if(n==1) {//더이상 나눌 칸이 없을 때까지 반복
			map[y][x] = "*";
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(!(i==1&&j==1)) {
					star(map,y+i*(n/3),x+j*(n/3),(n/3));
				}
			}
		}
	}
}
