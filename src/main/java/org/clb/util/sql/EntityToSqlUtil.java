package org.clb.util.sql;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EntityToSqlUtil {

    public static void main(String[] args) {
        String packageName = "org.clb.util.sql.entity";
        String outputFileName = "E:\\output.txt";

        generateTableScript(packageName, outputFileName);
    }

    public static void generateTableScript(String packageName, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            // 获取指定包下的所有类
            Class<?>[] classes = ClassUtils.getClasses(packageName);

            for (Class<?> clazz : classes) {
                // 获取类名

                TableName tableName = clazz.getAnnotation(TableName.class);
                // 生成建表语句
                writer.write("CREATE TABLE " + tableName.value() + " (\n");

                // 获取类的所有字段
                Field[] fields = clazz.getDeclaredFields();
                List<Field> list = new ArrayList<>();
                list.addAll(Arrays.asList(fields));
                Class<?> superclass = clazz.getSuperclass();
                if (superclass!=null) {
                    Field[] declaredFields = superclass.getDeclaredFields();
                    list.addAll(Arrays.asList(declaredFields));
                }
                for (Field field : list) {
                    // 获取字段名
                    String columnName = convertCamelToUnderscore(field.getName()).toLowerCase();
                    if ("name".equals(columnName)||"type".equals(columnName)||"desc".equals(columnName)) {
                        columnName = "`"+columnName+"`";
                    }
                    // 获取字段类型
                    String columnType ="resource_id".equals(columnName)?"varchar(64)": getColumnType(field.getType());

                    // 获取ApiModelProperty注解
                    ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
                    String comment = (apiModelProperty != null) ? apiModelProperty.value() : "";

                    // 生成字段语句
                    writer.write("  " + columnName + " " + columnType + " COMMENT '" + comment + "',\n");
                }

                writer.write("\tPRIMARY KEY ( `id` ) USING BTREE,\n" +
                        "\tUNIQUE KEY `resource_id` ( `resource_id` ) USING BTREE"+
                        ");\n\n");
            }

            System.out.println("Table scripts generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getColumnType(Class<?> fieldType) {
        // 这里简单演示，实际应用中需要更复杂的映射关系
        if (fieldType == String.class) {
            return "varchar(255)";
        } else if (fieldType == int.class || fieldType == Integer.class) {
            return "int";
        } else if (fieldType == Date.class) {
            return "datetime";
        } else {
            // 其他类型的映射...
            return "UNKNOWN";
        }
    }
    public static String convertCamelToUnderscore(String camelCase) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < camelCase.length(); i++) {
            char currentChar = camelCase.charAt(i);

            if (Character.isUpperCase(currentChar) && i > 0) {
                result.append('_');
            }

            result.append(Character.toLowerCase(currentChar));
        }

        return result.toString();
    }
    private static class ClassUtils {

        public static Class<?>[] getClasses(String packageName) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            URL resource = classLoader.getResource(path);
            File directory = new File(resource.getFile());

            List<Class<?>> classes = new ArrayList<>();
            if (directory.exists()) {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        try {
                            classes.add(Class.forName(className));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            return classes.toArray(new Class[0]);
        }
    }

}
