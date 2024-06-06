package com.ssafy.algo;

import java.util.Arrays;

public class Solution_징검다리 {

	public static void main(String[] args) {
		
		int distance = 25;
		int[] rocks = {2,14,11,21,17};
		int n = 2;
		
		int answer = 0;
		Arrays.sort(rocks);
		
		int left = 1;
		int right = distance;
		
		while(left <= right) {
			int mid = (left+right)/2;//최소거리
			int prev = 0;//시작지점
			int count = 0;//돌 제거 갯수
			
			for (int i = 0; i < rocks.length; i++) {
				if(rocks[i]-prev < mid) {//돌과 시작점의 간격이 mid(최소거리)보다 작으면 바위 제거
					count++;
				} else {
					prev = rocks[i];//시작점이 mid에 다다르면 시작점을 mid값으로 바꿔줌
				}
			}
			if(distance-prev < mid) {//맨 끝과 맨끝 직전 돌도 체크해야 함
				count++;
			}
			//제거 바위와 n값을 비교
			if(count > n) {//n보다 제거바위가 더 많으면 X
				right = mid - 1;//제거바위 갯수를 줄이기 위해 mid 줄임
			} else {
				left = mid + 1;
				answer = mid;
			}
		}
		
		System.out.println(answer);
	}
}
