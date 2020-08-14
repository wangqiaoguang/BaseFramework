package com.jeff.baselibrary.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.jeff.baselibrary.BuildConfig;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.util
 * @ClassName: NetworkUtil
 * @Description:
 * @Author: jeff.wang
 * @CreateDate: 2020/8/13 19:43
 * @UpdateUser:
 * @UpdateDate: 2020/8/13 19:43
 * @UpdateRemark:
 * @Version:
 */
public class NetworkUtil {
    /**
     * android10版本
     * 判断网络类型：移动网络
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean isMobileQ29(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = cm.getActiveNetwork();
        if (null == network) {
            return false;
        }
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
        if (null == capabilities) {
            return false;
        }
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
    }


    /**
     * android10版本
     * 判断网络类型：Wi-Fi类型
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean isWifiQ29(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = cm.getActiveNetwork();
        if (null == network) {
            return false;
        }
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
        if (null == capabilities) {
            return false;
        }
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
    }

    /**
     * android10版本
     * 判断网络是否连接
     */
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public static boolean isConnectedQ29(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = cm.getActiveNetwork();
        if (null == network) {
            return false;
        }
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
        if (null == capabilities) {
            return false;
        }
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
    }

    /**
     * android 10以下
     *
     * @param context
     */
    public static boolean networkAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo network = connectivityManager.getActiveNetworkInfo();
            if (network != null && network.isAvailable()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 全版本检测是否有网络
     *
     * @param context
     * @return
     */
    public static boolean allVersionNetworkAvailable(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return isConnectedQ29(context);
        } else {
            return networkAvailable(context);
        }
    }


}
