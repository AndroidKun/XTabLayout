# XTabLayout——可修改选中项字体大小和指示器长度的TabLayout
## XTabLayout是基于design包中的TabLayout进行了功能的扩展，在保留原有功能的基础上，增加了修改选中项字体大小、修改指示器长度以及限制屏幕显示范围内显示的Tab个数。
![github](http://img.blog.csdn.net/20161222095719330?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTE1MzM1ODg4Njc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
## 集成步骤：
### 1.添加XTabLayout依赖库
#### 在app目录下的build.gradle的dependencies中添加如下引用：

    compile 'com.androidkun:XTabLayout:1.0.2'
    
### 2.在布局文件中设置XTabLayout属性

    <com.androidkun.xtablayout.XTabLayout
        android:id="@+id/xTablayout"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        app:xTabMode="scrollable"
        app:xTabIndicatorColor="#0f0"
        app:xTabIndicatorHeight="4dp"
        app:xTabIndicatorWidth="15dp"
        app:xTabSelectedTextColor="#f00"
        app:xTabTextColor="#000"
        app:xTabTextSize="15sp"
        app:xTabSelectedTextSize="20sp"/>
     
#### TabLayout有的属性，在XTabLayout中都会有，属性名称都是前面加个x，后面的t变成大写。
#### 其中增加了xTabIndicatorWidth用于设置指示器长度，xTabTextSize用于设置未选中项的字体大小，xTabSelectedTextSize用于设置选中项的字体大小。
#### 此外1.0.1版本中添加如下属性可以设置屏幕范围内显示的Tab个数

    app:xTabDisplayNum="3"
    
#### 或者在代码中添加

    tabLayout.setxTabDisplayNum(3);//需要写在setupWithViewPager前
    tabLayout.setupWithViewPager(viewPager);
    
#### 这里我们限制为3个，则每个tab的宽度为屏幕的1/3，显示效果如下:
 ![github](http://img.blog.csdn.net/20161222150743866?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTE1MzM1ODg4Njc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 
#### 需要注意显示的个数会受Adapter的ItemCount影响，例如ItemCount为3，但是我们设置app:xTabDisplayNum=“4”，那么显示出来的Tab的宽度其实是屏幕的1/3，并非1/4。
 
### 3.初始化
#### XTabLayout的使用方式和TabLayout是一样的，代码如下：
    
     //将TabLayout和ViewPager关联起来。
    XTabLayout tabLayout = (XTabLayout) findViewById(R.id.xTablayout);
    tabLayout.setupWithViewPager(viewPager);
    
#[CSDN地址](http://blog.csdn.net/a1533588867/article/details/53810409)
    
