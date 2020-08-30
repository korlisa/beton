package ru.sfedu.betonZavod.EntityClasses.Converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.betonZavod.EntityClasses.Product;
import ru.sfedu.betonZavod.Provider.DataProviderCSV;
import ru.sfedu.betonZavod.Constants.TypeBeans;

public class ProductConverter extends AbstractBeanField<Product> {

    @Override
    public String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Product product = (Product) value;
        return String.format("%s#%s", value.getClass().getSimpleName().toUpperCase(), product.getId());
    }
    @Override
    public Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        DataProviderCSV csv = new DataProviderCSV();
        String[] param = s.split("#", 2);
        return csv.getRecordProductById(Long.parseLong(param[1]), TypeBeans.valueOf(param[0].toUpperCase()));
    }

}
