package com.jeff.baselibrary.ico;

import android.app.Activity;
import android.net.Network;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jeff.baselibrary.util.NetworkUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.ico
 * @ClassName: ViewUtils
 * @Description:
 * @Author: jeff.wang
 * @CreateDate: 2020/8/13 17:42
 * @UpdateUser:
 * @UpdateDate: 2020/8/13 17:42
 * @UpdateRemark:
 * @Version:
 */
public class ViewUtils {
    private static final String TAG = "ViewUtils";

    // 现在用
    public static void inject(Activity activity) {
        inject(new ViewFinder(activity), activity);
    }

    // todo
    public static void inject(View view) {
        inject(new ViewFinder(view), view);
    }

    // todo
    public static void inject(View view, Object object) {
        inject(new ViewFinder(view), object);
    }

    private static void inject(ViewFinder finder, Object object) {
        injectField(finder, object);
        injectEvent(finder, object);
    }

    /**
     * 属性注入
     *
     * @param finder
     * @param object
     */
    private static void injectField(ViewFinder finder, Object object) {
        //获取所有属性
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        try {
            //获取注解ViewById的value
            for (Field field : fields) {
                ViewById viewById = field.getAnnotation(ViewById.class);
                if (viewById != null) {
                    int viewId = viewById.value();
                    // findviewbyId
                    View view = finder.findViewById(viewId);
                    if (view != null) {
                        // 所有属性包括private也可以
                        field.setAccessible(true);
                        // 动态的注入找到的view

                        field.set(object, view);

                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.e(TAG, ex.getMessage() + "");
        }
    }

    /**
     * 点击事件注入
     * 支持单个参数View 没有参数
     *
     * @param finder
     * @param object
     */
    private static void injectEvent(ViewFinder finder, Object object) {
        // 获取所有方法
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();

        // 获取onclick注解的值
        for (Method method : methods) {
            OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick != null) {
                int[] viewIds = onClick.value();
                for (int viewId : viewIds) {
                    View view = finder.findViewById(viewId);
                    CheckNet checkNet = method.getAnnotation(CheckNet.class);
                    boolean isCheckNet = checkNet != null;
                    if (view != null) {
                        view.setOnClickListener(new DeclareOnClicklistener(object, method, isCheckNet));
                    }
                }
            }
        }
    }

    private static class DeclareOnClicklistener implements View.OnClickListener {
        private Object mObject;
        private Method method;
        private boolean isCheckNet;

        public DeclareOnClicklistener(Object mObject, Method method, boolean isCheckNet) {
            this.mObject = mObject;
            this.method = method;
            this.isCheckNet = isCheckNet;
        }

        @Override
        public void onClick(View v) {
            if (isCheckNet && v.getContext() != null && !NetworkUtil.allVersionNetworkAvailable(v.getContext())) {
                // todo 可以扩展，多出一个networkErrMethoD ,用来处理网络异常
                if (true) {
                    Toast.makeText(v.getContext(), "网络异常了", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            method.setAccessible(true);
            try {
                method.invoke(mObject, v);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    method.invoke(mObject,  null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e(TAG, ex.getMessage() + "");
                }
            }
        }
    }


}
