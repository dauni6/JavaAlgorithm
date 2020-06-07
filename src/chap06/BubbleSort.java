package chap06;

import java.util.Scanner;

public class BubbleSort {

    //a[idx1]와 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; //임시 변수를 만들어서 더 큰 수를 넣어놓음
        a[idx1] = a[idx2]; //원래의 큰 수 자리에 작은수를 넣고
        a[idx2] = t; //작은 수 자리였던 값에 큰 수를 넣음
    }

    //버블정렬
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) //앞의 수가 더 크다면
                    swap(a, j - 1, j);//위치변경
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        bubbleSort(x, nx); //배열 x를 버블 정렬함

        System.out.println("오름차순으로 정렬함");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }

}
