Usage example of **Yandex.Metrica for Android Apps**.

How to start
------------

*  Clone repository: git clone https://github.com/yandexmobile/metrica-sample-android.git
*  Current relevant sample is **metrica-sample-android**.
*  The sample was created by **Android Studio**.
*  In the folder with name **"libs"** & **"jniLibs"** you can find all necessary libraries.
*  You only should obtain and define your own API_KEY.
*  Example of using **Reporters** shown in project **library**
*  Now we are ready to launch project!

> **ProGuard:**
If you use **[ProGuard](http://developer.android.com/tools/help/proguard.html)**, you need to keep **com.yandex.metrica** classes. You can use the following lines of code:

* `-keep class com.yandex.metrica.impl.* { *; }`
* `-dontwarn com.yandex.metrica.impl.*`

* `-keep class com.yandex.metrica.* { *; }`
* `-dontwarn com.yandex.metrica.*`

Notes
-------------------------------

* The last **mobmetricalib** library has the version `2.51` and the level of **API**  is `48`.  Because of using aar version of library, it's only can be defined optional permissions.

* Alternatively you can add the last version of **Metrica for Apps** to your project as **maven artifact** from the **maven central**:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib
    * **version**: 2.51

Documentation
---------------------------
* You can register your app at [Yandex.Metrica for Apps homepage](http://appmetrica.yandex.ru/).
* [Documentation in Russian](https://tech.yandex.ru/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-history-docpage/) and [Documentation in English](https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-history-docpage/) are available. You can find some additional information about **mobmetricalib** there.
* Test example for **mobmetricalib** is available at [https://github.com/yandexmobile/metrica-sample-android](https://github.com/yandexmobile/metrica-sample-android). It demonstrates several library use-cases.

License
---------

License agreement on use of Yandex.Metrica for Apps SDK is available at: [http://legal.yandex.ru/metrica_termsofuse/](http://legal.yandex.ru/metrica_termsofuse/).
