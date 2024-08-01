package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {

	//한번 입었던 옷들의 조합은 절대 다시 안 입음 -> 며칠동안 밖에 돌아다닐 수 있는지
	//의상의 이름, 의상의 종류 -> 의상의 종류와 의상의 갯수로 hashMap
	//같은 의상의 종류는 하나만 입을 수 있음
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T>0) {
			int N = Integer.parseInt(br.readLine());
			
			//데이터 세팅
			HashMap<String, Integer> hm = new HashMap<>();
			while(N>0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String dressName = st.nextToken();
				String dressType = st.nextToken();				
				
				if(hm.containsKey(dressType)) {//의상의 종류key가 있으면 value값에 +1
					hm.put(dressType, hm.get(dressType)+1);
				} else {
					hm.put(dressType, 1);
				}
				N--;
			}
			
			int answer = 1;
			for(int cnt : hm.values()) {
				answer *= (cnt + 1); //해당 의상의 종류를 안 착용하는 경우도 포함
			}
			System.out.println(answer - 1); //모든 의상을 착용 안하는 알몸인 경우 제외
			
			T--;
		}
	}
}
