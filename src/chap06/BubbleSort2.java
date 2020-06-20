package chap06;

import java.util.Scanner;

public class BubbleSort2 {
    //입력된 값을 서로 비교하여 오름차순으로 정렬


    //a[idx1]와 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; //임시 변수를 만들어서 더 큰 수를 넣어놓음
        a[idx1] = a[idx2]; //원래의 큰 수 자리에 작은수를 넣고
        a[idx2] = t; //작은 수 자리였던 값에 큰 수를 넣음
    }

    static void bubbleSort(int[] a, int n) { //n 요솟수
        for (int i = 0; i < n; i++) {
            int exchg = 0; //패스 교환횟수 기록
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) { //앞의 수가 뒤의 수 보다 큰가요?
                    swap(a, j - 1, j);
                    exchg++;
                }
            }
            if (exchg == 0) break; //교환이 이루어지지 않으면 종료
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬(버전 2)");
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
