package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_goorm_175177_거스름돈 {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] coin = {40,20,10,5,1};
		int answer = 0;
		for (int i = 0; i < coin.length; i++) {
			answer += (N/coin[i]);
			N %= coin[i];
		}
		System.out.println(answer);
	}
}
