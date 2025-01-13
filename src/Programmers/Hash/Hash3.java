// https://school.programmers.co.kr/learn/courses/30/lessons/131127
package Programmers.Hash;

import java.util.HashMap;

public class Hash3 {
    public int solution(String[] want, int[] number, String[] discount) {
        // 1. want, number 배열의 값을 해시맵에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discountId = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discountId.put(discount[j], discountId.getOrDefault(discount[j], 0) + 1);
                }
            }
            if (discountId.equals(wantMap))
                answer++;
        }
        return answer;
    }
}
