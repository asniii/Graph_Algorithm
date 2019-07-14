package test.hsbc_backend;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HackerEarth extends Thread{

    static CopyOnWriteArrayList hck = new CopyOnWriteArrayList();

    public void testhack()
    {
        hck.add("K");
    }

    public static void main(String args[]) {
        Thread t = Thread.currentThread();
        System.out.println(t);
    }
}
