package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7490_0만들기 {

	static int T;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			//합, 연산, 다음 연산값, 다음 수, 최종 수, 연산과정
			back(0, 1, 1, 1, N, "1");
			System.out.println();
		}
	}
	private static void back(int sum, int op, int next, int prev, int N, String s) {
		if(prev == N) {//다음 수 == 최종으로 가야 할 수 N
			sum += (next * op);//모든 연산을 하고 0이 되는 수만 출력
			if(sum == 0) {
				System.out.println(s);
			}
			return;
		}
		back(sum, op, next*10 + prev+1, prev+1, N, s+" "+(prev+1));
		back(sum+(next*op), 1, prev+1, prev+1, N, s+"+"+(prev+1));
		back(sum+(next*op), -1, prev+1, prev+1, N, s+"-"+(prev+1));
	}
}
