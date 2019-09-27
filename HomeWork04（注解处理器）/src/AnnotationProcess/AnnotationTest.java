package AnnotationProcess;

import Annoctation.Column;
import Annoctation.Entity;
import Annoctation.ID;

import java.awt.desktop.SystemSleepEvent;

public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        TableProcessor tableProcessor=new TableProcessor();
        String sql=tableProcessor.process(System.getProperty("user.dir"));
        System.out.println(sql);

    }
    @Entity("people")//创建一张名为people的表
    public  class  Person{
        @ID
        @Column(nullable = false)
        private Integer id;
        @Column(nullable = false,length = 16)
        private  String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

