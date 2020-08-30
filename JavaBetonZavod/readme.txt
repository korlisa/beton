//CSV
//Создать продавца:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar csv Seller save 1 Petr 88003421234

//Создать новый заказ:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar csv Purchase save 1 23/2/19 12:00 1 1 1 Stairs
//Дозапись продукта ввод без id:
Кольцевая 100X100 23kg 233 1034r true 28
//Дозапись покупателя ввод без id:
Ivan Rostov gmail 89003002323

//Вывести информацию о заказе по дате и времени:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar csv Purchase get 23/2/19 12:00

//Вывести информацию о продавце по имени и номеру телефона
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar csv seller get Petr 88003421234

//Обновить информацию о продавце:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar csv Seller upd 1 Petr 88005555241

//Проверить наличие товара:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar csv Stairs check 1

//Удалить товар:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar  betonZavod.jar csv Stairs del 1


//XML
//Создать продавца:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar xml Seller save 1 Petr 88003421234

//Создать новый заказ:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar xml Purchase save 1 23/2/19 12:00 1 1 1 Stairs
//Дозапись продукта ввод без id:
Kolcevaya 100X100 23kg 233 1034r true 28
//Дозапись покупателя ввод без id:
Ivan Gorod gmail 89003002323

//Вывести информацию о заказе по дате и времени:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar xml Purchase get 23/2/19 12:00

//Проверить наличие товара:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar xml Stairs check 1

//Обновить информацию о продавце:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar xml Seller upd 1 Petr 88005555241

//Удалить товар:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar  betonZavod.jar xml Stairs del 1


//DB
//Создать продавца:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar db Seller save 2 Name PhoneNumber

//Создать новый заказ:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar db Purchase save 2 date time 2 2 2 Stairs
//Дозапись продукта ввод без id:
name volume 23kg 233 1034r true 28
//Дозапись покупателя ввод без id:
Ivan Gorod gmail 89003002323

//Вывести информацию о заказе по id:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar db Purchase get 2

//Проверить наличие товара:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar db Stairs check 2

//Обновить информацию о продавце:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar betonZavod.jar db Seller upd 2 Petr 88005555241

//Удалить товар:
java -Dlog4j2.configurationFile=log4j2.properties -Dconfig=config.properties -jar  betonZavod.jar db Stairs del 2