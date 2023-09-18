/*
문제 설명
네오와 프로도가 숫자놀이를 하고 있습니다. 
네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. 
s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine

제한사항
1 ≤ s의 길이 ≤ 50
s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

입출력 예
s					result
"one4seveneight"	1478
"23four5six7"		234567
"2three45sixseven"	234567
"123"				123
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String testcase = "one4seveneight";
		Solution solution = new Solution();
		System.out.println(Solution.solution(testcase));
	}
	
	public static int solution(String s) {
        HashMap<String, String> alphabet = new HashMap<String, String>();
        int answer = 0;
        String stringAnswer = "";
        
        
        alphabet.put("0", "zero");
        alphabet.put("1", "one");
        alphabet.put("2", "two");
        alphabet.put("3", "three");
        alphabet.put("4", "four");
        alphabet.put("5", "five");
        alphabet.put("6", "six");
        alphabet.put("7", "seven");
        alphabet.put("8", "eight");
        alphabet.put("9", "nine");
        
        
        int i = 0;
        int first = 0;
        int last = 0;
        String change = "";
        
        while(i < s.length()) {
            if(!alphabet.containsKey(String.valueOf(s.charAt(i)))) {
                first = i;
                last = first + 1;
                i++;
                while(!alphabet.containsValue(s.substring(first, last))){
                    change = s.substring(first, last+1);
                    last++;
                    i++;
                }
                // System.out.println(change);
                change = getKey(alphabet, change);
                stringAnswer = stringAnswer + change;
            }
            else {
                stringAnswer = stringAnswer + String.valueOf(s.charAt(i));
                i++;
            }
            
        }

        // System.out.println(stringAnswer);
        answer = Integer.parseInt(stringAnswer);
        
        return answer;
    }
    
    public static <K, V> K getKey(Map<K, V> map, V value) {
 
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
