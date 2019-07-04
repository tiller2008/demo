package com.example.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 用于解决子类继承父类时，确定泛型的具体类型
 * @author Bob
 * @date 22:23 2019-06-25
 **/
public class GenericsUtils {
    /**
      * 通过反射,获得定义Class时声明的父类的范型参数的类型.
      * 如public BookManager extends GenricManager<Book>
      *
      * @param clazz The class to introspect
      * @return the first generic declaration, or <code>Object.class</code> if cannot be determined
      */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
      * 通过反射,获得定义Class时声明的父类的范型参数的类型.
      * 如public BookManager extends GenricManager<Book>
      *
      * @param clazz clazz The class to introspect
      * @param index the Index of the generic ddeclaration,start from 0.
      */
    public static Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }

        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }
}