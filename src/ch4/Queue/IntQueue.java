package src.ch4.Queue;

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;    // 현재 데이터 수
    private int[] que;

    // 실행 시 예외 : 큐가 비어있음
    public class EmptyIntStackException extends RuntimeException
    {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntStackException extends  RuntimeException
    {
        public OverflowIntStackException() { }
    }

    public IntQueue(int capacity)
    {
        num = front = rear = 0;
        max = capacity;
        try
        {
            que = new int[max];
        } catch (OutOfMemoryError e)
        {
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntStackException
    {
        if (num >= max)
            throw new OverflowIntStackException();
        que[rear++] = x;
        if (!isFull())
            num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public int deque() throws EmptyIntStackException
    {
        if (num <= 0)
            throw new EmptyIntStackException();
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    // front 데이터 반환
    public int peek() throws EmptyIntStackException
    {
        if (num <= 0)
            throw new EmptyIntStackException();
        return que[front];
    }

    public int indexOf(int x)
    {
        int i;
        for(i=0; i<num; i++)
        {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // 큐를 비움
    public void clear()
    {
        num = front = rear = 0;
    }

    // 큐의 용량을 반환
    public int capacity()
    {
        return max;
    }

    // 큐에 쌓여 있는 데이터 수를 반환
    public int size()
    {
        return num;
    }

    // 큐가 비어 있나요?
    public boolean isEmpty()
    {
        return num == 0;
    }

    // 큐가 가득 찼나요?
    public boolean isFull()
    {
        return num == max;
    }

    // 큐 안의 모든 데이터를 프런트 -> 리어 순으로 출력
    public void dump()
    {
        if (isEmpty())
            System.out.println("큐가 비어 있습니다.");
        else
        {
            int i;
            for(i=0; i<num; i++)
                System.out.print(que[(i+front)%max] + " ");
            System.out.println();
        }
    }
}
