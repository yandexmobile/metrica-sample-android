Usage example of **Yandex.Metrica for Android Apps**.

How to start
------------

*  Clone repository: git clone https://github.com/yandexmobile/metrica-sample-android.git.
*  The sample was created by **IntelliJ IDEA**, so just import it to your favorite **IDE**. 
*  In the folder with name **"libs"** you can find **mobmetricalib** library. In this particular case the library **mobmetricalib** doesn't contain within itself **protobuf** library, which is necessary for it to work, therefore the  **protobuf** library lies near.
> The **mobmetricalib** library is available with **protobuf** library within itself. In this case in your project shouldn't be the **protobuf** library.
* Check the settings of **metrica-sample-android** project, that the both libraries (**mobmetricalib**, **protobuf**) are added to dependencies.
*  Now we are ready to launch project!

Notes
-------------------------------

* The **mobmetricalib** library has the version `1.0` and the level of **API** `1`.  Thus in the **AndroidManifest.xml** you can see that the **metrica:api:level** value is equal to **1**.
* The example uses **API_KEY** equal to `1111`. The key is specified in the **AndroidManifest.xml** file, but we can do it programmatically.

* Alternatively you can add Metrica for Apps to your project as maven artifact. 
Maven central:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib


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
* В папке **libs** уже находится библиотека **mobmetricalib**. В данном тестовом проекте библиотека **mobmetricalib** не содержит внутри себя библиотеку **protobuf**, которая нужна ей для работы, поэтому в папке **libs** также уже содержится библиотека **protobuf**.
> Библиотека **mobmetricalib** доступна и с включенной в нее библиотекой **protobuf**. В таком случае подключать **protobuf** не нужно.
* Проверьте в настройках проекта **metrica-sample-android**, что в зависимостях подключены обе библиотеки (**mobmetricalib**, **protobuf**).
*  Всё готово к запуску тестового проекта.

Примечания к примеру
-------------------------------

* Данный пример использует библиотеку **mobmetricalib** версии `1.0` и уровнем **API** равным `1`. Поэтому в файле **AndroidManifest.xml** вы можете увидеть, что значение **metrica:api:level** равно **1**.
* В примере используется тестовый **API_KEY** равный `1111`. В данном примере ключ указывается прямо внутри **AndroidManifest.xml**, но его можно устанавливать и программно.

* Метрику для приложений можно добавить в проект и как maven-артефакт с maven-central:

    * **groupId**: com.yandex.android
    * **artifactId**: mobmetricalib


Дополнительная информация
---------------------------

Также у этого проекта есть:

* [Документация на русском](http://api.yandex.ru/metrica-mobile-sdk/) и [на английском](http://api.yandex.com/metrica-mobile-sdk/), в которой содержится полная документация по **mobmetricalib** и описание подключения библиотеки к вашему проекту, а также инструкции по использованию.
* Различные версии библиотеки, их описание и их **java-docs** вы можете найти в другом репозитории [тут](https://github.com/yandexmobile/metrica-sdk-android).
* Зарегистрировать свое приложение можно на [Yandex.Metrica for Apps homepage](http://appmetrica.yandex.ru/).

Лицензия
---------

Лицензионное соглашение по использованию **Yandex.Metrica for Apps SDK** доступно по следующей ссылке [http://legal.yandex.ru/metrica_termsofuse/](http://legal.yandex.ru/metrica_termsofuse/).

