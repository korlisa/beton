package ru.sfedu.betonZavod.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.betonZavod.Constants.Result;
import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.EntityClasses.*;

import java.io.IOException;
import java.sql.*;

import static ru.sfedu.betonZavod.Constants.Constants.*;
import static ru.sfedu.betonZavod.Constants.Status.FAIL;
import static ru.sfedu.betonZavod.Constants.Status.COMPLETE;
import static ru.sfedu.betonZavod.utils.ConfigurationUtil.getConfigurationEntry;


public class DataProviderJDBC implements IDataProvider {
    private static Logger log = LogManager.getLogger(DataProviderJDBC.class);


    @Override
    public Result saveRecordPurchase(Purchase bean) {
        return execute(String.format(INSERT_PURCHASE,
                bean.getId(), bean.getDate(), bean.getTime(), bean.getProduct().getId(),
                bean.getBuyer().getId(), bean.getSeller().getId(), bean.getTypeProduct()));

    }

    @Override
    public Purchase getPurchaseById(long id) {
        try {
            ResultSet resultSet = select(String.format(SELECT_PURCHASE, id));

            if (resultSet != null && resultSet.next()) {
                Purchase purchase = new Purchase();

                purchase.setId(resultSet.getLong(PURCHASE_ID));
                purchase.setDate(resultSet.getString(PURCHASE_DATE));
                purchase.setTime(resultSet.getString(PURCHASE_TIME));
                purchase.setProduct(getRecordProductById(resultSet.getInt(PURCHASE_ID_PRODUCT), TypeBeans.valueOf(resultSet.getString(PURCHASE_TYPE_PRODUCT))));
                purchase.setBuyer(getBuyerById(resultSet.getInt(PURCHASE_ID_BUYER)));
                purchase.setSeller(getSellerById(resultSet.getInt(PURCHASE_ID_SELLER)));
                purchase.setTypeProduct(resultSet.getString(PURCHASE_TYPE_PRODUCT));

                return purchase;
            }
        } catch (Exception e){
            log.error(e);
        }
        return null;
    }

    @Override
    public Purchase getPurchaseByDate(String date, String time) {
        try {
            ResultSet resultSet = select(String.format(SELECT_PURCHASE_BY_DATE, date, time));

            if (resultSet != null && resultSet.next()) {
                Purchase purchase = new Purchase();

                purchase.setId(resultSet.getLong(PURCHASE_ID));
                purchase.setDate(resultSet.getString(PURCHASE_DATE));
                purchase.setTime(resultSet.getString(PURCHASE_TIME));
                purchase.setProduct(getRecordProductById(resultSet.getInt(PURCHASE_ID_PRODUCT), TypeBeans.valueOf(resultSet.getString(PURCHASE_TYPE_PRODUCT))));
                purchase.setBuyer(getBuyerById(resultSet.getInt(PURCHASE_ID_BUYER)));
                purchase.setSeller(getSellerById(resultSet.getInt(PURCHASE_ID_SELLER)));
                purchase.setTypeProduct(resultSet.getString(PURCHASE_TYPE_PRODUCT));

                return purchase;
            }
        } catch (Exception e){
            log.error(e);
        }
        return null;
    }

    @Override
    public Result saveRecordStairs(Stairs bean) {
        return  execute(String.format(INSERT_STAIRS, bean.getId(), bean.getName(), bean.getVolume(),
                bean.getWeight(), bean.getDimension(), bean.getPrice(),bean.isAvailability(), bean.getNumberOfSteps()));
    }

    @Override
    public Result saveRecordRoundWells(RoundWells bean) {
        return execute(String.format(INSERT_ROUNDWELLS, bean.getId(), bean.getName(), bean.getVolume(),
                bean.getWeight(), bean.getDimension(), bean.getPrice(), bean.isAvailability(), bean.getDiameter()));
    }

