public class NQueen2 {
    static int n;
    static int[] x;
    static long sum;

    public static long nQueen2(int nn) {
        n = nn;
        sum = 0;
        x = new int[n + 1];
        for (int i = 0; i <= n; i ++)
            x[i] = 0;
        backtrack2();
        return sum;
    }

    private static void backtrack2() {
        x[1] = 0;
        int k = 1;
        while (k > 0) {
            x[k] += 1;
            while (x[k] <= n && !place2(k))
                x[k] += 1;
            if (x[k] <= n) {
                if (k == n)
                    sum++;
                else {
                    k ++;
                    x[k] = 0;
                }
            }
            else
                k --;
        }
    }

    private static boolean place2(int k) {
        for (int j = 1; j < k; j ++)
            if (Math.abs(k - j) == Math.abs(x[j] - x[k]) ||
                    x[j] == x[k])
                return false;
        return true;
    }

    public static void main(String[] args) {
        nQueen2(15);
        System.out.println("当前可行方案: " + sum);
        System.out.println("皇后个数: " + n);
        System.out.println("当前解: ");
        for (int i = 0; i < x.length; i ++)
            System.out.print(x[i] + " ");
    }
}
