echo "# aaa" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/xxrxjava/aaa.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin https://github.com/xxrxjava/aaa.git
git branch -M main
git push -u origin main



（1）Context是什么？
Context英文释义是当前上下文，或者当前场景
①该类是一个抽象(abstract class)类；

②它描述的是一个应用程序环境的信息，即上下文；

③通过它，我们可以获取应用程序的资源和类，也包括一些应用级别操作；
从中，我们看见了一些熟悉的对象——Application、Activity、Service、Broadcast、Intent。
①Activity、Service继承自ContextWrapper，而ContextWrapper又是Context的子类，那么Activity、Service最终是继承自Context；

②Application直接继承自Context；

通过以上的继承关系，我们就可以知道，Context的具体作用会包括：

启动一个新的Activity
启动和停止Service
发送广播消息(Intent)
注册广播消息(Intent)接收者
可以访问APK中各种资源，如Resources和AssetManager
创建View
访问Package的相关信息
APK的各种权限管理
（3）Context创建时机？

由上面分析的继承关系，我们可以知道，Context创建的时机有三个：

①创建Application 对象时， 而且整个App共一个Application对象；

②创建Service对象时；

③创建Activity对象时；

所以应用程序App共有的Context数目公式为：

Service个数 + Activity个数 + 1（Application对应的Context实例）
1）Context使用时注意什么？

如上，Android中context可以作很多操作，但是最主要的功能是加载和访问资源。在android中常用的context有两种，一种是application context，一种是activity context，通常我们在各种类和方法间传递的是activitycontext。

两者的区别：

public class MyActivity extends Activity {  
    public void method() {  
        mContext = this; // since Activity extends Context  
        mContext = getApplicationContext();  
    }  
}
this 是Activity 的实例，扩展了Context，其生命周期是Activity 创建到销毁。getApplicationContext()返回应用的上下文，生命周期是整个应用，应用摧毁它才被摧毁。Activity.this的context 返回当前activity的上下文，属于activity ，activity摧毁时被摧毁。

使用Context时最需要注意的一个点就是，使用了不正确的context，比如有一个全局的数据操作类用到了context，这个时候就要getApplicationContext 而不是用ACtivity，如果在这个全局操作中引用的是Activity的context，那么就会一直引用Activity的资源，导致GC无法回收这部分内存，从而最终导致了内存泄漏。

内存泄漏是开发中常见的错误之一，能不能发现取决于开发者的经验，当然了我们也会依赖现有的内存泄漏库，但是如果我们在开发的源头减少内存泄漏的概率，那么后期的工作会少很多。

以下是避免context相关的内存泄露，给出的几点建议：

不要让生命周期长的对象引用activity context，即保证引用activity的对象要与activity本身生命周期是一样的；
对于生命周期长的对象，可以使用application context；
避免非静态的内部类，尽量使用静态类，避免生命周期问题，注意内部类对外部对象引用导致的生命周期变化；
2）Context的常见应用场景
https://img-blog.csdn.net/20180410160916195?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MTEwMTE3Mw==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70
