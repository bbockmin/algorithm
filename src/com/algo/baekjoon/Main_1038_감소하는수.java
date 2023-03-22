package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_1038_감소하는수 {

	static int N;
	static ArrayList<Long> list = new ArrayList<>(); //감소하는 수 담을 리스트
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if(N<=10) {
			System.out.println(N);
		} else if(N>1022){//감소하는 수 중 제일 큰 수 9876543210
						//10자리 수 중 감소하는 수는 1023개
						//9876543210의 인덱스는 1022
						//1023이상 들어오면 감소하는 수를 만들 수 없음
			System.out.println(-1);
		} else {
			for (int i = 0; i < 10; i++) {
				DownNumber(i,1);
			}
			Collections.sort(list);
			System.out.println(list.get(N));
		}
	}
	
	private static void DownNumber(long num, int depth) {
		if(depth > 10) {//10자리수 초과면
			return;
		}
		list.add(num);
		
		//num이 처음에 올 숫자
		//num = 0 없음
		//num = 1 -> 1, 10
		//num = 2 -> 2, 20, 21, 210
		//num을 처음에 두고 10자리 만들기
		for (int i = 0; i < 10; i++) {
			if(num%10>i) {//num의 1의 자리 숫자가 i보다 크면 감소하는 수 만들 수 있음
				DownNumber((num*10)+i, depth+1);
			}
		}
		
	}
}
