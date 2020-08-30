package ru.sfedu.betonZavod.Provider;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.betonZavod.EntityClasses.*;
import ru.sfedu.betonZavod.Constants.Result;
import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.utils.ConfigurationUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.sfedu.betonZavod.Constants.Constants.CSV;
import static ru.sfedu.betonZavod.Constants.Constants.POINT;
import static ru.sfedu.betonZavod.Constants.Status.FAIL;
import static ru.sfedu.betonZavod.Constants.Status.COMPLETE;

public class DataProviderCSV implements IDataProvider{

    private static Logger log = LogManager.getLogger(DataProviderCSV.class);


    @Override
    public Result saveRecordPurchase(Purchase bean) {
        List<Purchase> list = new ArrayList<>();
        long max = select(Purchase.class, TypeBeans.PURCHASE).size();
        bean.setId(max+1);
        list.add(bean);
        return execute(list, TypeBeans.PURCHASE, true);

    }

    @Override
    public Purchase getPurchaseById(long id) {
        return select(Purchase.class, TypeBeans.PURCHASE).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Purchase getPurchaseByDate(String date, String time) {
        return select(Purchase.class, TypeBeans.PURCHASE).stream().filter(l->l.getDate().equals(date) && l.getTime().equals(time)).findFirst().orElse(null);
    }

    @Override
    public Result saveRecordStairs(Stairs bean) {
        List<Stairs> beans = new ArrayList<>();
        if (getStairsById(bean.getId())==null) {
            beans.add(bean);
            return execute(beans, TypeBeans.STAIRS, true);
        } else  {
            return new Result(FAIL);
        }
    }

    @Override
    public Result saveRecordRoundWells(RoundWells bean) {
        List<RoundWells> beans = new ArrayList<>();
        if (getRoundWellsById(bean.getId())==null){
            beans.add(bean);
            return execute(beans, TypeBeans.ROUNDWELLS, true);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Result saveRecordBlocks(Blocks bean) {
        List<Blocks> beans = new ArrayList<>();
        if (getBlocksById(bean.getId())==null){
            beans.add(bean);
            return execute(beans, TypeBeans.BLOCKS, true);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Result saveRecordConcrete(Concrete bean) {
        List<Concrete> beans = new ArrayList<>();
        if (getConcreteById(bean.getId())==null){
            beans.add(bean);
            return execute(beans, TypeBeans.CONCRETE, true);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Product getRecordProductById(long id, TypeBeans type) {
        switch (type) {
            case ROUNDWELLS:
                return getRoundWellsById(id);
            case BLOCKS:
                return getBlocksById(id);
            case CONCRETE:
                return getConcreteById(id);
            case STAIRS:
                return getStairsById(id);
            default:
                return null;
        }
    }

    @Override
    public RoundWells getRoundWellsById(long id) {
        return select(RoundWells.class, TypeBeans.ROUNDWELLS).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Blocks getBlocksById(long id) {
        return select(Blocks.class, TypeBeans.BLOCKS).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Concrete getConcreteById(long id) {
        return select(Concrete.class, TypeBeans.CONCRETE).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Stairs getStairsById(long id) {
        return select(Stairs.class, TypeBeans.STAIRS).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Concrete getConcreteByName(String name, String volume) {
        return select(Concrete.class, TypeBeans.CONCRETE).stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public Blocks getBlocksByName(String name, String volume) {
        return select(Blocks.class, TypeBeans.BLOCKS).stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public RoundWells getRoundWellsByName(String name, String volume) {
        return select(RoundWells.class, TypeBeans.ROUNDWELLS).stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public Stairs getStairsByName(String name, String volume) {
        return select(Stairs.class, TypeBeans.STAIRS).stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public Result saveRecordBuyer(Buyer bean) {
        List<Buyer> beans = new ArrayList<>();
        if (getBuyerById(bean.getId())==null){
            beans.add(bean);
            return execute(beans, TypeBeans.BUYER, true);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Buyer getBuyerById(long id) {
        return select(Buyer.class, TypeBeans.BUYER).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Buyer getBuyerByName(String name, String phoneNumber) {
        return select(Buyer.class, TypeBeans.BUYER).stream().filter(l->l.getName().toLowerCase().equals(name.toLowerCase()) && l.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
    }

    @Override
    public Result updateBuyerById(Buyer bean) {
        if (getBuyerById(bean.getId()) != null) {
            List<Buyer> buyers = select(Buyer.class, TypeBeans.BUYER);
            buyers.removeIf(buyer -> buyer.getId() == bean.getId());
            buyers.add(bean);
            return execute(buyers, TypeBeans.BUYER, false);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Result delBuyerById(long id) {
        List<Buyer> list = select(Buyer.class, TypeBeans.BUYER);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.BUYER, false);
    }

    @Override
    public Result delRoundWellsById(long id) {
        List<RoundWells> list = select(RoundWells.class, TypeBeans.ROUNDWELLS);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.ROUNDWELLS, false);
    }

    @Override
    public Result delBlocksById(long id) {
        List<Blocks> list = select(Blocks.class, TypeBeans.BLOCKS);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.BLOCKS, false);
    }

    @Override
    public Result delConcreteById(long id) {
        List<Concrete> list = select(Concrete.class, TypeBeans.CONCRETE);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.CONCRETE, false);
    }

    @Override
    public Result delStairsById(long id) {
        List<Stairs> list = select(Stairs.class, TypeBeans.STAIRS);
        list.removeIf(l->l.getId()==id);
        return execute(list, TypeBeans.STAIRS, false);
    }

    @Override
    public Result saveRecordSeller(Seller bean) {
        List<Seller> list = new ArrayList<>();
        if (getSellerById(bean.getId()) == null) {
            list.add(bean);
            return execute(list, TypeBeans.SELLER, true);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Seller getSellerById(long id) {
        return select(Seller.class, TypeBeans.SELLER).stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Seller getSellerByName(String name, String phoneNumber) {
        return select(Seller.class, TypeBeans.SELLER).stream().filter(l->l.getName().toLowerCase().equals(name.toLowerCase()) && l.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
    }

    @Override
    public Result updateSellerById(Seller bean) {
        if (getSellerById(bean.getId()) != null) {
            List<Seller> sellers = select(Seller.class, TypeBeans.SELLER);
            sellers.removeIf(seller -> seller.getId() == bean.getId());
            sellers.add(bean);
            return execute(sellers, TypeBeans.SELLER, false);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Result delSellerById(long id) {
        List<Seller> list = select(Seller.class, TypeBeans.SELLER);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.SELLER, false);
    }

    @Override
    public boolean checkAvailability(long id, TypeBeans type) {
        return getRecordProductById(id, type).isAvailability();
    }

    public <T> Result execute (List<T> list, TypeBeans file, Boolean append) {
        try {
            String directory = ConfigurationUtil.getConfigurationEntry(CSV);
            String filePath = directory + file.toString()+POINT+CSV;

            FileWriter file_path = new FileWriter(filePath, append);
            CSVWriter writer = new CSVWriter(file_path);

            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withApplyQuotesToAll(false)
                    .build();
            beanToCsv.write(list);
            writer.close();
            return new Result(COMPLETE);
        } catch (Exception e) {
            log.error(e);
            return new Result(FAIL);
        }
    }

    private  <T> List<T> select(Class<T> clazz, TypeBeans file) {
        try {
            String directory = ConfigurationUtil.getConfigurationEntry(CSV);
            String filePath = directory + file.toString()+ POINT + CSV;

            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(csvReader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(clazz).build();
            List<T> list = csvToBean.parse();

            return list;
        } catch (Exception e) {
            log.error(e);
            return Collections.emptyList();
        }
    }



}
