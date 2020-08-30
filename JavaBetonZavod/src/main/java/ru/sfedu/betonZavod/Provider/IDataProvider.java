package ru.sfedu.betonZavod.Provider;


import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.EntityClasses.*;
import ru.sfedu.betonZavod.Constants.Result;

public interface IDataProvider {

    //Создать заказ
    public Result saveRecordPurchase(Purchase bean);

    //Получить данные о заказе
    public Purchase getPurchaseById(long id);
    public Purchase getPurchaseByDate(String date, String time);


    // Добавить нового продукт (Лестницы, Колодцы, Блоки, Бетон)
    public Result saveRecordStairs(Stairs bean);
    public Result saveRecordRoundWells(RoundWells bean);
    public Result saveRecordBlocks(Blocks bean);
    public Result saveRecordConcrete(Concrete bean);

    // Вывести данные о продукте по id (Лестницы, Колодцы, Блоки, Бетон)
    public Product getRecordProductById(long id, TypeBeans type);
    public RoundWells getRoundWellsById(long id);
    public Blocks getBlocksById(long id);
    public Concrete getConcreteById(long id);
    public Stairs getStairsById(long id);

    // Вывести данные о продукте по имени и объему (Лестницы, Колодцы, Блоки, Бетон)

    public Concrete getConcreteByName(String name, String volume);
    public Blocks getBlocksByName(String name, String volume);
    public RoundWells getRoundWellsByName(String name, String volume);
    public Stairs getStairsByName(String name, String volume);

    // Добавить данные о покупателе
    public Result saveRecordBuyer(Buyer bean);

    //Получить данные о покупателе
    public Buyer getBuyerById(long id);
    public Buyer getBuyerByName(String name, String phoneNumber);

    //Обновить данные о покупателе
    public Result updateBuyerById(Buyer bean);

    // Удалить данные о покупателе
    public Result delBuyerById(long id);

    //Списать товар (Лестницы, Колодцы, Блоки, Бетон)
    public Result delRoundWellsById(long id);
    public Result delBlocksById(long id);
    public Result delConcreteById(long id);
    public Result delStairsById(long id);

    //Добавить продавца
    public Result saveRecordSeller(Seller bean);

    //Вывести информацию о продавце
    public Seller getSellerById(long id);
    public Seller getSellerByName(String name, String phoneNumber);

    //Обновить данные о продавце
    public Result updateSellerById(Seller bean);

    //Уволить продавца
    public Result delSellerById(long id);

    //Проверить наличие товара
    public boolean checkAvailability(long id, TypeBeans type);
}
