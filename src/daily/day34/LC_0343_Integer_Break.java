package daily.day34;

public class LC_0343_Integer_Break {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;

        int timesOf3 = n / 3;
        int remainder = n % 3;

        if (remainder == 0) return (int) Math.pow(3, timesOf3);
        if (remainder == 1) return (int) Math.pow(3, timesOf3 - 1) * 4;
        return (int) Math.pow(3, timesOf3) * 2;
    }
}
