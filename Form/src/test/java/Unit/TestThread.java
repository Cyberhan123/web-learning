package Unit;

import cn.hselfweb.jsp.Unit.ConnectionPool;

public class TestThread {
    public static void main(String args[]){
        ConnectionPool connectionPool=new ConnectionPool();
        Thread thread= new Thread();
        Thread thread1= new Thread();
        Thread thread2= new Thread();
       thread.start();
       thread1.start();
       thread2.start();
    }
}
