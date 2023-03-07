package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_16500_문자열판별 {

	static String S;
	static int N;
	static int[] dp;
	static Set<String> A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		N = Integer.parseInt(br.readLine());
		dp = new int[S.length()];
		A = new HashSet<String>();
		
		for (int n = 0; n < N; n++) {
			A.add(br.readLine());
		}
		
		for (int i = S.length(); i >= 0; i--) {//뒤에서 부터 자르기
			for (int j = i+1; j < S.length(); j++) {//i~j로 잘라서 비교
				if(dp[j]==1) {//j~어떤 지점 까지 A문자열이 포함되어 있다는 뜻
					if(A.contains(S.substring(i, j))) {//i~j-1까지의 자른 문자가 A문자열에 포함하는지
						dp[i]=1;//문자열 앞쪽에 1로 뒤에서부터 여기까지는 A문자열이 포함되어 있다는 걸 표시
					}
				}
			}
			if(A.contains(S.substring(i))) {//i부터 뒤에 있는 문자열이 A에 포함되어 있는지
				dp[i]=1;
			}
		}
		
		System.out.println(dp[0]);//0이 1이면 S의 모든 문자열이 A로 구성되어 있음을 알 수 있음
	}
}
