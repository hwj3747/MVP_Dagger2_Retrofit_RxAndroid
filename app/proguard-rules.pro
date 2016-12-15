# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\hwj3747\AppData\Local\Android\sdk1/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep class cn.jiajixin.nuwa.** { *; }
-keep class android.support.design.widget.** { *; }
-keep interface android.support.design.widget.** { *; }
-dontwarn android.support.design.**

#第三方架包
#butterknife
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}
-dontwarn butterknife.Views$InjectViewProcessor
-dontwarn com.gc.materialdesign.views.**

#retrofit
-dontwarn retrofit.**
-dontwarn retrofit.appengine.UrlFetchClient
-keep class retrofit.** { *; }
-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}

#rx
-dontwarn rx.**
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }

#支付宝
-keep class com.alipay.**{*;}
-keep class com.ta.utdid2.**{*;}
-keep class com.ut.device.**{*;}

-dontwarn com.alipay.**
-dontwarn com.ta.utdid2.**
-dontwarn com.ut.device.**

-keepclassmembers class ** {
    public void onEvent*(**);
}


#smssdk
-dontwarn  cn.smssdk.**
-keep class cn.smssdk.**{*;}
-keep class com.mob.tools.**{*;}
-keep class com.mob.logcollector.**{*;}

#sharesdk
-keep class cn.sharesdk.**{*;}

#badgeview
-dontwarn cn.bingoogolapple.badgeview.**


#view
-dontwarn  com.haiyangroup.parking.view.**
-keep class com.haiyangroup.parking.view.**{*;}
#picasso
-dontwarn com.squareup.picasso.**
-keep class com.squareup.picasso.** { *; }
-keep public class * extends com.squareup.picasso.**

#-libraryjars ../LibForND/libs/uil-library.jar
-dontwarn com.nostra13.universalimageloader.**
-keep class com.nostra13.universalimageloader.** { *; }
-keep public class * extends com.nostra13.universalimageloader.**

#-libraryjars gson-2.2.4.jar
-dontwarn com.google.gson.**
-keep class com.google.gson.** { *; }
-keep public class * extends com.google.gson.**

#-fastjson
-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }
-keep public class * extends com.alibaba.fastjson.**

#-libraryjars ../LibForND/libs/android-support-v4.jar
-dontwarn android.support.v4.**
-keep class android.support.v4.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

#-umeng
-dontwarn com.umeng.**
-keep class com.umeng.** { *; }
-keep public class * extends com.umeng.**

#-baidumap
-keep class com.baidu.** { *; }
-keep class vi.com.gdi.bgl.android.**{*;}
-keep class pvi.com.gdi.bgl.android.**{*;}

#-jpush
-dontwarn cn.jpush.**
-keep class cn.jpush.** { *; }

#-wx
-keep class com.tencent.mm.sdk.openapi.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}

#-sharesdk
-keep public class * extends com.sina.weibo.**

#-materialdialog
-dontwarn com.afollestad.materialdialogs.**
-keep class com.afollestad.materialdialogs.**{*;}

#-tourguide
-dontwarn tourguide.tourguide.**
-keep class tourguide.tourguide.**{*;}


#-baidunavisdk
-dontwarn com.baidu.navisdk.**
-keep class com.baidu.navisdk.**{*;}

#-baidulocation
-dontwarn com.baidu.location.**
-keep class com.baidu.location.**{*;}

#-ormlite
-dontwarn com.j256.ormlite.**
-keep class com.j256.ormlite.**{*;}

-keep class android.net.http.SslError
-keep class android.webkit.**{*;}
-keep class cn.sharesdk.**{*;}
-keep class com.sina.**{*;}
-keep class m.framework.**{*;}

-dontwarn android.net.http.SslError
-dontwarn android.webkit.**
-dontwarn cn.sharesdk.**
-dontwarn com.sina.**
-dontwarn m.framework.**

#-servlet-api
-keep class javax.servlet.** { *; }
-dontwarn javax.servlet.**
#-struts2
-keep class org.apache.struts2.**{*;}
-dontwarn org.apache.struts2.**

-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-keepattributes Signature
-dontpreverify

#不混淆输入的类文件 ,使用该属性，不能生成mapping文件
#-dontobfuscate

#不优化输入的类文件
#-dontoptimize

-verbose

-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*,!field/removal/writeonly,!field/marking/private,!class/merging/*,!code/allocation/variable

#保护anotation的标签属性
-keepattributes Annotation

#保护js的函数属性
-keepattributes JavascriptInterface
#Gson 保护内部类
-keepattributes EnclosingMethod

-keepattributes InnerClasses
#-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,LocalVariable*Table,*Annotation*,Synthetic,EnclosingMethod
-keepattributes SourceFile, LineNumberTable
-keep,allowshrinking,allowoptimization class * { <methods>; }

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-keepclasseswithmembernames class * {
native <methods>;
}

-keepclasseswithmembers class * {
public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
public void *(android.view.View);
}

-keepclassmembers enum * {
public static **[] values();
public static ** valueOf(java.lang.String);
}

-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}

-keep class * implements android.os.Parcelable {
public static final android.os.Parcelable$Creator *;
}

-assumenosideeffects class android.util.Log {
      public static boolean isLoggable(java.lang.String,int);
      public static int v(...);
      public static int i(...);
      public static int w(...);
      public static int d(...);
      public static int e(...);
}

#不混淆 Entity，用户Gson 和OrmList 映射
-keepclassmembers class * extends com.haiyangroup.model.domain.entity.BaseEn{
	*;
}

-keep class **.R$* {
    *;
}
-keep class com.hyphenate.** {*;}
-dontwarn  com.hyphenate.**