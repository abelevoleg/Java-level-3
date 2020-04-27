package hw8;

import java.util.Scanner;

public class Matrix {
    private static int dimension(){
        // пункт 1
        int x;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Введите размерность матрицы от 5 до 7:");
            x = in.nextInt();
            if (x >= 5 & x <= 7){
                break;
            } else {
                System.out.println("Размерность не соответствует. Попробуйте еще раз");
            }
        }
        in.close();
        return (x);
    }

    private static int[][] matrixCreation(int x){
        // пункт 2
        int[][] matrix = new int[x][x];
        return matrix;
    }

    private static int[][] matrixFull(int[][] matrix){
        // пункт 3
        int k = 1;
        int i;

        for (int n = 0; n < matrix.length - 2; n++) {
            i = n;
            while (i < matrix.length - n) {
                matrix[n][i] = k++;
                i++;
            }
            i = n + 1;
            while (i < matrix.length - n) {
                matrix[i][matrix.length - 1 - n] = k++;
                i++;
            }
            i = n + 1;
            while (i < matrix.length - n) {
                matrix[matrix.length - 1 - n][matrix.length - 1 - i] = k++;
                i++;
            }
            i = n + 1;
            while (i < matrix.length - 1 - n) {
                matrix[matrix.length - i - 1][n] = k++;
                i++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int x = dimension();
        int[][] matrix = matrixFull(matrixCreation(x));

        for (int i = 0; i < x; i++){
            for (int j = 0; j < x; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
