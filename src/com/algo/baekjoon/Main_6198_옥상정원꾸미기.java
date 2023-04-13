package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198_옥상정원꾸미기 {

	static int N;
	static Stack<Integer> st = new Stack<>();
	static long result = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			
			while(!st.isEmpty() && st.peek()<=h) {
				//현재 건물보다 이전 건물들 중 낮거나 같은 건물 제외
				//현재 건물을 관측할 수 있는 빌딩이 아님
				st.pop();
			}
			result += st.size();//현재 건물을 관측할 수 있는 빌딩의 수를 먼저 더하고
			st.push(h);//그다음에 스택에 푸시
		}
		
		System.out.println(result);
	}
}
