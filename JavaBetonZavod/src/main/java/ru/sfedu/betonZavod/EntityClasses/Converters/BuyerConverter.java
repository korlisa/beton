package ru.sfedu.betonZavod.EntityClasses.Converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.betonZavod.EntityClasses.Buyer;
import ru.sfedu.betonZavod.Provider.DataProviderCSV;

public class BuyerConverter extends AbstractBeanField<Buyer> {

    @Override
    public String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException{
        Buyer buyer = (Buyer) value;
        return String.valueOf(buyer.getId());
    }
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException{
        DataProviderCSV csv = new DataProviderCSV();
        return csv.getBuyerById(Long.parseLong(s));
    }
}
