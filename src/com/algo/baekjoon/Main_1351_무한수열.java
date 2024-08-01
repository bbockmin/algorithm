package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1351_무한수열 {

	//A[0] = 1
	//A[i] = A[i/P] + A[i/Q]
	//일때 A[N]을 구하라
	//key중복X, value
	static HashMap<Long, Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long N = Long.parseLong(st.nextToken());
		Long P = Long.parseLong(st.nextToken());
		Long Q = Long.parseLong(st.nextToken());
		
		map.put(0L, 1L);//A[0] = 1
		System.out.println(getValue(N,P,Q));
	}
	
	private static Long getValue(Long N, Long P, Long Q) {
		if(N==0) {//A[0] = 1
			return 1L;
		} 
		if(map.containsKey(N)) {
			return map.get(N);//A[N]
		}
		
		Long value1 = N/P;
		Long value2 = N/Q;
		
		map.put(N, getValue(value1, P, Q)+getValue(value2, P, Q));//A[i] = A[i/P] + A[i/Q]
	
		return map.get(N);//A[N]
	}
}
