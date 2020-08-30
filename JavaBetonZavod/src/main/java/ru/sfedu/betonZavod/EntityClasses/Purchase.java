package ru.sfedu.betonZavod.EntityClasses;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import ru.sfedu.betonZavod.EntityClasses.Converters.BuyerConverter;
import ru.sfedu.betonZavod.EntityClasses.Converters.ProductConverter;
import ru.sfedu.betonZavod.EntityClasses.Converters.SellerConverter;

public class Purchase {

    @CsvBindByPosition(position = 0)
    private long id;
    @CsvBindByPosition(position = 1)
    private String date;
    @CsvBindByPosition(position = 2)
    private String time;
    @CsvCustomBindByPosition(position = 3, converter = ProductConverter.class)
    private Product product;
    @CsvCustomBindByPosition(position = 4, converter = BuyerConverter.class)
    private Buyer buyer;
    @CsvCustomBindByPosition(position = 5, converter = SellerConverter.class)
    private Seller seller;
    @CsvBindByPosition(position = 6)
    private String typeProduct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", product=" + product +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", typeProduct='" + typeProduct + '\'' +
                '}';
    }
}
