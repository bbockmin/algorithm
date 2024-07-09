package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {

	static int H, W;
	static int[] map;
	static int rain = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W-1; i++) {
			int now = map[i];
			int highestLeft = 0;
			int highestRight = 0;

			for (int left = i; left >= 0; left--) {
				highestLeft = Math.max(highestLeft, map[left]);
			}
			for (int right = i; right < W; right++) {
				highestRight = Math.max(highestRight, map[right]);
			}
			
			int min = Math.min(highestLeft, highestRight); //양옆 가장 큰 높이 둘 중 작은 높이만큼 물이 차 있음
			rain += (min-now);
		}
		
		System.out.println(rain);
	}
}
