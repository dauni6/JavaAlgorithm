package chap06;

import java.util.Scanner;

//역방향으로 정렬하기
public class BubbleSort_Q1 {

    //a[idx1]와 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) { //idx 작은수
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    //버블정렬
    static void bubbleSort(int[] a, int n) { //a : 배열, n : 요솟수
        for (int i = n - 1; i > 0; i--) { //횟수
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);//위치변경
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Q1 교환을 왼쪽부터 오른쪽으로하여 가장 큰 값의 요소가 끝으로 옮겨지도록 하기");

        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt(); //값 입력받기
        }

        bubbleSort(x, nx); //배열 x를 버블 정렬함

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}

