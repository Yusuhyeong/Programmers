/*
문제 설명
문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

제한 조건
s의 길이는 1 이상 5이하입니다.
s의 맨앞에는 부호(+, -)가 올 수 있습니다.
s는 부호와 숫자로만 이루어져있습니다.
s는 "0"으로 시작하지 않습니다.
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String testcase = "1234";
		Solution solution = new Solution();
		System.out.println(Solution.solution(testcase));
	}
	
	static public int solution(String s) {
        int answer = 0;
        
        answer = Integer.valueOf(s);
        
        return answer;
    }
}
