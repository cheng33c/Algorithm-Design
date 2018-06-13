public class Matrix {
    private int MN;						// 存放矩阵链中矩阵数目
    private int[] p;					// 存放各个矩阵维数
    private int [][][]A;			// 存放要进行连乘的多个矩阵
    private int [][]m;				// 用来存放 Ai - Aj的最后断开位置
    private int [][]s;				// 用来存放 Ai - Aj的最后断开位置

    public Matrix() {
        MN = 0;
        p = new int [MN];
    }

    // 构造函数 L为矩阵数目
    public Matrix(int L) {
        MN = L;
        p = new int [MN+1];
        A = new int [MN][][];
        m = new int [MN+1][MN+1];
        s = new int [MN+1][MN+1];

        // 随机生成连乘矩阵的维数[1-11]
        for (int i = 0; i <= MN; i++) {
            p[i] = (int)Math.round(Math.random()*10) + 1;
        }
        // 随机生成各个矩阵
        for (int i = 0; i < MN; i++) {
            A[i] = new int [p[i][p[i+1]]];
            CreateMatrix(A[i], p[i], p[i+1]);
        }
    }

    // 创建矩阵a, 维数m*n
    private void CreateMatrix(int [][]a, int m, int n) {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = (int)Math.round(Math.random()*99) - 50;
    }

    // 输出连乘的所有矩阵
    private void printAllM() {
        for (int i = 0; i < this.MN; i++) {
            System.out.println("A" + (i+1) + ": " + A[i].length + "*" + A[i][0].length);
            printM(A[i]);
        }
    }

    // 输出矩阵a的每个元素
    private void printM(int [][]a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("		");
            for (int j = 0; j < a[i].length; j++)
                System.out.print(String.format("%4d", a[i][j]));
            System.out.println();
        }
    }

    public static void main(String []args) {
        Matrix M = new Matrix(7);
        M.printAllM();
        M.matrixChain(M.p, M.m, M.s);
        System.out.print("矩阵链所需最少乘次数为: " + M.m[1][M.MN]);
        System.out.println();
        String[] s = new String[M.MN+1];
        for (int i = 1; i <= M.MN; i++)
            s[i] = "A" + i;
        M.tracebace(M.s, 1, M.MN, s);
        for (int i = 1; i <= M.MN; i++)
            System.out.print(s[i]);
    }

    // 计算 矩阵 a 和 b 乘积 结果保存在 c 中
    public static void matrixMultiply(int [][]a, int [][]b, int [][]c,
                                      int ra, int rb,
                                      int ca, int cb,) {
        if (ca != rb)
            throw new IllegalArugmentException("矩阵不可乘");
        for (int i = 0; i < ra; i++) {
            for (int j = 0; j < cb; j++) {
                int sum = a[i][0] * b[0][j];
                for (int k = 1; k < ca; k++)
                    sum += a[i][k] * b[k][j];
                c[i][j] = sum;
            }
        }
    }
}
