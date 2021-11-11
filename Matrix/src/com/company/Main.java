package com.company;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        multiplyMatrices();
    }

    public static void binaryToHexadecimal() {

        System.out.println("Enter the binary value :");
        String binary = scanner.nextLine();
        while (binary.length() % 4 != 0) {
            binary = "0" + binary;
        }
        int a = 0, b = 4;
        while (b <= binary.length()) {
            String digit = binary.substring(a,b);
            switch (digit) {
                case "0001":
                    System.out.print("1");
                    break;
                case "0010":
                    System.out.print("2");
                    break;
                case "0011":
                    System.out.print("3");
                    break;
                case "0100":
                    System.out.print("4");
                    break;
                case "0101":
                    System.out.print("5");
                    break;
                case "0110":
                    System.out.print("6");
                    break;
                case "0111":
                    System.out.print("7");
                    break;
                case "1000":
                    System.out.print("8");
                    break;
                case "1001":
                    System.out.print("9");
                    break;
                case "1010":
                    System.out.print("A");
                    break;
                case "1011":
                    System.out.print("B");
                    break;
                case "1100":
                    System.out.print("C");
                    break;
                case "1101":
                    System.out.print("D");
                    break;
                case "1110":
                    System.out.print("E");
                    break;
                case "1111":
                    System.out.print("F");
                    break;
                default:
                    System.out.print("0");
            }
            a+=4; b+=4;
        }
    }

    public static void multiplySquareMatrix() {

        System.out.println("Enter the number of rows: ");
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int col = scanner.nextInt();

        int matrix1[][] = new int[row][col];
        int matrix2[][] = new int[row][col];
        int resultMatrix[][] = new int[row][col];

        System.out.println("First Matrix...");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element:");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("First matrix is:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("[ ");
                System.out.print(matrix1[i][j] + " ");
                System.out.print("]");
            }
        }

        System.out.println("Second Matrix...");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element:");
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Second matrix is:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("[ ");
                System.out.print(matrix2[i][j] + " ");
                System.out.print("]");
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for ( int k = 0; k < col; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                System.out.println(resultMatrix[i][j]);
            }
        }
    }

    public static void productOfSquareMatrices() {

        System.out.println("Enter the number of rows: ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of columns: ");
        int col = scanner.nextInt();
        scanner.nextLine();

        //GETTING FIRST MATRIX
        LinkedList<Row> matrix1 = new LinkedList<>();
        System.out.println("First matrix...");
        for (int i = 0; i < row; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix1.add(rowList);
        }

        System.out.println("First matrix is: ");
        for (int i = 0; i < row; i++) {
            System.out.println(matrix1.get(i).getRowList());
        }

        //GET SECOND MATRIX
        LinkedList<Row> matrix2 = new LinkedList<>();

        System.out.println("Second matrix...");
        for (int i = 0; i < row; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix2.add(rowList);
        }

        System.out.println("Second matrix is: ");
        for (int i = 0; i < row; i++) {
            System.out.println(matrix2.get(i).getRowList());
        }

        //MULTIPLYING TWO MATRICES
        LinkedList<Row> pdtMatrix = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            Row pdtList  = new Row();
            for (int j = 0; j < col; j++) {
                int pdt = 0;
                for (int k = 0; k < row; k++) {
                    pdt += matrix1.get(i).getRowList().get(k) * matrix2.get(k).getRowList().get(j);
                }
                pdtList.addElement(pdt);
            }
            pdtMatrix.add(pdtList);
        }

        ListIterator<Row> listIterator = pdtMatrix.listIterator();
        System.out.println("Product of two matrices:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().getRowList());
        }
    }

    public static void sumOfMatrices() {

        System.out.println("Enter the number of rows: ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of columns: ");
        int col = scanner.nextInt();
        scanner.nextLine();

        //GETTING FIRST MATRIX
        LinkedList<Row> matrix1 = new LinkedList<>();
        System.out.println("First matrix...");
        for (int i = 0; i < row; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix1.add(rowList);
        }

        System.out.println("First matrix is: ");
        for (int i = 0; i < row; i++) {
            System.out.println(matrix1.get(i).getRowList());
        }

        //GET SECOND MATRIX
        LinkedList<Row> matrix2 = new LinkedList<>();

        System.out.println("Second matrix...");
        for (int i = 0; i < row; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix2.add(rowList);
        }

        System.out.println("Second matrix is: ");
        for (int i = 0; i < row; i++) {
            System.out.println(matrix2.get(i).getRowList());
        }

        //ADDING TWO MATRICES
        LinkedList<Row> sumMatrix = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            Row addList = new Row();
            for (int j = 0; j < col; j++) {
                int sum = matrix1.get(i).getRowList().get(j) + matrix2.get(i).getRowList().get(j);
                addList.addElement(sum);
            }
            sumMatrix.add(addList);
        }

        System.out.println("Sum of two matrices:");
        for (int i = 0; i < row; i++) {
            System.out.println(sumMatrix.get(i).getRowList());
        }

    }

    public static void productOfMatrices() {


        //GETTING FIRST MATRIX
        LinkedList<Row> matrix1 = new LinkedList<>();
        System.out.println("\nFirst matrix...\n");
        System.out.println("Enter the number of rows: ");
        int row1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of columns: ");
        int col1 = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < row1; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col1; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix1.add(rowList);
        }

        System.out.println("First matrix is: ");
        for (int i = 0; i < row1; i++) {
            System.out.println(matrix1.get(i).getRowList());
        }

        //GET SECOND MATRIX
        LinkedList<Row> matrix2 = new LinkedList<>();

        System.out.println("\nSecond matrix...\n");
        System.out.println("Enter the number of rows: ");
        int row2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of columns: ");
        int col2 = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < row2; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col2; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix2.add(rowList);
        }

        System.out.println("Second matrix is: ");
        for (int i = 0; i < row2; i++) {
            System.out.println(matrix2.get(i).getRowList());
        }

        //MULTIPLYING TWO MATRICES
        LinkedList<Row> pdtMatrix = new LinkedList<>();
        for (int i = 0; i < row1; i++) {
            Row pdtList  = new Row();
            for (int j = 0; j < col2; j++) {
                int pdt = 0;
                for (int k = 0; k < row2; k++) {
                    pdt += matrix1.get(i).getRowList().get(k) * matrix2.get(k).getRowList().get(j);
                }
                pdtList.addElement(pdt);
            }
            pdtMatrix.add(pdtList);
        }

        ListIterator<Row> listIterator = pdtMatrix.listIterator();
        System.out.println("Product of two matrices:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().getRowList());
        }
    }

    public static void multiplyMatrices() {

        System.out.printf("Matrix Multiplication");
        System.out.println("\nFirst Matrix...\n");
        System.out.println("Enter the number of rows: ");
        int row1 = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int col1 = scanner.nextInt();
        int matrix1[][] = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element:");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("First matrix is:");
        for (int i = 0; i < row1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < col1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.print("]\n");
        }

        System.out.println("\nSecond Matrix...\n");
        System.out.println("Enter the number of rows: ");
        int row2 = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int col2 = scanner.nextInt();
        int matrix2[][] = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element:");
                matrix2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Second matrix is:");
        for (int i = 0; i < row2; i++) {
            System.out.print("[ ");
            for (int j = 0; j < col2; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.print("]\n");
        }

        int resultMatrix[][] = new int[row1][col2];
        System.out.println("\nResultant matrix is:");
        for (int i = 0; i < row1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < col2; j++) {
                for ( int k = 0; k < col1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

    public static void differenceOfMatrices() {

        System.out.println("Enter the number of rows: ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the number of columns: ");
        int col = scanner.nextInt();
        scanner.nextLine();

        //GETTING FIRST MATRIX
        LinkedList<Row> matrix1 = new LinkedList<>();
        System.out.println("First matrix...");
        for (int i = 0; i < row; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix1.add(rowList);
        }

        System.out.println("First matrix is: ");
        for (int i = 0; i < row; i++) {
            System.out.println(matrix1.get(i).getRowList());
        }

        //GET SECOND MATRIX
        LinkedList<Row> matrix2 = new LinkedList<>();

        System.out.println("Second matrix...");
        for (int i = 0; i < row; i++) {
            Row rowList= new Row();
            for (int j = 0; j < col; j++) {
                System.out.println("Enter the a" + (i+1) + (j+1) + " element: ");
                int num = scanner.nextInt();
                rowList.addElement(num);
            }
            matrix2.add(rowList);
        }

        System.out.println("Second matrix is: ");
        for (int i = 0; i < row; i++) {
            System.out.println(matrix2.get(i).getRowList());
        }

        //SUBTRACTING TWO MATRICES
        LinkedList<Row> sumMatrix = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            Row addList = new Row();
            for (int j = 0; j < col; j++) {
                int sum = matrix1.get(i).getRowList().get(j) - matrix2.get(i).getRowList().get(j);
                addList.addElement(sum);
            }
            sumMatrix.add(addList);
        }

        System.out.println("Sum of two matrices:");
        for (int i = 0; i < row; i++) {
            System.out.println(sumMatrix.get(i).getRowList());
        }
    }
}
