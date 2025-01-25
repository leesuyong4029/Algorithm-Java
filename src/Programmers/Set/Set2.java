package Programmers.Set;

import java.util.Arrays;

public class Set2 {
    public int solution(int[] nums) {
        return Math.min((int) Arrays.stream(nums).distinct().count(), nums.length / 2);
    }
}