    @Override
    public Result saveRecordBlocks(Blocks bean) {
        return execute(String.format(INSERT_BLOCKS, bean.getId(), bean.getName(), bean.getVolume(),
                bean.getWeight(), bean.getDimension(), bean.getPrice(), bean.isAvailability(), bean.isMetalCarcase()));
    }

    @Override
    public Result saveRecordConcrete(Concrete bean) {
        return execute(String.format(INSERT_CONCRETE, bean.getId(), bean.getName(), bean.getVolume(),
                bean.getWeight(), bean.getDimension(), bean.getPrice(), bean.isAvailability(), bean.getGrade()));
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
        try {
            ResultSet res = select(String.format(SELECT_ROUNDWELLS, id));
            if (res!=null && res.next()) {
                RoundWells roundWells = new RoundWells();
                roundWells.setId(res.getLong(ROUNDWELLS_ID));
                roundWells.setName(res.getString(ROUNDWELLS_NAME));
                roundWells.setVolume(res.getString(ROUNDWELLS_VOLUME));
                roundWells.setWeight(res.getString(ROUNDWELLS_WEIGHT));
                roundWells.setDimension(res.getString(ROUNDWELLS_DIMENSION));
                roundWells.setPrice(res.getString(ROUNDWELLS_PRICE));
                roundWells.setAvailability(res.getBoolean(ROUNDWELLS_AVAILABILITY));
                roundWells.setDiameter(res.getFloat(ROUNDWELLS_DIAMETER));

                return roundWells;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Blocks getBlocksById(long id) {
        try {
            ResultSet res = select(String.format(SELECT_BLOCKS, id));
            if (res!=null && res.next()) {
                Blocks blocks = new Blocks();
                blocks.setId(res.getLong(BLOCKS_ID));
                blocks.setName(res.getString(BLOCKS_NAME));
                blocks.setVolume(res.getString(BLOCKS_VOLUME));
                blocks.setWeight(res.getString(BLOCKS_WEIGHT));
                blocks.setDimension(res.getString(BLOCKS_DIMENSION));
                blocks.setPrice(res.getString(BLOCKS_PRICE));
                blocks.setAvailability(res.getBoolean(BLOCKS_AVAILABILITY));
                blocks.setMetalCarcase(res.getBoolean(BLOCKS_METALCARCASE));

                return blocks;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Concrete getConcreteById(long id) {
        try {
            ResultSet res = select(String.format(SELECT_CONCRETE, id));
            if (res!=null && res.next()) {
                Concrete concrete = new Concrete();
                concrete.setId(res.getLong(CONCRETE_ID));
                concrete.setName(res.getString(CONCRETE_NAME));
                concrete.setVolume(res.getString(CONCRETE_VOLUME));
                concrete.setWeight(res.getString(CONCRETE_WEIGHT));
                concrete.setDimension(res.getString(CONCRETE_DIMENSION));
                concrete.setPrice(res.getString(CONCRETE_PRICE));
                concrete.setAvailability(res.getBoolean(CONCRETE_AVAILABILITY));
                concrete.setGrade(res.getString(CONCRETE_GRADE));
                return concrete;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Stairs getStairsById(long id) {
        try {
            ResultSet res = select(String.format(SELECT_STAIRS, id));
            if (res!=null && res.next()) {
                Stairs stairs = new Stairs();
                stairs.setId(res.getLong(STARS_ID));
                stairs.setName(res.getString(STARS_NAME));
                stairs.setVolume(res.getString(STARS_VOLUME));
                stairs.setWeight(res.getString(STARS_WEIGHT));
                stairs.setDimension(res.getString(STARS_DIMENSION));
                stairs.setPrice(res.getString(STARS_PRICE));
                stairs.setAvailability(res.getBoolean(STARS_AVAILABILITY));
                stairs.setNumberOfSteps(res.getInt(STARS_NUMBEROFSTEPS));

                return stairs;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Concrete getConcreteByName(String name, String volume) {
        try {
            ResultSet res = select(String.format(SELECT_CONCRETE_BY_NAME, name, volume));
            if (res!=null && res.next()) {
                Concrete concrete = new Concrete();
                concrete.setId(res.getLong(CONCRETE_ID));
                concrete.setName(res.getString(CONCRETE_NAME));
                concrete.setVolume(res.getString(CONCRETE_VOLUME));
                concrete.setWeight(res.getString(CONCRETE_WEIGHT));
                concrete.setDimension(res.getString(CONCRETE_DIMENSION));
                concrete.setPrice(res.getString(CONCRETE_PRICE));
                concrete.setAvailability(res.getBoolean(CONCRETE_AVAILABILITY));
                concrete.setGrade(res.getString(CONCRETE_GRADE));
                return concrete;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Blocks getBlocksByName(String name, String volume) {
        try {
            ResultSet res = select(String.format(SELECT_BLOCKS_BY_NAME, name, volume));
            if (res != null && res.next()) {
                Blocks blocks = new Blocks();
                blocks.setId(res.getLong(BLOCKS_ID));
                blocks.setName(res.getString(BLOCKS_NAME));
                blocks.setVolume(res.getString(BLOCKS_VOLUME));
                blocks.setWeight(res.getString(BLOCKS_WEIGHT));
                blocks.setDimension(res.getString(BLOCKS_DIMENSION));
                blocks.setPrice(res.getString(BLOCKS_PRICE));
                blocks.setAvailability(res.getBoolean(BLOCKS_AVAILABILITY));
                blocks.setMetalCarcase(res.getBoolean(BLOCKS_METALCARCASE));
                return blocks;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public RoundWells getRoundWellsByName(String name, String volume) {
        try {
            ResultSet res = select(String.format(SELECT_ROUNDWELLS_BY_NAME, name, volume));
            if (res!=null && res.next()) {
                RoundWells roundWells = new RoundWells();
                roundWells.setId(res.getLong(ROUNDWELLS_ID));
                roundWells.setName(res.getString(ROUNDWELLS_NAME));
                roundWells.setVolume(res.getString(ROUNDWELLS_VOLUME));
                roundWells.setWeight(res.getString(ROUNDWELLS_WEIGHT));
                roundWells.setDimension(res.getString(ROUNDWELLS_DIMENSION));
                roundWells.setPrice(res.getString(ROUNDWELLS_PRICE));
                roundWells.setAvailability(res.getBoolean(ROUNDWELLS_AVAILABILITY));
                roundWells.setDiameter(res.getFloat(ROUNDWELLS_DIAMETER));
                return roundWells;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Stairs getStairsByName(String name, String volume) {
        try {
            ResultSet res = select(String.format(SELECT_STARS_BY_NAME, name, volume));
            if (res!=null && res.next()) {
                Stairs stairs = new Stairs();
                stairs.setId(res.getLong(STARS_ID));
                stairs.setName(res.getString(STARS_NAME));
                stairs.setVolume(res.getString(STARS_VOLUME));
                stairs.setWeight(res.getString(STARS_WEIGHT));
                stairs.setDimension(res.getString(STARS_DIMENSION));
                stairs.setPrice(res.getString(STARS_PRICE));
                stairs.setAvailability(res.getBoolean(STARS_AVAILABILITY));
                stairs.setNumberOfSteps(res.getInt(STARS_NUMBEROFSTEPS));
                return stairs;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Result saveRecordBuyer(Buyer bean) {
        return execute(String.format(INSERT_BUYER, bean.getId(), bean.getName(), bean.getAddress(),
                bean.getEmail(), bean.getPhoneNumber()));
    }

    @Override
    public Buyer getBuyerById(long id) {
        try {
            ResultSet res = select(String.format(SELECT_BUYER, id));
            if (res!=null && res.next()) {
                Buyer buyer = new Buyer();
                buyer.setId(res.getLong(BUYER_ID));
                buyer.setName(res.getString(BUYER_NAME));
                buyer.setAddress(res.getString(BUYER_ADDRESS));
                buyer.setEmail(res.getString(BUYER_EMAIL));
                buyer.setPhoneNumber(res.getString(BUYER_PHONENUMBER));
                return buyer;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Buyer getBuyerByName(String name, String phoneNumber) {
        try {
            ResultSet res = select(String.format(SELECT_BUYER_BY_NAME, name, phoneNumber));
            if (res!=null && res.next()) {
                Buyer buyer = new Buyer();
                buyer.setId(res.getLong(BUYER_ID));
                buyer.setName(res.getString(BUYER_NAME));
                buyer.setAddress(res.getString(BUYER_ADDRESS));
                buyer.setEmail(res.getString(BUYER_EMAIL));
                buyer.setPhoneNumber(res.getString(BUYER_PHONENUMBER));
                return buyer;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Result updateBuyerById(Buyer bean) {
        return execute(String.format(UPDATE_BUYER, bean.getName(), bean.getAddress(), bean.getPhoneNumber(),
                bean.getEmail(), bean.getId()));
    }

    @Override
    public Result delBuyerById(long id) {
        return execute(String.format(DELETE_BUYER, id));
    }

    @Override
    public Result delRoundWellsById(long id) {
        return execute(String.format(DELETE_ROUNDWELLS, id));
    }

    @Override
    public Result delBlocksById(long id) {
        return execute(String.format(DELETE_BLOCKS, id));
    }

    @Override
    public Result delConcreteById(long id) {
        return execute(String.format(DELETE_CONCRETE, id));
    }

    @Override
    public Result delStairsById(long id) {
        return execute(String.format(DELETE_STAIRS, id));
    }

    @Override
    public Result saveRecordSeller(Seller bean) {
        return execute(String.format(INSERT_SELLER, bean.getId(), bean.getName(), bean.getPhoneNumber()));
    }

    @Override
    public Seller getSellerById(long id) {
        try {
            ResultSet res = select(String.format(SELECT_SELLER, id));
            if (res!=null && res.next()) {
                Seller seller = new Seller();
                seller.setId(res.getLong(SELLER_ID));
                seller.setName(res.getString(SELLER_NAME));
                seller.setPhoneNumber(res.getString(SELLER_PHONENUMBER));
                return seller;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Seller getSellerByName(String name, String phoneNumber) {
        try {
            ResultSet res = select(String.format(SELECT_SELLER_BY_NAME, name, phoneNumber));
            if (res!=null && res.next()) {
                Seller seller = new Seller();
                seller.setId(res.getLong(SELLER_ID));
                seller.setName(res.getString(SELLER_NAME));
                seller.setPhoneNumber(res.getString(SELLER_PHONENUMBER));
                return seller;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }

    @Override
    public Result updateSellerById(Seller bean) {
        return execute(String.format(UPDATE_SELLER, bean.getName(), bean.getPhoneNumber(), bean.getId()));
    }

    @Override
    public Result delSellerById(long id) {
        return execute(String.format(DELETE_SELLER, id));
    }

    @Override
    public boolean checkAvailability(long id, TypeBeans type) {
        return getRecordProductById(id, type).isAvailability();
    }
    private Connection connection() throws IOException, ClassNotFoundException, SQLException {
        Class.forName(getConfigurationEntry(JDBC_DRIVER));
        return DriverManager.getConnection(
                getConfigurationEntry(DB_CONNECT),
                getConfigurationEntry(DB_USER),
                getConfigurationEntry(DB_PASS));

    }

    public Result execute(String sql) {
        try {
            PreparedStatement statement = connection().prepareStatement(sql);
            statement.executeUpdate();
            connection().close();
            return new Result(COMPLETE);
        } catch (Exception e) {
            log.error(e);
            return new Result(FAIL, e.getMessage());
        }
    }

    public ResultSet select(String sql){
        try {
            PreparedStatement statement = connection().prepareStatement(sql);
            connection().close();
            return statement.executeQuery();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            log.error(e);
        }
        return null;
    }
}
