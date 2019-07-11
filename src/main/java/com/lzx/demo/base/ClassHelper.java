package com.lzx.demo.base;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 描述: 类助手
 *
 * @Auther: lzx
 * @Date: 2019/7/11 16:31
 */
@Slf4j
public class ClassHelper {

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     * @param clazz : 子类对象类型
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */

    public static Field getDeclaredField(Class<?> clazz, String fieldName){
        Field field = null ;

        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName) ;
                return field ;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了

            }
        }

        return null;
    }

}
