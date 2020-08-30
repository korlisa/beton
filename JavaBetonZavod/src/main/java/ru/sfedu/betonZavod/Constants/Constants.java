package ru.sfedu.betonZavod.Constants;

public class Constants {

    public static final String CU_KEY = "config";
    public static final String DEFAULT_CONFIG_PATH = "/config.properties";
    public static final String FULL_PATH = "src/main/resources/config.properties";


    public static final String CSV = "csv";
    public static final String XML = "xml";
    public static final String DB = "db";
    public static final String POINT = ".";

    //    SQL

    public static final String JDBC_DRIVER = "jdbcDriver";
    public static final String DB_CONNECT = "dbConn";
    public static final String DB_USER = "dbUsr";
    public static final String DB_PASS = "dbPass";

    public static final String SELECT_CONCRETE = "SELECT * FROM Concrete WHERE id=%d;";
    public static final String SELECT_ROUNDWELLS = "SELECT * FROM RoundWells WHERE id=%d;";
    public static final String SELECT_STAIRS = "SELECT * FROM Stairs WHERE id=%d;";
    public static final String SELECT_BLOCKS = "SELECT * FROM Blocks WHERE id=%d;";
    public static final String SELECT_PURCHASE = "SELECT * FROM Purchase WHERE id=%d;";
    public static final String SELECT_BUYER = "SELECT * FROM Buyer WHERE id=%d;";
    public static final String SELECT_SELLER = "SELECT * FROM Seller WHERE id=%d;";

    public static final String INSERT_CONCRETE = "INSERT INTO Concrete VALUES(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
    public static final String INSERT_ROUNDWELLS = "INSERT INTO RoundWells VALUES(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
    public static final String INSERT_STAIRS = "INSERT INTO Stairs VALUES(%d, '%s', '%s', '%s', '%s', '%s','%s', %d);";
    public static final String INSERT_BLOCKS = "INSERT INTO Blocks VALUES(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
    public static final String INSERT_PURCHASE = "INSERT INTO Purchase VALUES(%d, '%s', '%s', %d, %d, %d, '%s');";
    public static final String INSERT_BUYER = "INSERT INTO Buyer VALUES(%d, '%s', '%s', '%s', '%s');";
    public static final String INSERT_SELLER = "INSERT INTO Seller VALUES(%d, '%s', '%s');";

    public static final String BUYER_ID = "id";
    public static final String BUYER_NAME = "name";
    public static final String BUYER_ADDRESS = "address";
    public static final String BUYER_EMAIL = "email";
    public static final String BUYER_PHONENUMBER = "phone_Number";

    public static final String SELLER_ID = "id";
    public static final String SELLER_NAME = "name";
    public static final String SELLER_PHONENUMBER = "phone_Number";

    public static final String ROUNDWELLS_ID = "id";
    public static final String ROUNDWELLS_NAME = "name";
    public static final String ROUNDWELLS_VOLUME = "volume";
    public static final String ROUNDWELLS_WEIGHT = "weight";
    public static final String ROUNDWELLS_DIMENSION = "dimension";
    public static final String ROUNDWELLS_PRICE = "price";
    public static final String ROUNDWELLS_AVAILABILITY = "availability";
    public static final String ROUNDWELLS_DIAMETER = "diameter";


    public static final String BLOCKS_ID = "id";
    public static final String BLOCKS_NAME = "name";
    public static final String BLOCKS_VOLUME = "volume";
    public static final String BLOCKS_WEIGHT = "weight";
    public static final String BLOCKS_DIMENSION = "dimension";
    public static final String BLOCKS_PRICE = "price";
    public static final String BLOCKS_AVAILABILITY = "availability";
    public static final String BLOCKS_METALCARCASE = "metalCarcase";

