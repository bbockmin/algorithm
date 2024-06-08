package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main_goorm_195688_문자열나누기 {

	static int N;
	static String S;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		List<String[]> wordList = new ArrayList<>();//부분문자열 저장
		Set<String> set = new HashSet<>();//중복X
		
		for (int i = 1; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				String first = S.substring(0,i);//0~i-1
				String second = S.substring(i,j);//i~j-1
				String third = S.substring(j);//j~
				
				wordList.add(new String[] {first,second,third});
				
				set.add(first);
				set.add(second);
				set.add(third);
			}
		}
		
		List<String> P = new ArrayList<>(set);
		Collections.sort(P);//정렬
		
		Map<String, Integer> map = new HashMap<>();//부분문자열 점수 부여 (Map은 key,value 세팅 가능)
		for (int i = 0; i < P.size(); i++) {
			map.put(P.get(i), i+1);
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < wordList.size(); i++) {
			//점수
			int firstScore = map.get(wordList.get(i)[0]);
			int secondScore = map.get(wordList.get(i)[1]);
			int thirdScore = map.get(wordList.get(i)[2]);
			int sum = firstScore+secondScore+thirdScore;
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
