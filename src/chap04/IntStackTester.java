package chap04;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack obj = new IntStack(8); //최대 64개를 푸시할 수 있는 스택

        while (true) {
          System.out.println("현재 데이터 수 : " + obj.size() + " / " + obj.capacity());
          System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료");

          int menu = sc.nextInt();
          if (menu == 0 ) break;

          int x;
          switch (menu) {
              case 1: //푸시
                  System.out.print("데이터 : ");
                  x = sc.nextInt();
                  try {
                      obj.push(x);
                      System.out.println(obj.size());
                  } catch (IntStack.OverFlowIntStackException e) {
                      e.printStackTrace();
                      System.out.println("스택이 가득 찼습니다.");
                  }
                  break; //switch 문을 break 함

              case 2: //팝
                  try {
                    x = obj.pop();
                    System.out.println(obj.size());
                  } catch (IntStack.EmptyIntStackException e) {
                      e.printStackTrace();
                      System.out.println("스택이 비어 있습니다.");
                  }
                  break;

              case 3: //피크
                  try {
                    x = obj.peek();
                    System.out.println("피크한 데이터는 " + x + " 입니다.");
                  } catch (IntStack.EmptyIntStackException e) {
                      e.printStackTrace();
                      System.out.println("스택이 비어 있습니다.");
                  }
                  break;

              case 4: //덤프
              obj.dump();
              break;

          }
        }
    }

}
