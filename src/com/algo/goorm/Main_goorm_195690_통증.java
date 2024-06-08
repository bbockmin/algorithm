package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_goorm_195690_통증 {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] item = {14,7,1};
		for (int i = 0; i < item.length; i++) {
			answer += (N/item[i]);//몫
			N %= item[i];//나머지
		}
		
		System.out.println(answer);
	}
}
