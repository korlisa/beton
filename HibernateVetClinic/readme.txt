//Лабораторная 2, создается TestEntity и подтягивает двух пользователей.
// вывод информации с таблицы TestEntity
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l2 gettestentity 1
// вывод первого пользователя
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l2 getfirstuser 1
// обновление записи
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l2 updatetestentity 1 updated
// удаление записи
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l2 deltestentity 1


// Лабораторная 3
// MappedSuperclass
// получение информации о mammals
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 ms mammals get 1
// обновление информации о birds
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 ms birds update 1 newname breed gender 9 4 true 3 birds
// удаление информации о reptiles
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 ms reptiles del 1

//TablePerClass
// обновление информации о mammals
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 tpc mammals update 8 newname breed gender 9 4 true 3 mammals
// получение информации о birds
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 tpc birds get 1
// удаление информации о reptiles
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 tpc reptiles del 12

//SingleTable
// удаление информации о mammals
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 st mammals del 8
// получение информации о birds
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 st birds get 1
// обновление информации о reptiles
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 st reptiles update 12 newname breed gender 9 4 true 3 reptiles

//JoinedTable
// обновление информации о mammals
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 jt mammals update 8 newname breed gender 9 4 true 3 mammals
// удаление информации о birds
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 jt birds del 1
// получение информации о reptiles
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l3 jt reptiles get 12

//Лабораторная 4, owner с разными типами отображения коллекций (list=address, set=phone, map=animal)
//CRUD методы
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l4 getowner 1
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l4 updateowner 1 updated updated updated 1 1 updated updated
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l4 delowner 1

//Лабораторная 5, one-to-one, many-to-one, many-to-many
//получение информации о owner
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l5 getowner 1
//получение информации о animal
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l5 getanimal 1
//получение информации о owner
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l5 getvisit 1
//вывод суммарной информации о всех животных определенного хозяина, с помощью запроса NativeSQL
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l5 getanimalbyowner 1 sql
//вывод информации о количестве животных определенного хозяина, с помощью запроса HQL
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l5 getnumofanimalbyowner 1 hql
//вывод информации о количестве животных определенного хозяина, с помощью запроса CRITERIA
java -Dhib=hibernate.cfg.xml -Dlog4j.configurationFile=log4j2.properties -jar vetClinicH.jar l5 getnumofanimalbyowner 1 criteria


