package ru.sfedu.betonZavod.Provider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.sfedu.betonZavod.Constants.TypeBeans;
import ru.sfedu.betonZavod.EntityClasses.*;

import static org.junit.Assert.*;
import static ru.sfedu.betonZavod.Constants.Status.COMPLETE;

public class DataProviderXMLTest {

    private DataProviderXML dataProviderXML = new DataProviderXML();

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

        assertEquals(dataProviderXML.saveRecordStairs(stairs).getStatus(), COMPLETE);

        Blocks blocks = new Blocks();
        blocks.setId(ID);
        blocks.setName(TEST);
        blocks.setVolume(TEST);
        blocks.setWeight(TEST);
        blocks.setDimension(TEST);
        blocks.setPrice(TEST);
        blocks.setAvailability(false);
        blocks.setMetalCarcase(true);

        assertEquals(dataProviderXML.saveRecordBlocks(blocks).getStatus(), COMPLETE);

        RoundWells roundWells = new RoundWells();
        roundWells.setId(ID);
        roundWells.setName(TEST);
        roundWells.setVolume(TEST);
        roundWells.setWeight(TEST);
        roundWells.setDimension(TEST);
        roundWells.setPrice(TEST);
        roundWells.setAvailability(true);
        roundWells.setDiameter((float) 5.3542);

        assertEquals(dataProviderXML.saveRecordRoundWells(roundWells).getStatus(), COMPLETE);

        Concrete concrete = new Concrete();
        concrete.setId(ID);
        concrete.setName(TEST);
        concrete.setVolume(TEST);
        concrete.setWeight(TEST);
        concrete.setDimension(TEST);
        concrete.setPrice(TEST);
        concrete.setAvailability(false);
        concrete.setGrade("M30");

        assertEquals(dataProviderXML.saveRecordConcrete(concrete).getStatus(), COMPLETE);

        Seller seller = new Seller();
        seller.setId(ID);
        seller.setName(TEST);
        seller.setPhoneNumber(TEST);

        assertEquals(dataProviderXML.saveRecordSeller(seller).getStatus(), COMPLETE);

        Buyer buyer = new Buyer();
        buyer.setId(ID);
        buyer.setName(TEST);
        buyer.setAddress(TEST);
        buyer.setEmail(TEST);
        buyer.setPhoneNumber(TEST);

        assertEquals(dataProviderXML.saveRecordBuyer(buyer).getStatus(), COMPLETE);

        Purchase purchase = new Purchase();
        purchase.setId(ID);
        purchase.setDate(TEST);
        purchase.setTime(TEST);
        purchase.setProduct(stairs);
        purchase.setBuyer(buyer);
        purchase.setSeller(seller);
        purchase.setTypeProduct("STAIRS");

        assertEquals(dataProviderXML.saveRecordPurchase(purchase).getStatus(), COMPLETE);



    }




    @Test
    public void getById() {
        assertNotNull(dataProviderXML.getSellerById(ID));
        assertNotNull(dataProviderXML.getBuyerById(ID));
        assertNotNull(dataProviderXML.getStairsById(ID));
        assertNotNull(dataProviderXML.getPurchaseById(1));
        assertNotNull(dataProviderXML.getBlocksById(ID));
        assertNotNull(dataProviderXML.getConcreteById(ID));
        assertNotNull(dataProviderXML.getRoundWellsById(ID));



    }
    @Test
    public void getByName() {
        System.out.println(dataProviderXML.getSellerByName(TEST, TEST).toString());
    }
    @Test
    public void checkAvailability(){
        assertTrue(dataProviderXML.checkAvailability(ID, TypeBeans.STAIRS));
    }
    @Test
    public void getByDate() {
        System.out.println(dataProviderXML.getPurchaseByDate(TEST, TEST).toString());
    }
    @Test
    public void update(){
        Buyer buyer = new Buyer();
        buyer.setId(ID);
        buyer.setName(UPD);
        buyer.setAddress(TEST);
        buyer.setEmail(TEST);
        buyer.setPhoneNumber(TEST);
        assertEquals(dataProviderXML.updateBuyerById(buyer).getStatus(), COMPLETE);

        Seller seller = new Seller();
        seller.setId(ID);
        seller.setName(UPD);
        seller.setPhoneNumber(TEST);
        assertEquals(dataProviderXML.updateSellerById(seller).getStatus(), COMPLETE);

    }

    @After
    public void delBuyerById() {
        assertEquals(dataProviderXML.delBuyerById(ID).getStatus(), COMPLETE);
        assertEquals(dataProviderXML.delSellerById(ID).getStatus(), COMPLETE);
        assertEquals(dataProviderXML.delStairsById(ID).getStatus(), COMPLETE);
        assertEquals(dataProviderXML.delBlocksById(ID).getStatus(), COMPLETE);
        assertEquals(dataProviderXML.delConcreteById(ID).getStatus(), COMPLETE);
        assertEquals(dataProviderXML.delRoundWellsById(ID).getStatus(), COMPLETE);

    }
}