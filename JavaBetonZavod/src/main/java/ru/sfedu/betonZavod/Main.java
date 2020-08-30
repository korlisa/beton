package ru.sfedu.betonZavod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.EntityClasses.*;
import ru.sfedu.betonZavod.Provider.DataProviderCSV;
import ru.sfedu.betonZavod.Provider.DataProviderJDBC;
import ru.sfedu.betonZavod.Provider.DataProviderXML;
import ru.sfedu.betonZavod.Provider.IDataProvider;

import java.util.Scanner;

import static ru.sfedu.betonZavod.Constants.Constants.*;
import static ru.sfedu.betonZavod.Constants.Status.FAIL;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class);
    public static String CONFIG_PATH = System.getProperty(CU_KEY, DEFAULT_CONFIG_PATH);

    public static void main(String[] args) {
        IDataProvider iDataProvider = null;
        try {
            if (args.length < 3) {
                log.error("");
                throw new Exception();
            }
            iDataProvider = initDataSource(args[0]);
            assert iDataProvider != null;
            log.info(generic(iDataProvider, args));
        } catch (Exception e) {
            log.error(e);
        }
    }

    private static IDataProvider initDataSource(String value) {
        switch (value.toLowerCase()) {
            case CSV:
                return new DataProviderCSV();
            case XML:
                return new DataProviderXML();
            case DB:
                return new DataProviderJDBC();
            default:
                return null;
        }
    }

    private static String generic(IDataProvider iDataProvider, String[] args) {
        switch (args[1].toLowerCase()) {
            case CONCRETE:
                return concrete(iDataProvider, args);
            case STAIRS:
                return stairs(iDataProvider, args);
            case ROUNDWELLS:
                return roundwells(iDataProvider, args);
            case BLOCKS:
                return blocks(iDataProvider, args);
            case SELLER:
                return seller(iDataProvider, args);
            case BUYER:
                return buyer(iDataProvider, args);
            case PURCHASE:
                return purchase(iDataProvider, args);
            default:
                return FAIL.toString();
        }
    }

    private static String seller(IDataProvider iDataProvider, String[] args) {
        try {
            switch (args[2].toLowerCase()) {
                // csv seller save 1 Vladislav 89272345434
                case SAVE:
                    assert args.length != 6;
                    Seller seller = new Seller();
                    seller.setId(Long.parseLong(args[3]));
                    seller.setName(args[4]);
                    seller.setPhoneNumber(args[5]);
                    return iDataProvider.saveRecordSeller(seller).getStatus().toString();
                // csv seller get 1
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getSellerById(Long.parseLong(args[3])).toString();
                    }
                 // csv seller get Vladislav 89272345434
                    if (args.length == 5) {
                        return iDataProvider.getSellerByName(args[3], args[4]).toString();
                    }
                    break;
                // csv seller del 1
                case DEL:
                    return iDataProvider.delSellerById(Long.parseLong(args[3])).getStatus().toString();
                //csv seller upd 1 VladislavAleks 89272345434
                case UPD:
                    assert args.length != 6;
                    Seller seller1 = new Seller();
                    seller1.setId(Long.parseLong(args[3]));
                    seller1.setName(args[4]);
                    seller1.setPhoneNumber(args[5]);
                    return iDataProvider.updateSellerById(seller1).getStatus().toString();

            }
        } catch (Exception e) {
            log.error(e);
        }
        return FAIL.toString();
    }

    private static String buyer(IDataProvider iDataProvider, String args[]) {
        try {
            switch (args[2].toLowerCase()) {
                // csv buyer save 1 Ivan Pushkina gmail@gmail.com 89342453212
                case SAVE:
                    assert args.length != 8;
                    Buyer buyer = new Buyer();
                    buyer.setId(Long.parseLong(args[3]));
                    buyer.setName(args[4]);
                    buyer.setAddress(args[5]);
                    buyer.setEmail(args[6]);
                    buyer.setPhoneNumber(args[7]);
                    return iDataProvider.saveRecordBuyer(buyer).getStatus().toString();
                // csv buyer get 1
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getBuyerById(Long.parseLong(args[3])).toString();
                    }
                // csv buyer get Ivan 89342453212
                    if (args.length == 5) {
                        return iDataProvider.getSellerByName(args[3], args[4]).toString();
                    }
                    break;
                // csv buyer del 1
                case DEL:
                    return iDataProvider.delBuyerById(Long.parseLong(args[3])).getStatus().toString();
                // csv buyer upd 1 IvanPetrovich Pushkina25 gmail@gmail.com 89342453212
                case UPD:
                    assert args.length != 8;
                    Buyer buyer1 = new Buyer();
                    buyer1.setId(Long.parseLong(args[3]));
                    buyer1.setName(args[4]);
                    buyer1.setAddress(args[5]);
                    buyer1.setEmail(args[6]);
                    buyer1.setPhoneNumber(args[7]);
                    return iDataProvider.updateBuyerById(buyer1).getStatus().toString();
            }
        } catch (Exception e) {
            log.error(e);
        }
        return FAIL.toString();
    }

    private static String concrete(IDataProvider iDataProvider, String[] args) {
        try {
            switch (args[2].toLowerCase()) {
                case SAVE:
                    assert args.length != 11;
                    Concrete concrete = new Concrete();
                    concrete.setId(Long.parseLong(args[3]));
                    concrete.setName(args[4]);
                    concrete.setVolume(args[5]);
                    concrete.setWeight(args[6]);
                    concrete.setDimension(args[7]);
                    concrete.setPrice(args[8]);
                    concrete.setAvailability(Boolean.parseBoolean(args[9]));
                    concrete.setGrade(args[10]);
                    return iDataProvider.saveRecordConcrete(concrete).getStatus().toString();
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getConcreteById(Long.parseLong(args[3])).toString();
                    }
                    if (args.length == 5) {
                        return iDataProvider.getConcreteByName(args[3], args[4]).toString();
                    }
                    break;
                case DEL:
                    return iDataProvider.delConcreteById(Long.parseLong(args[3])).getStatus().toString();
                case CHECK:
                    return String.valueOf(iDataProvider.checkAvailability(Long.parseLong(args[3]), TypeBeans.CONCRETE));
            }
        } catch (Exception e) {
            log.error(e);
            return FAIL.toString();
        }
        return FAIL.toString();
    }
    private static String stairs(IDataProvider iDataProvider, String[] args) {
        try {
            switch (args[2].toLowerCase()) {
                // csv stairs save 1 Lestnica 23,3 25 1 33ryb true 32
                case SAVE:
                    assert args.length != 11;
                    Stairs stairs = new Stairs();
                    stairs.setId(Long.parseLong(args[3]));
                    stairs.setName(args[4]);
                    stairs.setVolume(args[5]);
                    stairs.setWeight(args[6]);
                    stairs.setDimension(args[7]);
                    stairs.setPrice(args[8]);
                    stairs.setAvailability(Boolean.parseBoolean(args[9]));
                    stairs.setNumberOfSteps(Integer.parseInt(args[10]));
                    return iDataProvider.saveRecordStairs(stairs).getStatus().toString();
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getStairsById(Long.parseLong(args[3])).toString();
                    }
                    if (args.length == 5) {
                        return iDataProvider.getStairsByName(args[3], args[4]).toString();
                    }
                    break;
                case DEL:
                    return iDataProvider.delStairsById(Long.parseLong(args[3])).getStatus().toString();
                case CHECK:
                    return String.valueOf(iDataProvider.checkAvailability(Long.parseLong(args[3]), TypeBeans.STAIRS));
            }
        } catch (Exception e) {
            log.error(e);
            return FAIL.toString();
        }
        return FAIL.toString();
    }
    private static String roundwells(IDataProvider iDataProvider, String[] args) {
        try {
            switch (args[2].toLowerCase()) {
                case SAVE:
                    assert args.length != 11;
                    RoundWells roundWells = new RoundWells();
                    roundWells.setId(Long.parseLong(args[3]));
                    roundWells.setName(args[4]);
                    roundWells.setVolume(args[5]);
                    roundWells.setWeight(args[6]);
                    roundWells.setDimension(args[7]);
                    roundWells.setPrice(args[8]);
                    roundWells.setAvailability(Boolean.parseBoolean(args[9]));
                    roundWells.setDiameter(Float.parseFloat(args[10]));
                    return iDataProvider.saveRecordRoundWells(roundWells).getStatus().toString();
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getRoundWellsById(Long.parseLong(args[3])).toString();
                    }
                    if (args.length == 5) {
                        return iDataProvider.getRoundWellsByName(args[3], args[4]).toString();
                    }
                    break;
                case DEL:
                    return iDataProvider.delRoundWellsById(Long.parseLong(args[3])).getStatus().toString();
                case CHECK:
                    return String.valueOf(iDataProvider.checkAvailability(Long.parseLong(args[3]), TypeBeans.ROUNDWELLS));
            }
        } catch (Exception e) {
            log.error(e);
            return FAIL.toString();
        }
        return FAIL.toString();
    }
    private static String blocks(IDataProvider iDataProvider, String[] args) {
        try {
            switch (args[2].toLowerCase()) {
                case SAVE:
                    assert args.length != 11;
                    Blocks blocks = new Blocks();
                    blocks.setId(Long.parseLong(args[3]));
                    blocks.setName(args[4]);
                    blocks.setVolume(args[5]);
                    blocks.setWeight(args[6]);
                    blocks.setDimension(args[7]);
                    blocks.setPrice(args[8]);
                    blocks.setAvailability(Boolean.parseBoolean(args[9]));
                    blocks.setMetalCarcase(Boolean.parseBoolean(args[10]));
                    return iDataProvider.saveRecordBlocks(blocks).getStatus().toString();
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getBlocksById(Long.parseLong(args[3])).toString();
                    }
                    if (args.length == 5) {
                        return iDataProvider.getBlocksByName(args[3], args[4]).toString();
                    }
                    break;
                case DEL:
                    return iDataProvider.delBlocksById(Long.parseLong(args[3])).getStatus().toString();
                case CHECK:
                    return String.valueOf(iDataProvider.checkAvailability(Long.parseLong(args[3]), TypeBeans.BLOCKS));
            }
        } catch (Exception e) {
            log.error(e);
            return FAIL.toString();
        }
        return FAIL.toString();
    }
    private static String purchase(IDataProvider iDataProvider, String[] args) {
        try {
            switch (args[2].toLowerCase()) {
                // csv purchase save 7 23/01/2020 1600 2 2 1 stairs
                case SAVE:
                    assert args.length != 10;
                    Purchase purchase = new Purchase();
                    purchase.setId(Long.parseLong(args[3]));
                    purchase.setDate(args[4]);
                    purchase.setTime(args[5]);
                    if (iDataProvider.getSellerById(Long.parseLong(args[8])) == null) {
                        return NOT_SELLER;
                    }
                    if (iDataProvider.getRecordProductById(Long.parseLong(args[6]), TypeBeans.valueOf(args[9].toUpperCase())) == null) {
                        log.info(args[9] + SPACE + NOT_EXIST_ENTRY);
                        String row = args[0] + SPACE + args[9] + _SAVE_ + args[6] + SPACE + new Scanner(System.in).nextLine();
                        if (generic(iDataProvider, row.split(SPACE)).equals(FAIL.toString())) {
                            return FAIL.toString();
                        }
                    }
                    purchase.setProduct(iDataProvider.getRecordProductById(Long.parseLong(args[6]), TypeBeans.valueOf(args[9].toUpperCase())));
                    if (iDataProvider.getBuyerById(Long.parseLong(args[7])) == null) {
                        log.info(BUYER + SPACE + NOT_EXIST_ENTRY);
                        String row = args[0] + BUYER_SAVE + args[7] + SPACE + new Scanner(System.in).nextLine();
                        if (generic(iDataProvider, row.split(SPACE)).equals(FAIL.toString())) {
                            return FAIL.toString();
                        }
                    }
                    purchase.setBuyer(iDataProvider.getBuyerById(Long.parseLong(args[7])));
                    purchase.setSeller(iDataProvider.getSellerById(Long.parseLong(args[8])));
                    purchase.setTypeProduct(TypeBeans.valueOf(args[9].toUpperCase()).toString());
                    return iDataProvider.saveRecordPurchase(purchase).getStatus().toString();
                case GET:
                    if (args.length == 4) {
                        return iDataProvider.getPurchaseById(Long.parseLong(args[3])).toString();
                    }
                    if (args.length == 5) {
                        return iDataProvider.getPurchaseByDate(args[3], args[4]).toString();
                    }
                    break;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return FAIL.toString();
    }
}
