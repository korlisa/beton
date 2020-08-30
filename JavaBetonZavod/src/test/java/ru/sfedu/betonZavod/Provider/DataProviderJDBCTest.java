package ru.sfedu.betonZavod.Provider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.EntityClasses.*;

import static org.junit.Assert.*;
import static ru.sfedu.betonZavod.Constants.Status.COMPLETE;

public class DataProviderJDBCTest {

    private DataProviderJDBC dataProviderJDBS = new DataProviderJDBC();

    private static final long ID = 10;
    private static final String TEST = "test";
    private static final int INT = 2;
    private static final String UPD = "upd";


    @Before
    public void saveRecord() {
        Stairs stairs = new Stairs();
        stairs.setId(ID);
        stairs.setName(TEST);
        stairs.setVolume(TEST);
        stairs.setWeight(TEST);
        stairs.setDimension(TEST);
        stairs.setPrice(TEST);
        stairs.setAvailability(true);
        stairs.setNumberOfSteps(INT);

        assertEquals(dataProviderJDBS.saveRecordStairs(stairs).getStatus(), COMPLETE);

        Blocks blocks = new Blocks();
        blocks.setId(ID);
        blocks.setName(TEST);
        blocks.setVolume(TEST);
        blocks.setWeight(TEST);
        blocks.setDimension(TEST);
        blocks.setPrice(TEST);
        blocks.setAvailability(false);
        blocks.setMetalCarcase(true);

        assertEquals(dataProviderJDBS.saveRecordBlocks(blocks).getStatus(), COMPLETE);

        RoundWells roundWells = new RoundWells();
        roundWells.setId(ID);
        roundWells.setName(TEST);
        roundWells.setVolume(TEST);
        roundWells.setWeight(TEST);
        roundWells.setDimension(TEST);
        roundWells.setPrice(TEST);
        roundWells.setAvailability(true);
        roundWells.setDiameter((float) 5.3542);

        assertEquals(dataProviderJDBS.saveRecordRoundWells(roundWells).getStatus(), COMPLETE);

        Concrete concrete = new Concrete();
        concrete.setId(ID);
        concrete.setName(TEST);
        concrete.setVolume(TEST);
        concrete.setWeight(TEST);
        concrete.setDimension(TEST);
        concrete.setPrice(TEST);
        concrete.setAvailability(false);
        concrete.setGrade("M30");

        assertEquals(dataProviderJDBS.saveRecordConcrete(concrete).getStatus(), COMPLETE);

        Seller seller = new Seller();
        seller.setId(ID);
        seller.setName(TEST);
        seller.setPhoneNumber(TEST);

        assertEquals(dataProviderJDBS.saveRecordSeller(seller).getStatus(), COMPLETE);

        Buyer buyer = new Buyer();
        buyer.setId(ID);
        buyer.setName(TEST);
        buyer.setAddress(TEST);
        buyer.setEmail(TEST);
        buyer.setPhoneNumber(TEST);

        assertEquals(dataProviderJDBS.saveRecordBuyer(buyer).getStatus(), COMPLETE);

        Purchase purchase = new Purchase();
        purchase.setId(ID);
        purchase.setDate(TEST);
        purchase.setTime(TEST);
        purchase.setProduct(stairs);
        purchase.setBuyer(buyer);
        purchase.setSeller(seller);
        purchase.setTypeProduct("STAIRS");

        assertEquals(dataProviderJDBS.saveRecordPurchase(purchase).getStatus(), COMPLETE);



    }
    @Test
    public void getById() {
        assertNotNull(dataProviderJDBS.getSellerById(ID).toString());
        assertNotNull(dataProviderJDBS.getBuyerById(ID).toString());
        assertNotNull(dataProviderJDBS.getStairsById(ID).toString());
        assertNotNull(dataProviderJDBS.getPurchaseById(10).toString());
        assertNotNull(dataProviderJDBS.getBlocksById(ID).toString());
        assertNotNull(dataProviderJDBS.getConcreteById(ID).toString());
        assertNotNull(dataProviderJDBS.getRoundWellsById(ID).toString());

    }
    @Test
    public void getByName() {
//        System.out.println(dataProviderJDBS.getSellerByName("name", "phoneNumber").toString());
    }
    @Test
    public void checkAvailability(){
        assertTrue(dataProviderJDBS.checkAvailability(ID, TypeBeans.STAIRS));
    }
    @Test
    public void getByDate() {
//        System.out.println(dataProviderJDBS.getPurchaseByDate("date", "time").toString());
    }
    @Test
    public void update(){
        Buyer buyer = new Buyer();
        buyer.setId(ID);
        buyer.setName(UPD);
        buyer.setAddress(TEST);
        buyer.setEmail(TEST);
        buyer.setPhoneNumber(TEST);
        assertEquals(dataProviderJDBS.updateBuyerById(buyer).getStatus(), COMPLETE);

        Seller seller = new Seller();
        seller.setId(ID);
        seller.setName(UPD);
        seller.setPhoneNumber(TEST);
        assertEquals(dataProviderJDBS.updateSellerById(seller).getStatus(), COMPLETE);

    }


    @After
    public void delBuyerById() {
//        assertEquals(dataProviderJDBS.delBuyerById(ID).getStatus(), COMPLETE);
//        assertEquals(dataProviderJDBS.delSellerById(ID).getStatus(), COMPLETE);
//        assertEquals(dataProviderJDBS.delStairsById(ID).getStatus(), COMPLETE);
//        assertEquals(dataProviderJDBS.delBlocksById(ID).getStatus(), COMPLETE);
//        assertEquals(dataProviderJDBS.delConcreteById(ID).getStatus(), COMPLETE);
//        assertEquals(dataProviderJDBS.delRoundWellsById(ID).getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from Purchase;").getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from Concrete;").getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from Buyer;").getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from Seller;").getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from Blocks;").getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from Stairs;").getStatus(), COMPLETE);
        assertEquals(dataProviderJDBS.execute("delete from RoundWells;").getStatus(), COMPLETE);


    }
}