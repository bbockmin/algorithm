package com.ssafy.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_이중우선순위큐 {

	//모든 연산 후 남은 최댓값, 최솟값을 구하기
	public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		System.out.println(Arrays.toString(solution(operations)));
		
	}

	private static int[] solution(String[] operations) {

		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer st;
		
		for (int i = 0; i < operations.length; i++) {
			st = new StringTokenizer(operations[i]);
			char op = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			
			switch (op) {
			case 'I':
				min.add(num);
				max.add(num);
				break;
			case 'D':
				if(max.isEmpty()) {
					break;
				}
				if(num == 1) {
					int del = max.poll();//최대우선순위 큐에서도 빼고
					min.remove(del);//최소우선순위 큐에서도 빼고
				} else if(num == -1) {
					int del = min.poll();//최소우선순위 큐에서도 빼고
					max.remove(del);//최대우선순위 큐에서도 빼고
				}

			default:
				break;
			}
		}
		
		if(max.isEmpty()) {
			return new int[] {0,0};
		}
		
		return new int[] {max.peek(), min.peek()};

	}

}
