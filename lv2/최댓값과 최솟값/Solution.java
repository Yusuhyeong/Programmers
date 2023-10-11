/*
문제 설명
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

입출력 예
s					return
"1 2 3 4"			"1 4"
"-1 -2 -3 -4"		"-4 -1"
"-1 -1"				"-1 -1"
*/

package lv2;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		String testcase = "1 2 3 4";
		Solution solution = new Solution();
		System.out.println(solution.solution(testcase));

	}
	
	public String solution(String s) {
        String answer = "";
        ArrayList<Integer> intList = new ArrayList<>();
        String sChar = "";
        
        for(int i = 0; i < s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equals(" ")) {
                intList.add(Integer.parseInt(sChar));
                sChar = "";
            }
            else {
                sChar = sChar + String.valueOf(s.charAt(i));   
            }
            
            if(i == s.length()-1) {
                intList.add(Integer.parseInt(sChar));
            }
        }
        
        Collections.sort(intList);
        
        answer = answer + intList.get(0) + " ";
        answer = answer + intList.get(intList.size()-1);
        
        // System.out.println(intList);
        
        
        return answer;
    }

}
