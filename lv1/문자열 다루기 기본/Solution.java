/*
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.

입출력 예
s		return
"a234"	false
"1234"	true
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String testcase = "a234";
		Solution solution = new Solution();
		System.out.println(solution(testcase));
	}
	
	public static boolean solution(String s) {
        boolean answer = true;
        
        if(!(s.length() == 4) && !(s.length() == 6)) {
            // System.out.println("길이가 4, 6이 아님");
            answer = false;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if((int) s.charAt(i) - 48 < 0 || (int) s.charAt(i) - 48 > 9) {
                // System.out.println((int) s.charAt(i));
                // System.out.println("문자도 있음");
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}
