package com.jeff.baselibrary.ico;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.ico
 * @ClassName: CheckNet
 * @Description: 检测网络
 * @Author: jeff.wang
 * @CreateDate: 2020/8/13 19:25
 * @UpdateUser:
 * @UpdateDate: 2020/8/13 19:25
 * @UpdateRemark:
 * @Version:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckNet {
}
