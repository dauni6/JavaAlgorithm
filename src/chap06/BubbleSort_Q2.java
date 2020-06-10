package chap06;

import java.util.Scanner;

//역방향으로 정렬하기
public class BubbleSort_Q2 {

    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    private static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 단순교환정렬
    private static void bubbleSort(int[] a, int n) { //n은 요솟수
        int ccnt = 0; // 비교횟수
        int scnt = 0; // 교환횟수

        for (int i = 0; i < n - 1; i++) {
            int exchg = 0; // pass에 의한 교환횟수
            System.out.printf("패스%d：\n", i + 1);

            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n - 1; m++)
                    System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
                System.out.printf("%3d\n", a[n - 1]);

                ccnt++;
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                    scnt++;
                }
            }
            for (int m = 0; m < n; m++)
                System.out.printf("%3d  ", a[m]);
            System.out.println();
            if (exchg == 0)
                break; /* 교환을 수행하지 않으면 종료 */
        }

        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환을 " + scnt + "회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Q1 둘 사이 교환되면 + 그렇지 않으면 - 비교횟수와 교환횟수 나타내기");

        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt(); //값 입력받기
        }

        bubbleSort(x, nx); //배열 x를 버블 정렬함
    }
}

