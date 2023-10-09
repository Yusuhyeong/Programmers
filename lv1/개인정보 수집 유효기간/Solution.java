/*
문제 설명
고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다. 
당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.

예를 들어, A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.

모든 달은 28일까지 있다고 가정합니다.

다음은 오늘 날짜가 2022.05.19일 때의 예시입니다.

약관 종류	유효기간
A	6 달
B	12 달
C	3 달
번호	개인정보 수집 일자	약관 종류
1	2021.05.02	A
2	2021.07.01	B
3	2022.02.19	C
4	2022.02.20	C
첫 번째 개인정보는 A약관에 의해 2021년 11월 1일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
두 번째 개인정보는 B약관에 의해 2022년 6월 28일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
세 번째 개인정보는 C약관에 의해 2022년 5월 18일까지 보관 가능하며, 유효기간이 지났으므로 파기해야 할 개인정보입니다.
네 번째 개인정보는 C약관에 의해 2022년 5월 19일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
따라서 파기해야 할 개인정보 번호는 [1, 3]입니다.

오늘 날짜를 의미하는 문자열 today, 약관의 유효기간을 담은 1차원 문자열 배열 terms와 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가 매개변수로 주어집니다. 이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

제한사항
today는 "YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.
1 ≤ terms의 길이 ≤ 20
terms의 원소는 "약관 종류 유효기간" 형태의 약관 종류와 유효기간을 공백 하나로 구분한 문자열입니다.
약관 종류는 A~Z중 알파벳 대문자 하나이며, terms 배열에서 약관 종류는 중복되지 않습니다.
유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하입니다.
1 ≤ privacies의 길이 ≤ 100
privacies[i]는 i+1번 개인정보의 수집 일자와 약관 종류를 나타냅니다.
privacies의 원소는 "날짜 약관 종류" 형태의 날짜와 약관 종류를 공백 하나로 구분한 문자열입니다.
날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어집니다.
privacies의 약관 종류는 항상 terms에 나타난 약관 종류만 주어집니다.
today와 privacies에 등장하는 날짜의 YYYY는 연도, MM은 월, DD는 일을 나타내며 점(.) 하나로 구분되어 있습니다.
2000 ≤ YYYY ≤ 2022
1 ≤ MM ≤ 12
MM이 한 자릿수인 경우 앞에 0이 붙습니다.
1 ≤ DD ≤ 28
DD가 한 자릿수인 경우 앞에 0이 붙습니다.
파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어집니다.

입출력 예
today			terms					privacies																			result
"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]					[1, 3]
"2020.01.01"	["Z 3", "D 5"]			["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]																		[1, 0, 2, 1]
*/


package lv1;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		String testcaseA = "2022.05.19";
		String[] testcaseB = {"A 6", "B 12", "C 3"};
		String[] testcaseC = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.solution(testcaseA, testcaseB, testcaseC)));
	}
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> deleteUserList = new ArrayList<>(); // 파기해야 되는 사용자 정보 넣을 부분(index + 1의 형태로 저장)
        HashMap <String, Integer> term = new HashMap<String, Integer>(); // 계약 내용
        // 오늘 날짜 변수
        int todayYear = 0;
        int todayMonth = 0;
        int todayDay = 0;
        // 비교 날짜 변수
        int compareYear = 0;
        int compareMonth = 0;
        int compareDay = 0;
        String userTerm = "";
        
        // 오늘 날짜 저장
        todayYear = Integer.parseInt(today.substring(0,4));
        todayMonth = Integer.parseInt(today.substring(5,7));
        todayDay = Integer.parseInt(today.substring(8, 10));
        
        // 계약 내용 저장
        for(int i = 0; i < terms.length; i++){
            term.put(String.valueOf(terms[i].charAt(0)), Integer.parseInt(terms[i].substring(2)));
        }
        
        // 날짜 계산을 먼저 해야하는 부분
        for(int i = 0; i < privacies.length; i++){
            compareYear = Integer.parseInt(privacies[i].substring(0, 4));
            compareMonth = Integer.parseInt(privacies[i].substring(5, 7));
            compareDay = Integer.parseInt(privacies[i].substring(8, 10));
            userTerm = String.valueOf(privacies[i].charAt(11));
            
            int test = term.get(userTerm); // Map형태에서 가져온 계약 파기 기간을 가져올 변수
            // System.out.println(test + "test");
            compareMonth = compareMonth + test;
            if(compareMonth > 12){
                while(compareMonth > 12){
                    compareYear = compareYear + 1;
                    compareMonth = compareMonth - 12;
                }
            }
            
            // System.out.println("현재 날짜 : " + todayYear + " " + todayMonth + " " + todayDay);
            // System.out.println("파기 날짜 : " + compareYear + " " + compareMonth + " " + compareDay);
            
            if(compareYear < todayYear){
                // System.out.println((i+1) + "의 연 초과");
                deleteUserList.add(i+1);
            }
            else if(compareYear == todayYear){
                if(compareMonth < todayMonth){
                    deleteUserList.add(i+1);
                }
                else if(compareMonth == todayMonth){
                    if(compareDay <= todayDay){
                        deleteUserList.add(i+1);
                    }
                }
            }
        }
        
        
        int[] answer = new int[deleteUserList.size()];
        
        for(int i = 0; i < deleteUserList.size(); i++){
            answer[i] = deleteUserList.get(i);
        }
        
        return answer;
    }
}
