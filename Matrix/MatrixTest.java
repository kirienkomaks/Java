import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void random() {
        Matrix l = Matrix.random(2, 4);
        l.show();

    }

    @Test
    public void eye() {
    }

    @Test
    public void setData() {
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
        Matrix z = new Matrix(3,3);
        z.show();
        z.setData(d);
        z.show();
    }

    @Test
    public void getData() {
    }

    @Test
    public void shape() {
        Matrix r = Matrix.random(4, 4);
        int[] tab= new int[2];
        tab=r.shape();
        System.out.println(Arrays.toString(tab));
    }

    @Test
    public void set() {
    }

    @Test
    public void get() {
    }

    @Test
    public void show() {
    }

    @Test
    public void add() {
        Matrix r = Matrix.random(4, 4);
        r.show();
        System.out.println();
        Matrix s = Matrix.random(4, 4);
        s.show();
        System.out.println();
        // r+s dodanie macierzy
        r.add(s).show();
    }

    @Test
    public void sub() {
    }

    @Test
    public void addlicz() {
    }

    @Test
    public void sublicz() {
        Matrix r = Matrix.random(4, 4);
        double liczba=10;
        r.addlicz(liczba).show();
    }

    @Test
    public void mullicz() {
    }

    @Test
    public void divlicz() {
    }

    @Test
    public void main() {
        Matrix z = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {9, 1, 3}});
        z.show();
    }
}