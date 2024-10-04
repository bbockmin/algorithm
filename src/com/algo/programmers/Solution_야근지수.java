package com.ssafy.algo;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_야근지수 {
	public static void main(String[] args) {
		System.out.println(solution(1, new int[] {2,1,2}));
	}

	private static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < works.length; i++) {
			que.offer(works[i]);
		}
		
		while(n > 0) {//작업시간이 없으면 반복문 해제
			int work = que.poll();
			if(work == 0) {
				break;
			}
			work -= 1; //일한 시간 줄이기
			que.offer(work);
			n -= 1; //일했으니까 작업시간 줄이기
		}
		
		for(int work : que) {
			answer += Math.pow(work, 2);
		}
		
        return answer;
	}

}
