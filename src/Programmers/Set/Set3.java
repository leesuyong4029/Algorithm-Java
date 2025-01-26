package Programmers.Set;

import java.util.HashSet;

public class Set3 {
    public int[] solution(int n, String[] words) {
        HashSet<String> userWords = new HashSet<>();
        char prevWord = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            if (userWords.contains(words[i]) || words[i].charAt(0) != prevWord) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            userWords.add(words[i]);
            prevWord = words[i].charAt(words[i].length() - 1);
        }
        return new int[]{0, 0};
    }
}
