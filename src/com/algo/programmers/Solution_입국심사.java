package com.ssafy.algo;

import java.util.Arrays;

public class Solution_입국심사 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		
		long answer = 0;
		//times 오름차순
		Arrays.sort(times);
		//걸리는 시간으로 left, right 설정
		long left = times[0];
		long right = (long)times[times.length-1]*n;//오래걸리는 심사관한테 모두 받으면 제일 오래걸리는 시간
		
		while(left <= right) {
			long mid = (left+right)/2;
			long complete = 0;
			//심사관이 mid시간으로 몇명을 심사할 수 있는지 확인
			for (int i = 0; i < times.length; i++) {
				complete += mid/times[i];
			}
			if(complete < n) {//시간이 더 필요하니 큰수쪽으로 다시 탐색
				left = mid+1;
			} else {//더 최소가 나올 수 있으므로 작은 쪽으로 다시 탐색
				answer = mid;
				right = mid-1;	
			}
		}
		
		System.out.println(answer);
	}
}
