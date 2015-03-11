import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(expected(a, k, 0));
        }
    }

    static int expected(int[] a, int k, int s) {
        if (k == 0) return 0;
        int m = a[s];
        if (k % m == 0) return k;
        int closest = 0;
        int fit = k / m;

        if (s == a.length - 1) {
            return fit * m;
        }

        for (int i = 0; i <= fit; i++) {
            int me = i * m;
            int x = expected(a, k - me, s + 1) + me;
            if (x > closest && x <= k) {
                closest = x;
            }
        }

        return closest;
    }
}
