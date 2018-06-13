public class NQueen {
    static int n; // 皇后个数
    static int[] x; // 当前解
    static long sum; // 当前已找到可行方案数

    public static long nQueen(int nn) {
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i ++)
            x[i] = 0;
        backtrack(1);
        return sum;
    }

    private static void backtrack(int t) {
        if (t > n)
            sum ++;
        else
            for (int i = 1; i <= n; i ++) {
                x[t] = i;
                if (place(t))
                    backtrack(t + 1);
            }
    }

    private static boolean place(int k) {
        for (int j = 1; j < k; j ++)
            if ((Math.abs(k - j) == Math.abs(x[j] - x[k])) ||
                    x[j] == x[k])
                return false;
        return true;
    }

    public static void main(String[] args) {
        nQueen(10);
        System.out.println("当前可行方案: " + sum);
        System.out.println("皇后个数: " + n);
        System.out.println("当前解: ");
        for (int i = 0; i < x.length; i ++)
            System.out.print(x[i] + " ");

    }
}
