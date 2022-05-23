package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1913_달팽이 {

	static int N;
	static int P;
	static int[][] map;
	static int Py,Px;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		P=Integer.parseInt(br.readLine());
		map = new int[N][N];
		int cnt = N*N;
		int y = -1;//[0][0]부터 시작하기 위해 그 전 [-1][0]위치에서 초기화
		int x = 0;
		int step = N;
		int direct = 1;
		
		while(true) {
			for (int i = 0; i < step; i++) {//위쪽, 아래쪽
				y = y + direct;
				if(cnt==P) {
					Py=y;
					Px=x;
				}
				map[y][x] = cnt;
				cnt--;
			}
			
			step--;
			
			if(step<1) {
				print(map);
				return;
			}
			
			for (int i = 0; i < step; i++) {//오른쪽, 왼쪽
				x = x + direct;
				if(cnt==P) {
					Py=y;
					Px=x;
				}
				map[y][x] = cnt;
				cnt--;
			}
			
			direct = direct * -1;
		}
		
	}
	private static void print(int[][] map) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(map[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.write((Py+1)+" "+(Px+1));
		bw.flush();
		bw.close();
	}
}
