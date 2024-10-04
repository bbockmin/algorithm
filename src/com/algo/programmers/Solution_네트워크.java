package com.ssafy.algo;

public class Solution_네트워크 {

	public static void main(String[] args) {
		System.out.println(solution(3,new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] check = new boolean[n];
        
        for (int i = 0; i < n; i++) {
			if(!check[i]) {
				dfs(i,computers,check);
				answer++;
			}
		}
        
        return answer;
    }

	private static void dfs(int i, int[][] computers, boolean[] check) {
		check[i] = true;
		
		for (int j = 0; j < computers.length; j++) {
			if(i!=j && computers[i][j] == 1 && !check[j]) {
				//행!=열 && 1이고 && 컴퓨터가 아무도 접근 안한 false인 경우
				dfs(j, computers, check);
			}
		}
	}
}
