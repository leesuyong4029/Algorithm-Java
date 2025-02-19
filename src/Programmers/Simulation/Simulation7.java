package Programmers.Simulation;

public class Simulation7 {
    public int solution(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }
}
