/*
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예

participant	c										ompletion									return
["leo", "kiki", "eden"]								["eden", "kiki"]								"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]				["stanko", "ana", "mislav"]					"mislav"
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String[] testcaseA = {"leo", "kiki", "eden"};
		String[] testcaseB = {"eden", "kiki"};
		Solution solution = new Solution();
		System.out.println(solution.solution(testcaseA, testcaseB));
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < completion.length; i++) {
            if(map.containsKey(completion[i])) {
                map.put(completion[i], map.get(completion[i])+1);
            }
            else{
                map.put(completion[i], 1);   
            }
        }
        
        for(int i = 0; i < participant.length; i++) {
            if(!map.containsKey(participant[i])) {
                answer = participant[i];
                break;
            }
            else if(map.get(participant[i]) == 0) {
                answer = participant[i];
                break;
            }
            else {
                map.put(participant[i], map.get(participant[i]) - 1);
            }
        }
        
        return answer;
    }
}
