package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {

	static int N,M,S,E;
	static int[] data;
	static boolean[][] dp;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		data = new int[N+1];
		dp = new boolean[N+1][N+1];
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i]=Integer.parseInt(st.nextToken());
		}
		
		dp();
		M=Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			boolean flag = dp[S][E];
			bw.write(flag?"1":"0");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static void dp() {
		//S~E의 길이1 : 자기자신일때
		for (int i = 1; i <=N; i++) {
			dp[i][i]=true;
		}
		
		//S~E의 길이2 : 같으면 true
		for (int i = 1; i <=N-1; i++) {
			if(data[i]==data[i+1]) {
				dp[i][i+1]=true;
			}
		}
		
		//S~E의 길이3이상 : 양끝이 같고, 양끝 제외 dp가 같으면 true
		for (int i = 3; i <=N; i++) {//S~E의 길이
			for (int j = 1; j <=N-i+1; j++) {//S~E길이 내에서 양끝씩 비교
				if(data[j]==data[j+i-1] && dp[j+1][j+i-2]) {
					dp[j][j+i-1]=true;
				}
			}
		}
	}
}
