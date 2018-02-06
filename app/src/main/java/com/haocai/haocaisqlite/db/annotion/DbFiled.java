package com.haocai.haocaisqlite.db.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Xionghu on 2018/2/2.
 * Desc:
 */
@Target(ElementType.FIELD) //字段、枚举的常量
@Retention(RetentionPolicy.RUNTIME) //注解会在class字节码文件中存在，在运行时可以痛过反射获取到
public @interface DbFiled {
    String value();
}
