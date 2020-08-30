package ru.sfedu.betonZavod.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.betonZavod.Constants.Constants;
import ru.sfedu.betonZavod.Constants.Result;
import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.EntityClasses.*;
import ru.sfedu.betonZavod.utils.ConfigurationUtil;
import ru.sfedu.betonZavod.utils.Cover;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.sfedu.betonZavod.Constants.Constants.POINT;
import static ru.sfedu.betonZavod.Constants.Status.FAIL;
import static ru.sfedu.betonZavod.Constants.Status.COMPLETE;

public class DataProviderXML implements IDataProvider{

    private static Logger log = LogManager.getLogger(DataProviderCSV.class);


    @Override
    public Result saveRecordPurchase(Purchase bean) {
        List<Purchase> list = new ArrayList<>();
        long max = select(TypeBeans.PURCHASE).size();
        bean.setId(max+1);
        list.add(bean);
        return execute(list, TypeBeans.PURCHASE, true);
    }

    @Override
    public Purchase getPurchaseById(long id) {
        List<Purchase> list = select(TypeBeans.PURCHASE);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);

    }

    @Override
    public Purchase getPurchaseByDate(String date, String time) {
        List<Purchase> list = select(TypeBeans.PURCHASE);
        return list.stream().filter(l->l.getDate().equals(date) && l.getTime().equals(time)).findFirst().orElse(null);
    }

    @Override
    public Result saveRecordStairs(Stairs bean) {
        List<Stairs> beans = new ArrayList<>();
        if (getStairsById(bean.getId())==null){
            beans.add(bean);
            return execute(beans, TypeBeans.STAIRS, true);
        } else {
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
        List<RoundWells> list = select(TypeBeans.ROUNDWELLS);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Blocks getBlocksById(long id) {
        List<Blocks> list = select(TypeBeans.BLOCKS);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Concrete getConcreteById(long id) {
        List<Concrete> list = select(TypeBeans.CONCRETE);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Stairs getStairsById(long id) {
        List<Stairs> list = select(TypeBeans.STAIRS);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Concrete getConcreteByName(String name, String volume) {
        List<Concrete> list = select(TypeBeans.CONCRETE);
        return list.stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase()
                .equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public Blocks getBlocksByName(String name, String volume) {
        List<Blocks> list = select(TypeBeans.BLOCKS);
        return list.stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase()
                .equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public RoundWells getRoundWellsByName(String name, String volume) {
        List<RoundWells> list = select(TypeBeans.ROUNDWELLS);
        return list.stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase()
                .equals(name.toLowerCase())).findFirst().orElse(null);
    }

    @Override
    public Stairs getStairsByName(String name, String volume) {
        List<Stairs> list = select(TypeBeans.STAIRS);
        return list.stream().filter(l->l.getVolume()==volume && l.getName().toLowerCase()
                .equals(name.toLowerCase())).findFirst().orElse(null);

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
        List<Buyer> list = select(TypeBeans.BUYER);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Buyer getBuyerByName(String name, String phoneNumber) {
        List<Buyer> list = select(TypeBeans.BUYER);
        return list.stream().filter(l->l.getName().toLowerCase().equals(name.toLowerCase())
                && l.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);

    }

    @Override
    public Result updateBuyerById(Buyer bean) {
        return null;
    }

    @Override
    public Result delBuyerById(long id) {
        List<Buyer> list = select(TypeBeans.BUYER);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.BUYER, false);
    }

    @Override
    public Result delRoundWellsById(long id) {
        List<RoundWells> list = select(TypeBeans.ROUNDWELLS);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.ROUNDWELLS, false);
    }

    @Override
    public Result delBlocksById(long id) {
        List<Blocks> list = select(TypeBeans.BLOCKS);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.BLOCKS, false);
    }

    @Override
    public Result delConcreteById(long id) {
        List<Concrete> list = select(TypeBeans.CONCRETE);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.CONCRETE, false);
    }

    @Override
    public Result delStairsById(long id) {
        List<Stairs> list = select(TypeBeans.STAIRS);
        list.removeIf(l->l.getId() == id);
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
        List<Seller> list = select(TypeBeans.SELLER);
        return list.stream().filter(l->l.getId()==id).findFirst().orElse(null);
    }

    @Override
    public Seller getSellerByName(String name, String phoneNumber) {
        List<Seller> list = select(TypeBeans.SELLER);
        return list.stream().filter(l->l.getName().toLowerCase().equals(name.toLowerCase())
                && l.getPhoneNumber().equals(phoneNumber)).findFirst().orElse(null);
    }

    @Override
    public Result updateSellerById(Seller bean) {
        if (getSellerById(bean.getId()) != null) {
            List<Seller> sellers = select(TypeBeans.SELLER);
            sellers.removeIf(vet -> vet.getId() == bean.getId());
            sellers.add(bean);
            return execute(sellers, TypeBeans.SELLER, false);
        } else {
            return new Result(FAIL);
        }
    }

    @Override
    public Result delSellerById(long id) {
        List<Seller> list = select(TypeBeans.SELLER);
        list.removeIf(l->l.getId() == id);
        return execute(list, TypeBeans.SELLER, false);
    }

    @Override
    public boolean checkAvailability(long id, TypeBeans type) {
        return getRecordProductById(id, type).isAvailability();
    }

    public <T> Result execute(List<T> list, TypeBeans file, Boolean append) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            String directory = ConfigurationUtil.getConfigurationEntry(Constants.XML);
            String filePath = directory + file.toString() + POINT + Constants.XML;

            if (append == true) {
                arrayList.addAll(select(file));
            }
            arrayList.addAll(list);

            FileWriter writer = new FileWriter(filePath);
            Serializer serializer = new Persister();

            Cover<T> xml = new Cover<T>(arrayList);

            serializer.write(xml, writer);
            return new Result(COMPLETE);
        } catch (Exception e) {
            log.error(e);
            return new Result(FAIL);
        }
    }

    private <T> List<T> select(TypeBeans file) {
        try {
            String directory = ConfigurationUtil.getConfigurationEntry(Constants.XML);
            String filePath = directory + file.toString() + POINT + Constants.XML;

            Reader reader = new FileReader(filePath);
            Serializer serializer = new Persister();

            Cover xml = serializer.read(Cover.class, reader);
            if (xml.getList() == null) xml.setList(Collections.emptyList());
            return xml.getList();
        } catch (Exception e) {
            log.error(e);
            return Collections.emptyList();
        }
    }
}
