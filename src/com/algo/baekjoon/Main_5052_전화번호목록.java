package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5052_전화번호목록 {

	static int T;
	static int N;
	static String answer;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			answer = "YES";
			N=Integer.parseInt(br.readLine());
			
			String[] number = new String[N];
			for (int n = 0; n < N; n++) {
				String s = br.readLine();
				number[n] = s;
			}
			
			Arrays.sort(number);//문자열 정렬해서 이전숫자가 다음숫자의 시작부분과 일치하는지만 확인!
			for (int i = 1; i < N; i++) {
				//"AABB".startsWith("AA") : "AABB"문자열에 "AA"있는지 확인
				if(number[i].startsWith(number[i-1])) {
					answer = "NO";
					i=N;
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
