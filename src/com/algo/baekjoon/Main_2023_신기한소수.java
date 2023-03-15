package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {

	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		bt("",0);//"":소수가 될 문자열s, 0:자릿수N가 될 cnt
		System.out.println(sb.toString());
	}
	
	//백트래킹
	private static void bt(String s, int cnt) {
		if(cnt==N) {
			sb.append(s+"\n");
		}
		for (int i = 0; i <= 9; i++) {//1~9까지 다 붙여보기
			if(isPrime(Integer.parseInt(s+i))) {
				bt(s+i,cnt+1);
			}
		}
	}
	
	//소수 판별 함수
	private static boolean isPrime(int num) {

		for (int i = 2; i <= num; i++) {
			if(i==num) {//1이랑 본인밖에 안 나눠짐 -> 소수O
				return true;
			}
			if(num%i==0) {//중간에 나눠짐 -> 소수X
				break;
			}
		}
		return false;
	}
}
