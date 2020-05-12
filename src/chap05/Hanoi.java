package chap05;

import java.util.Scanner;

//하노이의 탑, 최소의 횟수로 원반을 옮기기
//제일 아래는 가장 큰 원반이 가야하며 순차적으로 보다 작은 원반이 올라가고 최후에는 가장 작은 원반이 꼭대기에 올라간다.
class Hanoi {
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮기기
    static void move(int no, int x, int y) { //매개변수 3개 no는 입력받은 값(원반의갯수)
        if (no > 1) move(no - 1, x , 6 - x - y);

        System.out.println("원반[" + no + "]울" + x + "기둥에서" + y + "기둥으로 옮김");

        if (no > 1) move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("하노이의 탑 시작");
        System.out.print("원반 개수 : ");
        int n = sc.nextInt(); //입력받기
        
        move(n, 1, 3); //1번 기둥의 n개의 원반을 3번 기둥으로 옮기
    }
}


