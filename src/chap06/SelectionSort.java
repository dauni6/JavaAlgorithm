package chap06;

import java.util.Scanner;

public class SelectionSort {

    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //단순 선택 정렬
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i; //아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                swap(a, i, min); //아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("요솟수 입력 ");
        int nx = sc.nextInt();
        int[] x = new int[nx]; //배열생성

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i +"] : ");
            x[i] = sc.nextInt();
        }

        selectionSort(x, nx); //단순 선택 정렬
        
        //출력
        for (int i = 0; i < nx; i ++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }

    }
}
