// https://school.programmers.co.kr/learn/courses/30/lessons/42576
package Programmers.Hash;

import java.util.HashMap;

public class Hash2 {
    public String solution(String[] participant, String[] completion) {
        // 1. 해시맵 생성
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String string : completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }

        // 3. 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
        for (String string : participant) {
            // 4. 완주하지 못한 선수를 찾으면 반환
            if (hashMap.getOrDefault(string, 0) == 0) {
                return string;
            }
            hashMap.put(string, hashMap.get(string) - 1);
        }
        return null;
    }
}
