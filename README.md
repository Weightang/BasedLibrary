# BasedLibrary
基础框架库

#### 常用的基础类，工具类。

使用：
直接把类拷贝项目中


结构：
* . base包
  * ---mvp包
    * ---MvpActivity.java
    * ---MvpLazyFragment.java
    * ---BaseView.java
    * ---BasePresenter.java
    ```
    mvp下的base类:
    优点:
    1. 结构清晰，便于分析问题；
    2. 解耦
    缺点
    1.编写类多
    2. 实际存在一个问题，当一个业务接口要被多个Activity，Fargment调用时，就需要把它按着常规MVP模式写了；
  * ---BaseActivity.java
  * ---BaseFragment.java
  * ---BaseLazyFragment.java(Fragment懒加载类)
* baseapi（http请求包）
  * BaseFlowableSubscriber.java(支持背压的)
  * BaseSubscriber.java
  * ExceptionHandle.java
  * JsonParams.java
  * RetrofitCallback.java
  * RetrofitManager.java
* net(网络状态监听包)
  * NetChangeObserver.java
  * NetStateReceiver.java
  * NetUtils.java
* utils（工具包）
  * AppManager.java
  * CardNoUtils.java
  * ConstUtils.java
  * Convert.java
  * DialogHelper.java
  * Doubleformat.java
  * EmptyUtils.java
  * FragmentTabUtils.java
  * ImageUtil.java
  * MD5Utils.java
  * RegexUtils.java
  * SPUtils.java
  * TimeUtils.java
  
  
  
  
  
### 感谢
  [Blankj/AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode)

  
  

### License

```
   Copyright (C) 2017 weightang

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
