package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dimension of the matrix ");
        int n;
        while (true) {
            n = in.nextInt();
            if (n > 0) break;
            System.err.println("Invalid input.Repeat");
        }
        int[][] mas = new int[n][n];
        Random r = new Random();
        r.setSeed( System.currentTimeMillis() );

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                mas[i][j] = r.nextInt(n + 1);
                System.out.printf("%3s",mas[i][j] + " ");
            }
            System.out.print("\n");
        }


        int sum;
        Boolean check=true;
        int c;
        for(int i=0;i<n;i++)
        {
            c=0;
            sum=0;
           // metka:
            while(check) {
                for (int j = 0; j < n; j++) {

                    if (mas[i][j] > 0) {
                        c = 1;
                        for (int k = j + 1; k < n; k++) {
                            if (mas[i][k] > 0) {
                                if (k == j + 1) c = 2;  //стоят рядом
                                else c = 3;
                                //break metka;
                                check=false;
                            }
                            sum += mas[i][k];
                        }
                    }
                }
            }
            System.out.print("Row №" + i +":");

            switch(c)
            {
                case 0:System.out.print("no positive numbers ");
                case 1:System.out.print("only one positive number ");
                case 2: System.out.print("the first two positive numbers stand side by side ");
                case 3 : System.out.print("the sum of the elements located between the first two positive numbers : "+sum );
                default: System.out.print("lolkek ");
            }


//            if(c==0) System.out.print("no positive numbers ");
//            if(c==1) System.out.print("only one positive number ");
//            if(c==2) System.out.print("the first two positive numbers stand side by side ");
//            if(c==3) System.out.print("the sum of the elements located between the first two positive numbers : "+sum );

            System.out.print("\n");
        }

    }
}
