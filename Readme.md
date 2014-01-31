Usage example of **Yandex.Metrica for Android Apps**.

How to start
------------

*  Clone repository: git clone https://github.com/yandexmobile/metrica-sample-android.git.
*  The sample was created by **IntelliJ IDEA**, so just import it to your favorite **IDE**. 
*  In the folder with name **"libs"** you can find **mobmetricalib** and **protobuf** library. 
> The **mobmetricalib** library is available with **protobuf** library within itself. In this case in your project shouldn't be the **protobuf** library.
* Check the settings of **metrica-sample-android** project, that the libraries (**mobmetricalib**, **protobuf** or only **mobmetricalib with the protobuf inside**) are added to dependencies.
*  Now we are ready to launch project!

> **ProGuard:**
If you build your application with **[ProGuard](http://developer.android.com/tools/help/proguard.html)**, you need to keep the **Metrica**. You can use the following lines of code:

* `-keep class com.yandex.metrica.** { *; }`
* `-dontwarn com.yandex.metrica.**`

Notes
-------------------------------

* The last **mobmetricalib** library has the version `1.2` and the level of **API**  is `4`.  Thus in the **AndroidManifest.xml** you can see that the **metrica:api:level** value is equal to **4**.
* The example uses **API_KEY** equal to `1111`. The key is specified in the **AndroidManifest.xml** file, but we can do it programmatically.

* Alternatively you can add the last version of **Metrica for Apps** to your project as **maven artifact** from the **maven central**:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib
    * **version**: 1.2

Version 1.2, Changelog
------------------------------

* **Yandex.Metrika for Apps** now uses **[protobuf-2.5.0](http://search.maven.org/#artifactdetails%7Ccom.google.protobuf%7Cprotobuf-java%7C2.5.0%7Cbundle)**.
* **API-level** is now **4**.
* Greatly reduced the size of the library which is supplied with the **protobuf** library (from 360 Kb to 150 Kb).
* Added new methods:
    * `getLibraryVersion()` — returns a version of the library (e.g. **"1.2"**);
    * `getLibraryApiLevel()` — returns the API level of library (e.g. **4**);
    * `isMetricaProcess(android.content.Context)` — specifies whether the Metrica process is running or not.
* Additional statistical parameters:
    * `"Root" status` — you can read about root devices [here](http://en.wikipedia.org/wiki/Android_rooting);
    * `Device type` — the next types of devices such as **Smartphone**, **Phablet**, **Tablet**, and **TV** are now displayed.
* Fixed a large number of bugs:
    * The `metrica:api:key` option can be omitted in the **AndroidManifest.xml** file and this option can be set programmatically without problems.
    * Bugs associated with the database.
    * Bugs associated with **ProGuard**. Now if you build your application with **ProGuard**, you need to keep **Metrica library**. You can use the following lines of code:
        * `-keep class com.yandex.metrica.** { *; }`
        * `-dontwarn com.yandex.metrica.**`
* Fixed **javadocs**.

Additional information
---------------------------

* [Documentation in Russian](http://api.yandex.ru/metrica-mobile-sdk/) and [Documentation in English](http://api.yandex.com/metrica-mobile-sdk/), where you can find some additional information about **mobmetricalib**.
* Various versions of library and **java-docs** are available at [https://github.com/yandexmobile/metrica-sdk-android](https://github.com/yandexmobile/metrica-sdk-android).
* You can register your app at [Yandex.Metrica for Apps homepage](http://appmetrica.yandex.ru/).

License
---------

License agreement on use of Yandex.Metrica for Apps SDK is available at: [http://legal.yandex.ru/metrica_termsofuse/](http://legal.yandex.ru/metrica_termsofuse/).


-------------
-------------


В этом репозитории находится тестовое приложение, демонстрирующее библиотеку **Yandex.Metrica for Android Apps**.

Как начать
------------

*  Клонируйте репозиторий примера git clone https://github.com/yandexmobile/metrica-sample-android.git.
*  Данный пример уже настроен для работы в среде __IntelliJ IDEA__ поэтому
импортируйте данный тестовый пример в среду **IntelliJ IDEA** или в другую среду разработки, как например **Eclipse**. 
* В папке **libs** уже находится библиотека **mobmetricalib** и **protobuf**. 
> Библиотека **mobmetricalib** доступна и с включенной в нее библиотекой **protobuf**. В таком случае подключать **protobuf** не нужно.
* Проверьте в настройках проекта **metrica-sample-android**, что в зависимостях подключены библиотеки (**mobmetricalib**, **protobuf** или **mobmetricalib с protobuf внутри**).
*  Всё готово к запуску тестового проекта.

> **ProGuard:**
Если вы используете **[ProGuard](http://developer.android.com/tools/help/proguard.html)** при сборке проекта, то следует не изменять **Metrica**. Вы можете использовать следующие строчки кода:

* `-keep class com.yandex.metrica.** { *; }`
* `-dontwarn com.yandex.metrica.**`

Примечания к примеру
-------------------------------

* Данный пример использует библиотеку **mobmetricalib** версии `1.2` и уровнем **API** равным `4`. Поэтому в файле **AndroidManifest.xml** вы можете увидеть, что значение **metrica:api:level** равно **4**.
* В примере используется тестовый **API_KEY** равный `1111`. В данном примере ключ указывается прямо внутри **AndroidManifest.xml**, но его можно устанавливать и программно.

* Последнюю Метрику для приложений можно добавить в проект и как **maven-артефакт** с **maven-central**:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib
    * **version**: 1.2
    
Версия 1.2, Список изменений
------------------------------

* **Метрика для приложений** использует **protobuf-2.5.0**.
* Теперь **metrica:api:level** нужно устанавливать равным 4.
* Значительно уменьшен размер библиотеки, поставляемой с **protobuf** внутри себя (с 360 Кб до 150 Кб).
* Добавлены новые методы:
	* `getLibraryApiLevel()` — возвращает версию билиотеки (например **"1.2"**).
	* `getLibraryVersion()` — возвращает **API-уровень** библиотеки (например **4**).
	* `isMetricaProcess(android.content.Context)` — возвращает булевское значение, показывающее находимся ли мы в процессе Метрики или нет.
* Дополнительные параметры статистики:
	* `"Root" status` — вы можете почитать о root **[здесь](http://ru.wikipedia.org/wiki/Рутинг)**.
	* `Device type` — в статистике будут доступны следующие типы устройств: **Смартфон**, **Фаблет**, **Планшет**, **ТВ**.
* Исправлено большое количество ошибок:
	* Теперь можно опускать `metrica:api:key` опцию в **AndroidManifest.xml** файле и устанавливать ее программно без проблем.
	* Ошибки связанные с базой данных.
	* Ошибки связанные с обфускатором **ProGuard**. Если вы используете **ProGuard** при сборке вашего проекта, то следует не обфусцировать **Metrica**. Вы можете использовать следующие строчки кода ниже:
		* `-keep class com.yandex.metrica.** { *; }`
		* `-dontwarn com.yandex.metrica.**`
* Исправлен **javadocs**.

Дополнительная информация
---------------------------

Также у этого проекта есть:

* [Документация на русском](http://api.yandex.ru/metrica-mobile-sdk/) и [на английском](http://api.yandex.com/metrica-mobile-sdk/), в которой содержится полная документация по **mobmetricalib** и описание подключения библиотеки к вашему проекту, а также инструкции по использованию.
* Различные версии библиотеки, их описание и их **java-docs** вы можете найти в другом репозитории [тут](https://github.com/yandexmobile/metrica-sdk-android).
* Зарегистрировать свое приложение можно на [Yandex.Metrica for Apps homepage](http://appmetrica.yandex.ru/).

Лицензия
---------

Лицензионное соглашение по использованию **Yandex.Metrica for Apps SDK** доступно по следующей ссылке [http://legal.yandex.ru/metrica_termsofuse/](http://legal.yandex.ru/metrica_termsofuse/).

