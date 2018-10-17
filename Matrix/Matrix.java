
import java.util.Random;
import java.lang.Object;
import java.util.Arrays;

public class Matrix {

    int M;
    int N;
    double[][] data;

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }
    public Matrix(int M, int N, double value) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
        data[M][N]=value;
    }

     public Matrix(double[][] d) {
        M = d.length;
        N = d[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                this.data[i][j] = d[i][j];
        }

    }
    private Matrix(Matrix A) { this(A.data); }

    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        Random rand = new Random();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                A.data[i][j]= rand.nextInt(50);
                //A.data[i][j]= 1;
        }
        return A;
    }

    static Matrix eye(int n) {
        Matrix m = new Matrix(n, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j) {
                    m.data[i][j] = 1;
                } else {
                    m.data[i][j] = 0;
                }
        return m;
    }

    public void setM(int m) {
        M = m; }
    public void setN(int n) {
        N = n; }
    public void setData(double[][] data) {
        this.data = data; }

    public double[][] getData() {
        return data;
    }
    public int[] shape(){
        int[] tab = new int[2];
        tab[0]=M;
        tab[1]=N;
        return tab;
    }

    public void set(int M, int N, double value) {
        //Matrix A = new Matrix(M,N);
        data[M-1][N-1]=value;
    }

    public void get(int M, int N) {
        //Matrix A = new Matrix(M,N);
        System.out.printf("%f", data[M-1][N-1]);
        System.out.println();
    }

    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf(" | %f | ", data[i][j]);
            System.out.println();


        }
        System.out.println();
        System.out.println();
    }

    public Matrix add(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }

    public Matrix addmn(Matrix B) {
        Matrix A = this;
        //if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < A.M; i++)
            for (int j = 0; j < B.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }

    public Matrix sub(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }
    public Matrix mul(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }

    public Matrix addlicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + w;
        return C;
    }

    public Matrix sublicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - w;
        return C;
    }

    public Matrix mullicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * w);
        return C;
    }
    public Matrix divlicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] / w);
        return C;
    }

    public double frobenius(){
        int a = 0;
        for (int i=0;i<M;i++)
            for (int j=0; j<N; j++)
                a += data[i][j]*data[i][j];
        return a;
    }

    public static void main(String[] args) {
        Matrix r = Matrix.random(4, 4);
        r.show();
        System.out.println();
        Matrix s = Matrix.random(4, 4);
        s.show();
        System.out.println();
        // r+s dodanie macierzy
        r.add(s).show();
        // *licz
        double liczba=10;
        r.addlicz(liczba).show();
        //rozne M i N
        Matrix l = Matrix.random(2, 4);
        System.out.printf("LLLLL\n");
        l.show();
        Matrix p = Matrix.random(4, 1);
        System.out.printf("PPPPP\n");
        p.show();
        l.addmn(p).show();

        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        //System.out.println(Arrays.deepToString(d));
        double[][] w = new double[3][3];
        //tab M*N
        int[] tab= new int[2];
        tab=r.shape();
        System.out.println(Arrays.toString(tab));

        Matrix D = new Matrix(d);
        System.out.printf("Frobenius\n");
        double kwad = 0;
        kwad = D.frobenius();
        System.out.printf("%f", kwad);

        D.set(3,3,10);
        D.get(3,3);
        D.show();
        //w = D.getData();

        System.out.println();
    }
}
