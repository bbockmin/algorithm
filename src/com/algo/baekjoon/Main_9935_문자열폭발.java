package com.ssafy.algo;

import java.awt.image.ReplicateScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발 {

	static String message;
	static String boom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		message = br.readLine();
		boom = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		//한글자씩 비교
		for (int i = 0; i < message.length(); i++) {
			st.push(message.charAt(i));
			
			if(st.size()>=boom.length()) {
				boolean contain = true;
				
				for (int j = 0; j < boom.length(); j++) {
					if(st.get(st.size()-boom.length()+j)!=boom.charAt(j)) {
						contain = false;
						break;
					}
				}
				if(contain) {
					for (int j = 0; j < boom.length(); j++) {
						st.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < st.size(); i++) {
			sb.append(st.get(i));
		}
		
		System.out.println((st.size()==0)?"FRULA":sb.toString());	
	}
}
