package ru.sfedu.betonZavod.EntityClasses.Converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.betonZavod.EntityClasses.Seller;
import ru.sfedu.betonZavod.Provider.DataProviderCSV;

public class SellerConverter extends AbstractBeanField<Seller> {

    @Override
    public String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Seller seller = (Seller) value;
        return String.valueOf(seller.getId());
    }

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        DataProviderCSV csv = new DataProviderCSV();
        return csv.getSellerById(Long.parseLong(s));
    }
}
