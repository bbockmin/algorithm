package com.ssafy.algo;

public class Solution_단어변환 {

	//begin->target이 몇번 안에 이루어지는지
	static boolean[] visit;
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution("hit","cog",new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
	}
	private static int solution(String begin, String target, String[] words) {
		visit = new boolean[words.length];
		dfs(begin, target, words, 0);
		
		return answer;
	}
	private static void dfs(String begin, String target, String[] words, int cnt) {
		if(begin.equals(target)) {
			answer = cnt;
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if(visit[i]) {
				continue;
			}
			
			int k = 0;//같은 스펠링이 몇개인지 확인
			for (int j = 0; j < begin.length(); j++) {
				if(begin.charAt(j) == words[i].charAt(j)) {
					k++;
				}
			}
			
			if(k == begin.length()-1) {//시작글자에서 한글자 빼고 모두 같은 경우
				visit[i] = true;
				dfs(words[i], target, words, cnt +1);
				visit[i] = false;
				
			}
		}
	}
}
