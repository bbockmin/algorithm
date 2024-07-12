package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_AtoB {

	static int cnt = 0;
	static long A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		Queue<Long> que = new LinkedList<>();
		que.add(A*2);
		que.add(A*10+1);
		
		while(!que.isEmpty()) {
			cnt++;
			int size = que.size();
			
			for (int i = 0; i < size; i++) {
				long now = que.poll();
				if(now > B) continue;
				if(now == B) {
					System.out.println(cnt +1);
					return;
				}
				que.add(now*2);
				que.add(now*10+1);
			}
		}
		System.out.println(-1);
	}

}
