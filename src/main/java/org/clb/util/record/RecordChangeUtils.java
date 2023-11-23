package org.clb.util.record;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RecordChangeUtils {

    public static void main(String[] args) {
        RecordTest oldV = new RecordTest("11","1");
        RecordTest newV = new RecordTest("22","1");
        recordChange(oldV,newV,RecordTest.class);
    }
     public static void recordChange(Object oldValue, Object newValue, Class recordClass){
         Field[] fields = recordClass.getDeclaredFields();
         MetaObject oldObject = SystemMetaObject.forObject(oldValue);
         MetaObject newObject = SystemMetaObject.forObject(newValue);
         for (Field field : fields) {
             Annotation[] annotations = field.getAnnotations();
             for (Annotation annotation : annotations) {
                 if (annotation instanceof RecordAnnotation){
                     RecordAnnotation recordAnnotation = ((RecordAnnotation) annotation);
                     if (newObject.getValue(field.getName())!=null&&
                             !newObject.getValue(field.getName()).equals(oldObject.getValue(field.getName()))){
                         System.out.println(field.getName()+"值不等");
                     }
                 }
             }
         }
     }
}
