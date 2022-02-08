package src.ch8;

public class BFmatch {

    static int bfMatch(String txt, String pat) {
        int pt=0;
        int pp=0;

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++; pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == pat.length())
            return pt - pp;

        return -1;
    }

    public static void main(String[] args) {
        int idx = bfMatch("ABC이지스DEF", "이지스");

        if (idx == -1) {
            System.out.println("텍스트에 패턴이 없습니다.");
        } else {
            System.out.println((idx+1) + "번째 문자부터 일치합니다.");
        }
    }

}
