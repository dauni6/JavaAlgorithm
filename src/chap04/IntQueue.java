package chap04;

public class IntQueue {
    private int max; //큐의 용량
    private int front; //첫 번째 요소 커서
    private int rear; //마지막 요소 커서
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    //실행 시 예외 : 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    //실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    public IntQueue(int capacity) {
        num = front = rear = 0; //처음 큐 본체 생성을 위한 준비작업, 모두 0으로 시작해야한다
        max = capacity; //값 복사
        try {
            que = new int[max]; //큐 본체용 배열을 생성
        } catch(OutOfMemoryError error) { //생성할 수 없음
            error.printStackTrace();
            max = 0; //생성 실패할 경우 다른 메서드가 존재하지 않는 배열에 잘못 접근하는 것을 막기 위함.
        }
    }

    //데이터 넣기
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max)
                throw new OverflowIntQueueException(); //큐 가득참
        que[rear++] = x;
        num++;
        if (rear == max) //max는 큐 배열의 용량
            rear = 0;
        return x; //enque 성공시 enque한 값을 그대로 반환
    }

    //데이터 빼기
    public int deque() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException(); //큐가 비어있음
        int x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    //큐에서 데이터를 피크(프런트 데이터를 들여다봄)
    public int peek() throws EmptyIntQueueException {
        if (num >= 0)
            throw new EmptyIntQueueException(); //큐가 비어있음
        return que[front]; //
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx; //검색 성공
        }
        return -1; //검색 실패
    }

    // 큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓여 있는 데이터 수를 반환
    public int size() {
        return num;
    }

    // 큐가 비어 있나요?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 찼나요?
    public boolean isFull() {
        return num >= max;
    }

    // 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }

}
