package AnnotationProcess;

import Annoctation.Column;
import Annoctation.ID;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ColumnInfo {
    private String columnName;
    private  Class<?>type;
    private  boolean isID=false;
    private  boolean nullable=true;
    private  int length =32;
    private  boolean needPersist=false;
    public ColumnInfo parse(Field field){
        this.columnName=field.getName();
        this.type=field.getType();
        Annotation[] annotations=field.getAnnotations();
        for (Annotation annotation:annotations){
            //如果注解属性为表的列（字段），需要持久化
            if(annotation.annotationType().equals(Column.class)){
                this.needPersist=true;
                Column column=(Column) annotation;
                //如果value不空，设置字段名字为注解参数值。
                if(!column.value().equals("")){
                    this.columnName=column.value();
                }
                this.nullable=column.nullable();
                //设置字段长度值
                if(column.length()!=-1){
                    this.length=column.length();
                }else if(annotation.annotationType().equals(ID.class)){
                    this.needPersist=true;
                    ID id=(ID)annotation;
                    this.isID=true;
                    if(!id.value().equals("")){
                        this.columnName=id.value();
                    }
                }
            }
        }
            if(this.needPersist){
                return this;
            }
            else {
                return null;
            }
        }



    @Override
    public String toString() {
        StringBuilder sql = new StringBuilder(columnName);
        if (this.type.equals(String.class)){
            sql.append(" VARCHAR(").append(this.length).append(")");
        }else if (this.type.equals(Integer.class)){
            sql.append(" INT");
        }
        if (this.isID){
            sql.append(" PRIMARY KEY");
        }
        if (!this.nullable){
            sql.append(" NOT NULL");
        }
        sql.append(";");
        return sql.toString();
    }
}
