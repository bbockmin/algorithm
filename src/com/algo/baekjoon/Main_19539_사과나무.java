package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19539_사과나무 {

	static int N;
	static int sum;
	static int oddNumberTree;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tree = Integer.parseInt(st.nextToken());
			sum += tree;
			
			if(tree%2==1) {//나머지가 1이면 홀수 => 홀수 높이 나무 = 2물뿌리개로 성장시킬 수 없는 횟수 = 1물뿌리개가 꼭 필요한 횟수
				oddNumberTree++;
			}
		}
		
		//1물뿌리개랑 1물뿌리개랑 뿌리는 횟수는 같음
		//합이 3으로 나눠져야 하고, 물을 최대한 뿌릴 수 있는 횟수(sum/3)가 1이 꼭 필요한 횟수(oddNumberTree)보다 크거나 같아야 함
		if((sum%3==0)&&(sum/3>=oddNumberTree)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
