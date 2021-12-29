package src.ch4.Stack;

public class IntStack {
    int max;
    int ptr;
    int[] stk;

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException
    {
        public EmptyIntStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends  RuntimeException
    {
        public OverflowIntStackException() { }
    }

    public IntStack(int capacity)
    {
        ptr = 0;
        max = capacity;
        try
        {
            stk = new int[max];
        } catch (OutOfMemoryError e)
        {
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException
    {
        if (x >= max)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException
    {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    public int peek() throws EmptyIntStackException
    {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 스택에서 x를 찾아 인덱스 (없으면 -1) 반환
    public int indexOf(int x)
    {
        int i;
        for (i = ptr-1; i>=0; i--)
        {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    // 스택을 비움
    public void clear()
    {
        ptr = 0;
    }

    // 스택의 용량을 반환
    public int capacity()
    {
        return max;
    }

    // 스택에 쌓여 있는 데이터 수를 반환
    public int size()
    {
        return ptr;
    }

    // 스택이 비어있는가?
    public boolean isEmpty()
    {
        return ptr == 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull()
    {
        return ptr == max;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump()
    {
        if (ptr == 0)
            System.out.println("스책이 비어 있습니다.");
        else
        {
            int i;
            for (i=0; i<ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