    public static final String CONCRETE_ID = "id";
    public static final String CONCRETE_NAME = "name";
    public static final String CONCRETE_VOLUME = "volume";
    public static final String CONCRETE_WEIGHT = "weight";
    public static final String CONCRETE_DIMENSION = "dimension";
    public static final String CONCRETE_PRICE = "price";
    public static final String CONCRETE_AVAILABILITY = "availability";
    public static final String CONCRETE_GRADE = "grade";

    public static final String STARS_ID = "id";
    public static final String STARS_NAME = "name";
    public static final String STARS_VOLUME = "volume";
    public static final String STARS_WEIGHT = "weight";
    public static final String STARS_DIMENSION = "dimension";
    public static final String STARS_PRICE = "price";
    public static final String STARS_AVAILABILITY = "availability";
    public static final String STARS_NUMBEROFSTEPS = "numberOfSteps";

    public static final String PURCHASE_ID = "id";
    public static final String PURCHASE_DATE = "date";
    public static final String PURCHASE_TIME = "time";
    public static final String PURCHASE_ID_PRODUCT = "idProduct";
    public static final String PURCHASE_ID_BUYER = "idBuyer";
    public static final String PURCHASE_ID_SELLER = "idSeller";
    public static final String PURCHASE_TYPE_PRODUCT = "typeProduct";

    // sql

    public static final String SELECT_PURCHASE_BY_DATE = "SELECT * FROM PURCHASE WHERE date=%s AND time=%s;";
    public static final String SELECT_ROUNDWELLS_BY_NAME = "SELECT * FROM ROUNDWELLS WHERE name=%s AND volume=%s;";
    public static final String SELECT_BLOCKS_BY_NAME = "SELECT * FROM BLOCKS WHERE name=%s AND volume=%s;";
    public static final String SELECT_CONCRETE_BY_NAME = "SELECT * FROM CONCRETE WHERE name=%s AND volume=%s;";
    public static final String SELECT_STARS_BY_NAME = "SELECT * FROM STARS WHERE name=%s AND volume=%s;";
    public static final String SELECT_BUYER_BY_NAME = "SELECT * FROM BUYER WHERE name=%s AND phone_Number=%s;";
    public static final String SELECT_SELLER_BY_NAME = "SELECT * FROM SELLER WHERE name=%s AND phone_Number=%s;";

    public static final String DELETE_CONCRETE = "DELETE FROM Concrete WHERE id=%d;";
    public static final String DELETE_BLOCKS = "DELETE FROM Blocks WHERE id=%d;";
    public static final String DELETE_ROUNDWELLS = "DELETE FROM RoundWells WHERE id=%d;";
    public static final String DELETE_STAIRS = "DELETE FROM Stairs WHERE id=%d;";
    public static final String DELETE_SELLER = "DELETE FROM Seller WHERE id=%d;";
    public static final String DELETE_BUYER = "DELETE FROM Buyer WHERE id=%d;";

    public static final String UPDATE_SELLER = "UPDATE Seller SET name='%s', phone_Number='%s' WHERE id=%d;";
    public static final String UPDATE_BUYER = "UPDATE Buyer SET name='%s', address='%s', email='%s', phone_Number='%s' WHERE id=%d;";

    //

    public static final String CONCRETE = "concrete";
    public static final String BLOCKS = "blocks";
    public static final String ROUNDWELLS = "roundWells";
    public static final String STAIRS = "stairs";
    public static final String SELLER = "seller";
    public static final String BUYER = "buyer";
    public static final String PURCHASE = "purchase";

    public static final String SAVE = "save";
    public static final String GET = "get";
    public static final String DEL = "del";
    public static final String UPD = "upd";
    public static final String CHECK = "check";

    public static final String NOT_BUYER = "buyer not exist, please entry: ";
    public static final String NOT_SELLER = "seller not exist";
    public static final String NOT_EXIST_ENTRY= "not exist, please entry: ";
    public static final String _SAVE_= " save ";
    public static final String BUYER_SAVE = " buyer save ";

    public static final String SPACE = " ";




}
