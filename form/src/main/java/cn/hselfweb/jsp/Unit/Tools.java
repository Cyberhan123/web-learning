package cn.hselfweb.jsp.Unit;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
