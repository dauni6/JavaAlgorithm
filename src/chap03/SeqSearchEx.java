package chap03;

import java.util.Scanner;

class SeqSearchEx {

    static int seqSearchIdx(int[] a, int n, int key) {

        System.out.print("   |");
        for (int k = 0; k < n; k++)
            System.out.printf("%4d", k); //%d는 정수, 4는 4자리 채우기, 만약 4자리수가 아니라면 왼쪽부터 공백을 채움

        System.out.println();

        System.out.print("---+");
        for (int k = 0; k < 4 * n + 2; k++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
            System.out.printf("%3d|", i);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[i] == key)
                return i; // 검색성공
        }
        return -1; // 검색실패
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num]; //요솟수 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "] : ");
                x[i] = sc.nextInt();
        }

        System.out.println("찾는 값 : ");
        int key = sc.nextInt(); //키보드로 부터 값을 입력

        int idx = seqSearchIdx(x, num, key);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(key + "은 " + "x[" + idx + "]에 있습니다.");
    }
}
