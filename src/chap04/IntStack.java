package chap04;

public class IntStack {

    private int max; //스택 용량
    private int ptr; //스택 포인터(위치)
    private int[] stk; //스택 본체

    //생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max]; //배열 생성
        } catch (OutOfMemoryError error) { //배열 생성할 수 없음
            error.printStackTrace();
            max = 0; //이렇게 max를 0으로 해줘야 다른 메서드가 존재하지 않는 배열에 잘못 접근하는 것을 막을 수 있다
        }
    }

    //실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    //실행 시 예외 : 스택이 가득 참
    public class OverFlowIntStackException extends RuntimeException {
        public OverFlowIntStackException() {}
    }

    //스택에 x값 푸쉬
    public int push(int x) throws OverFlowIntStackException {
        if (ptr >= max)  //스택 가득 참
            throw new OverFlowIntStackException();
        return stk[ptr++] = x;
    }

    //스택에서 데이터를 팝(제일 마지막에 넣은 데이터를 꺼냄)
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) //스택이 비어있음
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    //스택에서 제일 마지막에 넣은 데이터를 들여다봄
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    //스택에서 x를 찾아 인덱스(없으면 -1)을 반환
    public int indexOf(int x) {
        for (int i = ptr - 1; i >=0; i--) { //제일 마지막부터 선형 검색
            if (stk[i] == x)
                return i; //검색성공
        }
        return -1; //검색실패
    }

    //스택을 비움
    public void clear() {
        ptr = 0;
    }

    //스택의 용량을 반환
    public int capacity() {
        return max;
    }

    //스택에 쌓여 있는 데이터 수를 반환
    public int size() {
        return ptr;
    }

    //스택이 비어 있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    //스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= max;
    }

    //스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

}
