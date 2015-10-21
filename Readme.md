Usage example of **Yandex.Metrica for Android Apps**.

How to start
------------

*  Clone repository: git clone https://github.com/yandexmobile/metrica-sample-android.git.
*  Current relevant sample is **metrica-sample-android-2.21**.
*  The sample was created by **Android Studio**.
*  In the folder with name **"libs"** & **"jniLibs"** you can find all necessary libraries.
*  Now we are ready to launch project!

> **ProGuard:**
If you use **[ProGuard](http://developer.android.com/tools/help/proguard.html)**, you need to keep **com.yandex.metrica** classes. You can use the following lines of code:

* `-keep class com.yandex.metrica.impl.* { *; }`
* `-dontwarn com.yandex.metrica.impl.*`

* `-keep class com.yandex.metrica.* { *; }`
* `-dontwarn com.yandex.metrica.*`

Notes
-------------------------------

* The last **mobmetricalib** library has the version `2.21` and the level of **API**  is `35`.  Thus in the **AndroidManifest.xml** you can see that the **metrica:api:level** value is equal to **35**.

* Alternatively you can add the last version of **Metrica for Apps** to your project as **maven artifact** from the **maven central**:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib
    * **version**: 2.21

Documentation
---------------------------
* You can register your app at [Yandex.Metrica for Apps homepage](http://appmetrica.yandex.ru/).
* [Documentation in Russian](https://tech.yandex.ru/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-history-docpage/) and [Documentation in English](https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-history-docpage/) are available. You can find some additional information about **mobmetricalib** there.
* Test example for **mobmetricalib** is available at [https://github.com/yandexmobile/metrica-sample-android](https://github.com/yandexmobile/metrica-sample-android). It demonstrates several library use-cases.

License
---------

License agreement on use of Yandex.Metrica for Apps SDK is available at: [http://legal.yandex.ru/metrica_termsofuse/](http://legal.yandex.ru/metrica_termsofuse/).

-------------
-------------


В этом репозитории находится тестовое приложение, демонстрирующее библиотеку **Yandex.Metrica for Android Apps**.

Как начать
------------

*  Клонируйте репозиторий примера git clone https://github.com/yandexmobile/metrica-sample-android.git.
*  Текущий действующий пример находится в папке **metrica-sample-android-2.21**.
*  Данный пример был создан в среде разработки **Android Studio**.
*  В папке **"libs"** & **"jniLibs"** уже находятся все нужные библиотеки.
> Библиотека **mobmetricalib** доступна и с включенной в нее библиотекой **protobuf**. В таком случае подключать **protobuf** не нужно.
*  Теперь мы готовы к запуску тестового проекта.

> **ProGuard:**
Если вы используете **[ProGuard](http://developer.android.com/tools/help/proguard.html)** при сборке проекта, то следует не изменять **Metrica**. Вы можете использовать следующие строчки кода:

* `-keep class com.yandex.metrica.impl.* { *; }`
* `-dontwarn com.yandex.metrica.impl.*`

* `-keep class com.yandex.metrica.* { *; }`
* `-dontwarn com.yandex.metrica.*`

Примечания к примеру
-------------------------------

* Данный пример использует библиотеку **mobmetricalib** версии `2.21` и уровнем **API** равным `35`. Поэтому в файле **AndroidManifest.xml** вы можете увидеть, что значение **metrica:api:level** равно **35**.
* Последнюю Метрику для приложений можно добавить в проект и как **maven-артефакт** с **maven-central**:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib
    * **version**: 2.21

Документация
---------------------------
* Вы можете зарегистрировать свое приложение на [домашней странице Yandex.Metrica for Apps](http://appmetrica.yandex.ru/).
* Доступна [документация на русском](https://tech.yandex.ru/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-history-docpage/) и [на английском](https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-history-docpage/), в которой содержится полная документация по **mobmetricalib** и описание подключения библиотеки к вашему проекту, а также инструкции по использованию.
* Доступен тестовый пример, демонстрирующий различные возможности библиотеки. Вы можете найти его в другом репозитории [здесь](https://github.com/yandexmobile/metrica-sample-android).


Лицензия
---------

Лицензионное соглашение по использованию **Yandex.Metrica for Apps SDK** доступно по следующей ссылке [http://legal.yandex.ru/metrica_termsofuse/](http://legal.yandex.ru/metrica_termsofuse/).

