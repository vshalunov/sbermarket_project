# Проект по автоматизации тестирования для [Сбермаркет](https://sbermarket.ru/)
<p align="center">
<img width="75%" title="Сбермаркет" src="images/logo/Sbermarket_logo.png">
</p>

## Покрытый функционал
### UI
- :white_check_mark: Отображение значения в выпадающем списке адресов на странице "Для себя"
- :white_check_mark: Отображение значений в подвале сайта на странице "Для себя"
- :white_check_mark: Отображение вспомогательного текста в модальных  окнах на странице "Для бизнеса"
- :white_check_mark: Отображение пунктов навигационной панели на странице "Для себя"
- :white_check_mark: Отсутствие ошибок в журнале консоли страниц "Для себя" и "Для бизнеса"

## Технологический стек
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TestOps.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Jira" src="images/logo/Jira.svg">
</p>

## <img width="5%" title="Jira" src="images/logo/ITerm2_v3_icon.png"> Запуск тестов из терминала
### Удаленный запуск тестов
```
gradle clean
-Dtask=${task}
-DremoteURL=${remoteURL}
-Dthreads=${THREADS}
```
### Параметры сборки
> <details>
> <summary><code>task</code> - список тестов, сгруппированных по параметру тега. В зависимости от выбранного параметра будут запускаться определенные группы тестов</summary>
>
> + test - запуск всех тестов
> + MainPageForBusiness - запускают тесты только с тегом "ForBusiness" (Страница "Для бизнеса")
> + MainPageForYourself - запускают тесты только с тегом "ForYourself" (Страница "Для себя")
> </details>
> 
> <code>remoteURL</code> - адрес удаленного сервера, на котором будут запускаться тесты
> 
> <code>threads</code> - количество потоков для запуска тестов

## <img width="5%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в Jenkins
### Для запуска тестов в Jenkins необходимо выполнить следующие шаги:
1. Открыть сборку [Jenkins](https://jenkins.autotests.cloud/job/09-zlw-qa-sbermarket-project)
2. Нажать на таск <code>"Собрать с параметрами"</code>
3. Указать [значения параметров](#параметры-сборки)
4. Нажать на кнопку <code>"Собрать"</code>
<p>
<img title="Jenkins parameters" src="images/screens/jenkins_parameters.png">
</p>

### Для формирования отчета о прохождении тестов в Allure Report необходимо выполнить следующий шаг:
5. После выполнения сборки нажать на любую ссылку/иконку <code>"Allure Report"</code>
<p>
<img title="Allure Report" src="images/screens/jenkins_allure_report.png">
</p>

### <img width="5%" title="Allure Report" src="images/logo/Allure_Report.svg"> Формирование отчета Allure
```
allure serve build/allure-results
```





