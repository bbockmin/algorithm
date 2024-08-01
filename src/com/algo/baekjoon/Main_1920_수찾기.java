package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

	//배열 M이 배열 A에 존재하는지 여부
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N;
		HashSet<Integer> hs = new HashSet<>();//존재 여부만 확인 -> 순서X, 중복X
		int M;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int mNumber = Integer.parseInt(st.nextToken());
			System.out.println(hs.contains(mNumber) ? "1" : "0");
		}
		
		
	}
}
