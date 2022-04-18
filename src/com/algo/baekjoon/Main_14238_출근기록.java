package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14238_출근기록 {

	static String s;
	static int Acnt=0,Bcnt=0,Ccnt=0;
	static boolean[][][][][] dp;//dp[A개수][B개수][C개수][전날 출근][전전날 출근]
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='A') {
				Acnt++;
			} else if(s.charAt(i)=='B') {
				Bcnt++;
			} else if(s.charAt(i)=='C') {
				Ccnt++;
			} 
		}
		dp = new boolean[Acnt+1][Bcnt+1][Ccnt+1][3][3];
		
		go(Acnt,Bcnt,Ccnt,"",0,0);
		
		if(!flag) {
			System.out.println("-1");
		}
	}
	private static void go(int acnt, int bcnt, int ccnt, String answer, int pre, int ppre) {
		if(flag) {//경우의 수가 여러개일 수 있다. 그 중 하나만 출력
			return;
		}
		if(acnt==0&&bcnt==0&&ccnt==0) {
			System.out.println(answer);
			flag = true;
			return;
		}
		
		if(dp[acnt][bcnt][ccnt][pre][ppre]) {//방문체크
			return;
		}
		dp[acnt][bcnt][ccnt][pre][ppre]=true;
		
		if(acnt>0) {
			go(acnt-1,bcnt,ccnt,answer+"A",0,pre);
		}
		if(bcnt>0 && pre!=1) {
			go(acnt,bcnt-1,ccnt,answer+"B",1,pre);
		}
		if(ccnt>0 && pre!=2 && ppre!=2) {
			go(acnt,bcnt,ccnt-1,answer+"C",2,pre);
		}
	}
}
