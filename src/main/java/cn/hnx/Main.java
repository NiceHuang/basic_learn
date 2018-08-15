package cn.hnx;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


/**
 * Created by viruser on 2018/8/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList(args);
        Class clazz = Class.forName("cn.hnx.Student");
//        testConstructor(clazz);
//        testField(clazz);
        testMethod(clazz);
    }


    public static void testMethod(Class clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("=========================================================================");
//        methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//        Method method = clazz.getDeclaredMethod("show4", int.class);
//        method.setAccessible(true);
        Object object = clazz.getDeclaredConstructor().newInstance();
//        method.invoke(object, 2);
        methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
            if ("show4".equals(method.getName())){
                method.invoke(object, 2);
            }
        }
    }


    /**
     * 测试成员变量
     * @param clazz
     */
    public static void testField(Class clazz) throws Exception {

        //获取所有公有成员变量
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("=======================================================");
        //获取所有成员变量
        fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        Field field = clazz.getDeclaredField("sex");
        Object object = clazz.getDeclaredConstructor().newInstance();
        field.setAccessible(true);
        field.set(object, '男');
        System.out.println(object.toString());
    }


    /**
     * 测试构造方法
     * @param clazz
     */
    public static void testConstructor(Class clazz) throws Exception {
        //获取所有公有构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("=======================================================");
        //获取所有构造方法
        constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        Constructor con = clazz.getDeclaredConstructor(char.class);
        con.setAccessible(true);
        Student object = (Student) con.newInstance('男');
        System.out.println(object.toString());
    }
}
