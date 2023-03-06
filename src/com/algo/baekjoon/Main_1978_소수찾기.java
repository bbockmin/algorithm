package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {

	static int N;
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			for (int j = 2; j <= target; j++) {
				if(j==target) {
					cnt++;
				}
				if(target%j==0) {//나눠짐 -> 소수아님
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
