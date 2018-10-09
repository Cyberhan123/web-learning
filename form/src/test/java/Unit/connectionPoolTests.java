package Unit;

import cn.hselfweb.jsp.Unit.ConnectionPool;
import org.junit.Test;

public class connectionPoolTests {
    @Test
    public void connectionTest(){
        ConnectionPool connectionPool= new ConnectionPool();
        ConnectionPool connectionPool1=new ConnectionPool(5);
    }

    public void getConnectionTest(){

    }
}
