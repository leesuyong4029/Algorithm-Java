package Programmers.PCCE;

import java.util.Scanner;

public class PCCE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        int sum = angle1 + angle2;
        System.out.println(sum % 360);
    }
}
