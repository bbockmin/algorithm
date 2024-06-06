package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18406_럭키스트라이크 {

	static String N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = br.readLine();
		
		int mid = N.length()/2;//두번째 시작 인덱스
		int first = 0;
		int second = 0;
		
		for (int i = 0; i < N.length(); i++) {
			int num = N.charAt(i) - '0';
			if(i < mid) {
				first += num;
			} else {
				second += num;
			}
		}
		
		System.out.println(first == second ? "LUCKY" : "READY");
		
	}
}
