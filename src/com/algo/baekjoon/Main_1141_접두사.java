package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main_1141_접두사 {

	static int N;
	static String[] data;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		data=new String[N];
		for (int i = 0; i < N; i++) {
			data[i]=br.readLine();
		}
		
		Set<String> X = new HashSet<>();//중복X
		for (int i = 0; i < N; i++) {
			int cnt=0;//접두사가 아닐때 카운트
			for (int j = 0; j < N; j++) {
				if(i!=j) { //자기자신은 비교X
					if(data[i].length()<=data[j].length()) { //자기자신보다 같거나 큰 것만 비교O
						for (int k = 0; k < data[i].length(); k++) {
							if(data[i].equals(data[j])) {//똑같으면 접두어가 아님!!!! 접두어는 앞부분에 속한 것만!!
								cnt++;
								break;
							}
							if(data[i].charAt(k)!=data[j].charAt(k)) {
								cnt++;
								break;
							}
						}
					} else {
						cnt++;
					}
				}
			}
			if(cnt==N-1) {//접두어가 아닌 경우가 N-1(본인제외)인경우 진짜 접두어 아님
				X.add(data[i]);
			}
		}
//		System.out.println(X.toString());
		System.out.println(X.size());
	}
}
