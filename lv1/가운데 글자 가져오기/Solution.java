/*
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.

입출력 예
s			return
"abcde"		"c"
"qwer"		"we"
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String testcase = "abcde";
		Solution solution = new Solution();
		System.out.println(solution(testcase));
	}
	
	public static String solution(String s) {
        String answer = "";
        int size = s.length();
        
        if(size % 2 == 1) { // 글자 길이가 홀수
            if(size != 1) {
                size = size / 2;
                answer = answer + s.charAt(size);
            }
            else {
                answer = s;
            }
            
        }
        else { // 글자 길이가 짝수
            size = size / 2;
            answer = answer + s.charAt(size - 1);
            answer = answer + s.charAt(size);
        }
        
        return answer;
    }
}
