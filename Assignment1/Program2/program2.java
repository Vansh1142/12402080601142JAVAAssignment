// Problem Statement:
// Matrix class with constructors, transpose and multiplication

import java.util.Scanner;

class Q2_Matrix {

    int[][] mat; // 2D array to store matrix elements
    int r, c;    // number of rows and columns

    // Constructor to create an empty matrix of given size
    Q2_Matrix(int rows, int cols) {
        r = rows;
        c = cols;
        mat = new int[r][c];
    }

    // Constructor to create a matrix directly from a 2D array
    Q2_Matrix(int[][] arr) {
        r = arr.length;
        c = arr[0].length;
        mat = arr;
    }

    // Method to take matrix input row by row
    void inputMatrix(Scanner sc) {
        System.out.println("Enter matrix elements row by row:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt(); // user types row values separated by spaces
            }
        }
    }

    // Method to display matrix
    void display() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Method to return transpose of matrix
    Q2_Matrix transpose() {
        int[][] t = new int[c][r]; // transpose has swapped dimensions
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                t[j][i] = mat[i][j];
            }
        }
        return new Q2_Matrix(t);
    }

    // Method to multiply two matrices
    Q2_Matrix multiply(Q2_Matrix m) {
        // Check if multiplication is possible
        if (this.c != m.r) {
            System.out.println("Cannot multiply - size not matching");
            return null;
        }
        int[][] res = new int[this.r][m.c]; // result matrix
        for (int i = 0; i < this.r; i++) {
            for (int j = 0; j < m.c; j++) {
                for (int k = 0; k < this.c; k++) {
                    res[i][j] += this.mat[i][k] * m.mat[k][j];
                }
            }
        }
        return new Q2_Matrix(res);
    }

    // Main method to test the Matrix class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Matrix 1
        System.out.print("Enter rows and cols for Matrix 1: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Q2_Matrix m1 = new Q2_Matrix(r1, c1);
        m1.inputMatrix(sc);

        // Input for Matrix 2
        System.out.print("Enter rows and cols for Matrix 2: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Q2_Matrix m2 = new Q2_Matrix(r2, c2);
        m2.inputMatrix(sc);

        // Display Matrix 1
        System.out.println("Matrix 1:");
        m1.display();

        // Display transpose of Matrix 1
        System.out.println("Transpose of Matrix 1:");
        m1.transpose().display();

        // Multiply Matrix 1 and Matrix 2
        System.out.println("Matrix 1 x Matrix 2:");
        Q2_Matrix mul = m1.multiply(m2);
        if (mul != null) {
            mul.display();
        }

        sc.close();
    }
}
