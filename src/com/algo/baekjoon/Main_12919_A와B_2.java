package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12919_A와B_2 {

	static String S, T; //S->T
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		dfs(T);
		System.out.println(answer);
	}
	private static void dfs(String t) {
		// 1. T문자열의 맨뒤가 A일 경우 A 제거
		// 2. T문자열의 맨앞이 B일 경우 문자열을 뒤집고 B를 제거
		int lenT = t.length();
		
		if(lenT == S.length()) {
			if(t.equals(S)) {
				answer = 1;
			}
			return;
		}
		
		if(t.endsWith("A")) {
			dfs(t.substring(0,lenT-1));
		}
		
		if(t.startsWith("B")) {
			String reverseT = new StringBuffer(t).reverse().toString();
			dfs(reverseT.substring(0,reverseT.length()-1));
		}
		
	}
}
