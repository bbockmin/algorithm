package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int length1 = str1.length;
		int length2 = str2.length;
		int[][] dp = new int[length1+1][length2+1];
		
		for(int i=1; i<=length1; i++) {
			for(int j=1; j<=length2; j++) {
				if(str1[i-1] == str2[j-1]) {//i번째 문자1과 문자2이 같으면
					dp[i][j] = dp[i-1][j-1]+1;//왼쪽 위대각선의 값 +1
				} else {//같이 않으면
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);//왼쪽 값, 위쪽 값 둘 중 큰 값으로 세팅
				}
			}
		}
		System.out.println(dp[length1][length2]);
	}
}
