package chap03;

import java.util.Scanner;

//이진검색
class BinSearch {
    //요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색합니다.
    static int binSearch(int[] a, int n , int key) { //배열, 요솟수(사이즈), 찾고자 하는 값
        int pl = 0; //검색 범위의 첫 인덱스
        int pr = n - 1; //검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr ) / 2; //중앙 요소의 인덱스
            if (a[pc] == key)
                return pc; //검색성공
            else if (a[pc] < key)
                pl = pc + 1; //검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1; //검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1; //계속 돌다가 do 에서 return 되지 않으면 검색실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        System.out.println("x[0] : "); // 첫 요소 입력
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++) {
                do {
                    System.out.println("x[" + i + "] : ");
                    x[i] = sc.nextInt();
                } while (x[i] < x[i - 1]); //x[0]이 예를들어 4면 x[1]이 3일때 while문을 만족하므로 다시 do 부터 시작함
        }

        System.out.println("검색할 값 : "); // 키 값을 입력
        int ky = sc.nextInt();

        int idx = binSearch(x, num, ky); //배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다");
        else
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");

    } //main
}

