package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_25328_문자열집합 {

	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] xArray = br.readLine().toCharArray();
		char[] yArray = br.readLine().toCharArray();
		char[] zArray = br.readLine().toCharArray();
		
		int k = Integer.parseInt(br.readLine());
		
		comb(xArray, new boolean[xArray.length], 0, k);
		comb(yArray, new boolean[yArray.length], 0, k);
		comb(zArray, new boolean[zArray.length], 0, k);
		
		//map값 세팅 후
		ArrayList<String> list = new ArrayList<>();
		for(String key : map.keySet()) {
			if(map.get(key) >= 2) {//2개 이상이 같은 조합의 문자가 있다는 의미
				list.add(key);
			}
		}
		if(list.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		Collections.sort(list);//정렬
		for(String str : list) {
			System.out.println(str);
		}

	}
	private static void comb(char[] array, boolean[] visited, int start, int n) {
		if(n == 0) {
			StringBuilder sb = new StringBuilder("");
			
			for(int i=0; i<array.length; i++) {
				if(visited[i]) {
					sb.append(array[i]);
				}
			}
			
			String key = sb.toString();
			map.put(key, map.getOrDefault(key, 0) +1);//같은 문자 갯수 체크
			
			return;
		}
		for(int i =start; i<array.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(array, visited, i+1, n-1);
				visited[i] = false;
			}
		}
		
	}

}
