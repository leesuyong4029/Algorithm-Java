package Programmers.Hash;

import java.util.HashSet;

public class Hash1 {
    public boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            // 1. target에서 현재 원소를 뺀 값이 해시셋 있는지 확인
            if (hashSet.contains(target - i)) {
                return true;
            }
            // 2. 해시셋 현재 값 저장
            hashSet.add(i);
        }
        return false;
    }
}
