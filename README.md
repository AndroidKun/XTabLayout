# XTabLayout——可修改选中项字体大小和指示器长度的TabLayout
## XTabLayout是基于design包中的TabLayout进行了功能的扩展，在保留原有功能的基础上，增加了修改选中项字体大小、修改指示器长度以及限制屏幕显示范围内显示的Tab个数。
![github](http://img.blog.csdn.net/20161222095719330?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTE1MzM1ODg4Njc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
## 集成步骤：
### 1.添加XTabLayout依赖库
#### 在app目录下的build.gradle的dependencies中添加如下引用：

    compile 'com.androidkun:XTabLayout:1.1.0'
    
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
    
# 更新日志
## 1.0.3
### <font color=#f00>修改只有一个Tab时Tab未占满屏幕的bug。</font>
## 1.0.4
###  <font color=#f00>增加设置Tab背景色的功能。</font>

    app:xTabBackgroundColor="#fff"
    app:xTabSelectedBackgroundColor="#ff0"

### 两个属性分别对应Tab未选中和被选中的背景色，效果图如下：
![这里写图片描述](http://img.blog.csdn.net/20170329122554188?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTE1MzM1ODg4Njc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 1.0.5 & 1.0.6 
### <font color=#f00>增加设置指示器长度随Tab文本内容长度变化的功能。</font>
### 使用方式：不设置xTabIndicatorWidth属性即可  

## 1.0.7
### <font color=#f00>增加设置标题字母大小写转换功能，默认小写不自动转大写</font>
### 使用方式：在xml文件中添加app:xTabTextAllCaps="false"或者在代码中调用xTabLayout.setAllCaps(false); 


## 1.0.8
### 增加设置分割线功能
![这里写图片描述](http://img.blog.csdn.net/20170426123837504?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTE1MzM1ODg4Njc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

### 使用方式：
### 1.xml:
 
    app:xTabDividerWidth="2dp"
    app:xTabDividerHeight="15dp"
    app:xTabDividerColor="#000"
    app:xTabDividerGravity="center"
 
### 不设置xTabDividerHeight属性或者赋值为0时则分割线高度占满

### 2.java:
  
    tabLayout.setDividerSize(5,20);
    tabLayout.setDividerColor(Color.BLACK);
    tabLayout.setDividerGravity(DividerDrawable.CENTER);
  
### setDividerSize方法中第二个参数为高度，如果设置为0时则分割线高度占满

## 1.0.9
### <font color=#f00>优化设置指示器长度功能</font>
### 使用方式：
### a.明确指定指示器为某个长度则设置xTabIndicatorWidth
### b.指定指示器长度跟随文本变化则设置xTabDividerWidthWidthText
### c.如果需要指示器长度占满，则两个属性都不设置，默认占满。

## 1.1.0
### <font color=#f00>增加设置字体粗体功能</font>
![这里写图片描述](http://img.blog.csdn.net/20170615123443179?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYTE1MzM1ODg4Njc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
### 使用方式：
   
        <!-- 设置选中Tab的文本是否粗体显示-->
        app:xTabTextSelectedBold="true"
          <!-- 设置未选中Tab的文本是否粗体显示-->
        app:xTabTextBold="true"
        
# [CSDN地址](http://blog.csdn.net/a1533588867/article/details/53810409)
    
