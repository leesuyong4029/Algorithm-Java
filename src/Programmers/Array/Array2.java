package Programmers.Array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Array2 {
    private static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
