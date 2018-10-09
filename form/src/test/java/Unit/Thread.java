package Unit;

import cn.hselfweb.jsp.Unit.ConnectionPool;

import java.sql.Connection;

public class Thread implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see java.lang.Thread#run()
     */
    private final static ConnectionPool connectionPool = new ConnectionPool();

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        System.out.println(connectionPool);
        System.out.println(connection);
    }


    void start() {
        Thread imp=new Thread();
        java.lang.Thread thread=new java.lang.Thread(imp);
        thread.start();
    }
}
