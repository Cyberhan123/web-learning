package cn.hselfweb.jsp.Unit;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMap {
    String value();
}
