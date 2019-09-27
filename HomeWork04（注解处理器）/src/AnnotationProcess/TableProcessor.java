package AnnotationProcess;

import java.io.File;
import java.util.List;


public class TableProcessor implements IProcessor {
    @Override
    public String process(String url) throws Exception {
        List<File> classFiles=Scanner.getClassFiles(url);
        StringBuilder sql=new StringBuilder();
        for (File file:classFiles){
            Class<?>clazz=ClassLoader.loadClass(file);
                if(clazz!=null){
                TableInfo tableInfo=new TableInfo().parse(clazz);
                if (tableInfo!= null) {
                    sql.append(tableInfo.toString());
                }
                }
        }
        return sql.toString();
    }
}
