package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10453_문자열변환 {

	static int T;
	static int result;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			
			if(A.length() != B.length()) {
				System.out.println(-1);
				continue;
			}
			//a위치 저장할 배열
			ArrayList<Integer> Aarr = new ArrayList<>();
			ArrayList<Integer> Barr = new ArrayList<>();
			
			for (int i = 0; i < A.length(); i++) {
				if(A.charAt(i) == 'a') {
					Aarr.add(i);
				}
				if(B.charAt(i) == 'a') {
					Barr.add(i);
				}
			}
			
			if(Aarr.size() != Barr.size()) {
				System.out.println(-1);
				continue;
			}
			
			Collections.sort(Aarr);
			Collections.sort(Barr);
			
			for (int i = 0; i < Aarr.size(); i++) {
				if(Aarr.get(i) != Barr.get(i)) {
					result += Math.abs(Aarr.get(i)-Barr.get(i));
				}
			}
			System.out.println(result);
		}
	}
}
