# color note
![This is an image](/design/icons/Java.png)![This is an image](/design/icons/Gradle.png)![This is an image](/design/icons/Intelij_IDEA.png)![This is an image](/design/icons/Selenide.png)![This is an image](/design/icons/Selenoid.png)![This is an image](/design/icons/JUnit5.png)![This is an image](/design/icons/Allure_Report.png)![This is an image](/design/icons/AllureTestOps.png)![This is an image](/design/icons/appium.png) ![This is an image](/design/icons/androidstudio.png)
## Описание проекта
Учебный проект реализации автотестирования мобильного приложения.<br/></br>
В качестве объекта тестирование выбрано мобильное приложение приложение для учета личных заметок **Color-note**.<br/></br>
ColorNote — это простой блокнот. Он предоставляет возможность легкого и простого пользования блокнотом при написании заметок, напоминаний, email, сообщений, перечней дел и покупок.
<br/></br>
<a target="_blank" href="https://play.google.com/store/apps/details?id=com.socialnmobile.dictapps.notepad.color.note"> Подробнее о приложении по ссылке</a></br>
<img src="/design/images/page1.png" wight=70px heigth=100px> <img src="/design/images/page2.png" wight=70px heigth=100px> </br>
<img src="/design/images/page4.png" wight=70px heigth=100px> <img src="/design/images/page5.png" wight=70px heigth=100px> </br>

#### Особенности реализации тестового проекта
Были созданы тест-кейсы в Allure Test Ops для дальнейшей автоматизации.<br/></br>
Для описания шагов тест-кейсов в java-коде использован степовой подход.<br/></br>
Реализована возможность настройки параметров запуска через Jenkins

## Список проверок
#### Список проверок, реализованных в автотестах
- [x] Проверка экранов Onboarding
- [x] Проверка экрана создания записки
- [x] Проверка меню More
- [x] Проверка экрана смены тем
- [x] Проверка экрана Поиска
- [x] Проверка экрана Настроек
- [x] Проверка добавления создания записки
- [x] Проверка Туториала
- [x] Проверка создания чек-листа
- [x] Проверка экрана Архив
- [x] Проверка экрана Корзины
- [x] Проверка календаря
- [x] Проверка сортировки
- [x] Проверка меню
- [x] Проверка экрана Цвета

## Ограничения проекта
Файл apk взят из открытого источника. Приложение установлено на сервер Browserstack. <br/>
Также реализован локальный прогон тестов.

#### Пример запуска из командной строки
```bash
gradle clean local
```

## Этапы реализации

### 1. Формирование тест-кейсов в Allure Test Ops
<img src="/design/images/manual_list.png"><br/></br>

### 2. Структура проекта
- Папка **Config** - конфигурационные файлы
- Папка **Drivers** - разработанные драйверы, необходимые для запуска тестов
- Папка **Helpers** - файлы для выбора девайса, прикрепления результатов выполнения тестов
- Папка **Tests** - файлы с тестами
- Папка **apk** - файл с тестируемым приложением

<img src="/design/images/str.png" wight=70px heigth=100px>

### 3. Настройка сборки
<a target="_blank" href="https://jenkins.autotests.cloud/job/10-azavrichko-diplom_mobile"> Ссылка на сборку в Jenkins</a><br/><br/> 
<img src="/design/images/jenkins.png" wight=70px heigth=100px>


### 4. Результат выполнения
Итоговые результаты сгруппированы в Dashboard для удоства локализации дефектов по основным функциям приложения.<br/><br/>  
<img src="/design/images/dashboard1.png">
<img src="/design/images/dashboard2.png">

### Пример видеозаписи прохождения теста на эмуляторе мобильного устройства
![This is an image](/design/images/mobile_test.gif)

### Пример выполнения теста в **Browserstack**
<img src="/design/images/browserstack.png">

### Пример результата теста в **Allure Report**
<img src="/design/images/allureReport.png">

### Пример результатов теста в **Allure Report** по времени
<img src="/design/images/time.png">

### 5. Оповещения
После выполнения тестов, приходят оповещения в **telegram** <br/></br>
<img src="/design/images/telegram.png">


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>