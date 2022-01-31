package src.ch7;

public class IntSet {
    private int max;
    private int cnt;
    private int[] set;

    public IntSet(int capacity) {
        cnt = 0;
        max = capacity;
        try {
            set = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return cnt;
    }

    public int indexOf(int n) {
        for (int i=0; i<cnt; i++)
            if (set[i] == n)
                return i;
        return -1;
    }

    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public boolean add(int n) {
        if (cnt >= max || contains(n))
            return false;
        else {
            set[cnt++] = n;
            return true;
        }
    }

    public boolean remove(int n) {
        int idx;

        if (cnt <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            set[idx] = set[--cnt];
            return true;
        }
    }

    public void copyTo(IntSet s) {
        int n = (s.max < cnt) ? s.max : cnt;
        for (int i=0; i<n; i++)
            s.set[i] = set[i];
        s.cnt = n;
    }

    public void copyFrom(IntSet s) {
        int n = (max < s.cnt) ? max : s.cnt;
        for (int i=0; i<n; i++)
            set[i] = s.set[i];
        cnt = n;
    }

    public boolean equalTo(IntSet s) {
        if (cnt != s.cnt) return false;

        for (int i=0; i<cnt; i++) {
            int j = 0;
            for ( ; j<s.cnt; j++) {
                if (set[i] == s.set[j])
                    break;
            }
            if (j == s.cnt) return false;
        }

        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i=0; i<s2.cnt; i++)
            add(s2.set[i]);

    }

    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");
        for (int i=0; i<cnt; i++)
            temp.append(set[i]+" ");
        temp.append("}");
        return temp.toString();
    }
}
