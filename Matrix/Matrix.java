

import java.util.Random;
import java.util.Arrays;

public class Matrix {

    int M;
    int N;
    double[] data;

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M*N];
    }
    public Matrix(int M, int N, double value) {
        this.M = M;
        this.N = N;
        data = new double[M*N];
        for (int i=0;i<M;i++)
            for (int j=0;j<N;j++)

        data[M*N]=value;
    }

    public Matrix(double[][] d) {
        M = d.length;
        N = d[0].length;
        this.data = new double[M*N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                this.data[M*i+j] = d[i][j];
        }

    }
    //private Matrix(Matrix A) { this(A.data); }

    public static Matrix random(int M, int N) {
        Matrix A = new Matrix(M, N);
        Random rand = new Random();
        for (int i = 0; i < M*N; i++) {
            A.data[i]= rand.nextDouble();
            //A.data[i][j]= 1;
        }
        return A;
    }

    static Matrix eye(int n) {
        Matrix m = new Matrix(n, n);
        for (int i = 0; i < n*n; i++)
            m.data[i] = 1;


        return m;
    }

    public void setData(double[][] data) {

        for (int i=0; i<M;i++)
            for (int j=0;j<N;j++)
                this.data[M*i+j] = data[i][j]; }

    public double[] getData() {
        return this.data;
    }
    public int[] shape(){
        int[] tab = new int[2];
        tab[0]=M;
        tab[1]=N;
        return tab;
    }

    public void set(int M, int N, double value) {
        //Matrix A = new Matrix(M,N);
        data[M*N]=value;
    }

    public void get(int M, int N) {
        //Matrix A = new Matrix(M,N);
        System.out.printf("%f", data[M*N]);
        System.out.println();
    }

    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf(" | %f | ", data[M*i+j]);
            System.out.println();


        }
        System.out.println();
        System.out.println();
    }

    public Matrix add(Matrix B) {
        //Matrix A = this;
        if (B.M != this.M || B.N != this.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M*N; i++)
            C.data[i]=this.data[i]+B.data[i];
        return C;
    }




    public Matrix sub(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M*N; i++)
            C.data[i]=this.data[i]-B.data[i];
        return C;
    }


    public Matrix addlicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M*N; i++)
            C.data[i]=this.data[i]+w;
        return C;
    }

    public Matrix sublicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            C.data[i]=this.data[i]-w;
        return C;
    }

    public Matrix mullicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < C.M; i++)
            C.data[i]=this.data[i]*w;
        return C;
    }
    public Matrix divlicz(double w) {
        Matrix A = this;
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < C.M; i++)
            C.data[i]=this.data[i]/w;
        return C;
    }



    public static void main(String[] args) {
        Matrix z = new Matrix(3,3);
        z.show();
        //Matrix m = new Matrix(new double[][]{{1,2,3,4},{5,6},{7,8},{9}});

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
        Matrix n = Matrix.random(3, 3);
        System.out.printf("333333\n");
        n.show();
        //Matrix p = Matrix.random(4, 1);
        //System.out.printf("PPPPP\n");
        //p.show();
        //l.addmn(p).show();

        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        //System.out.println(Arrays.deepToString(d));
        double[][] w = new double[3][3];
        //tab M*N
        int[] tab= new int[2];
        tab=r.shape();
        System.out.println(Arrays.toString(tab));

        Matrix D = new Matrix(d);
        //System.out.printf("Frobenius\n");
        double kwad = 0;
        //kwad = D.frobenius();
        //System.out.printf("%f", kwad);

        //D.set(3,3,10);
        //D.get(3,3);
        D.show();
        //w = D.getData();

        System.out.println();
    }
}

