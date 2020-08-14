package com.jeff.baselibrary.ico;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.ico
 * @ClassName: FastClick
 * @Description:
 * @Author: jeff.wang
 * @CreateDate: 2020/8/14 15:47
 * @UpdateUser:
 * @UpdateDate: 2020/8/14 15:47
 * @UpdateRemark:
 * @Version:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FastClick {
    long value() default 300;
}
