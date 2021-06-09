package il.ac.tau.cs.sw1.ex9.riddles.forth;


import java.util.Iterator;

public class B4 implements Iterator<String> {

    private String[] stringsArr;
    private int randNum;
    private int cuurIndex;
    private int currRepeat;

    public B4(String[] stringsArr, int randNum) {
        this.stringsArr = stringsArr;
        this.randNum = randNum;
        cuurIndex = 0;
        currRepeat = 0;
    }

    @Override
    public boolean hasNext() {
        return currRepeat < randNum && cuurIndex < stringsArr.length;
    }

    @Override
    public String next() {
        String temp = stringsArr[cuurIndex];
        cuurIndex++;
        if (cuurIndex == stringsArr.length) {
            cuurIndex = 0;
            currRepeat++;
        }
        return temp;
    }
}
