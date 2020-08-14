package com.jeff.baselibrary.ico;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.ico
 * @ClassName: OnClick
 * @Description:
 * @Author: jeff.wang
 * @CreateDate: 2020/8/13 17:38
 * @UpdateUser:
 * @UpdateDate: 2020/8/13 17:38
 * @UpdateRemark:
 * @Version:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {

    int[] value();
}
