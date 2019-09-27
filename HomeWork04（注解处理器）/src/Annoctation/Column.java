package Annoctation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //列名（属性名）
    public  String value() default "";
    //是否可以为空
    public  boolean nullable() default true;
    //长度
    public  int length() default -1;
}
