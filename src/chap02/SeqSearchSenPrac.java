package chap02;

import java.util.Scanner;

public class SeqSearchSenPrac {
    //요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색
    private static int seqSearchSen(int[] a, int n, int key) { // a배열, n 요솟수 , key 찾고자 하는 값
        int i;

        a[n] = key; //여기서 a배열에 남은 마지막 인덱스에 보초를 추가 (요솟수 + 1로 만들었기 때문에 main 함수에서는 요솟수를 5개만 넣었다. 여기서 보초를 하나 추가해주는 것!)

        //방법1
        for (i = 0; i < a.length; i++){ // 요솟수가 4면 배열 a의 크기는 4 + 1
            if (a[i] == key) break;
        }

        return i == n ? -1 : i; //true 면 -1 false 면  i 를 리턴  (boolean) ? true : false <- 삼항연산자 형태


     /* 방법2
      while (true) {
            if (a[i] == key) break; //검색성공
            i++;
        }
        return i == n ? -1 : i;*/

     /* 방법3
        for (i = 0; a[i] != key; i++); //같지 않으면 계속 같으면 종료
        return i == n ? -1 : i;*/
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; //요솟수 num + 1 보초를 위해서
        //System.out.println("x의 사이즈" + x.length);
        for (int i = 0; i < num; i++) { // 위에서 num + 1 로 배열을 만들었지만 for문의 조건식에서 i < num 이라서 사실상 입력한 요솟수 만큼 for문이 돌아간다.
            System.out.println("x[" +  i + "] : ");
            x[i] = stdIn.nextByte(); //값대입
        }

        System.out.println("검색할 값 : "); //키값 입력
        int ky = stdIn.nextInt();
        int idx = seqSearchSen(x, num, ky); //배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(ky +"은(는) x[" + idx + "]에 있습니다.");
        }

    }
}
