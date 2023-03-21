package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2195_문자열복사 {

	static String S;
	static String P;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		P = br.readLine();
		
		int start = 0;
		for (int i = 0; i < P.length(); i++) {
			if(S.contains(P.substring(start,i+1))) {
				//P의 start~i+1이 S에 포함이 되면 i 계속 늘리기
				continue;
			}
			//포함이 안되면
			cnt++;//그 이전까지 최대 길이로 포함이 됐다는 의미로 cnt+1
			start = i;//시작위치 바꿔주기
		}
		System.out.println(cnt+1);//S==P인 경우와 마지막 부분문자는 for문 안에서 cnt+1되지 않기 떄문에
	}
}
