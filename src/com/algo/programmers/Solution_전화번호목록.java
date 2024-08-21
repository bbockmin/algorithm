package com.ssafy.algo;

import java.util.Arrays;

public class Solution_전화번호목록 {

	public static void main(String[] args) {
		String[] phoneBook = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phoneBook));
		
	}

	private static boolean solution(String[] phoneBook) {
		Arrays.sort(phoneBook);
		for (int i = 0; i < phoneBook.length -1; i++) {
			if(phoneBook[i+1].startsWith(phoneBook[i])) {
				return false;//접두어인 경우 false
			}
		}
		//한바퀴 다 돌았는데도 없으면 접두어가 없는 것
		return true;
	}
}
