package com.jeff.baselibrary.ico;

import android.app.Activity;
import android.view.View;

/**
 * @ProjectName: WqgFramework
 * @Package: com.jeff.baselibrary.ico
 * @ClassName: ViewFinder
 * @Description: view 的findviewById 的辅助类
 * @Author: jeff.wang
 * @CreateDate: 2020/8/13 17:40
 * @UpdateUser:
 * @UpdateDate: 2020/8/13 17:40
 * @UpdateRemark:
 * @Version:
 */
class ViewFinder {
    private Activity mActivity;
    private View mView;

    public ViewFinder(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public ViewFinder(View mView) {
        this.mView = mView;
    }

    public View findViewById(int viewId){
        return mActivity != null?mActivity.findViewById(viewId):mView.findViewById(viewId);
    }
}
