package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RunnerTemplate {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 1; i <= cases; ++i) {
            int value = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(value));
        }
    }

    private static int solve(int value) {
        return value;
    }
}