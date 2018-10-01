package cn.hselfweb.jsp.Unit;
import java.util.HashMap;
import java.util.Map;

public class Tools {
    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "a");
        map.put(1, "b");
        map.put(2, "c");
        map.put(3, "d");
    }

    public static String getMap(Integer num) {
        return map.get(num);
    }


}
