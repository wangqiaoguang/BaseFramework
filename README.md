
***
# IOC 控制反转
通过反射方式实现注解
## 使用方式
#####    @OnClick(R.id.iv_icon)// 对应控件id 
#####    @CheckNet// 检测是否有网络，没有网络的时候吐司"网络异常"，并且不执行方法里面的内容
#####    @FastClick //防止重复点击 默认300毫秒，可以添加(3000)从而改变快速点击多少秒内无法点击
#####    public void click(){
#####        Log.e("count-icon->",count1+++"");
#####        Toast.makeText(this,"看看打开了吗",Toast.LENGTH_SHORT).show();
#####    }

***
