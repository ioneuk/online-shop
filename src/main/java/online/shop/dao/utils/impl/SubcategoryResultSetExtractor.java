package online.shop.dao.utils.impl;

import online.shop.dao.utils.ResultSetExtractor;
import online.shop.model.entity.Subcategory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by andri on 1/17/2017.
 */
public class SubcategoryResultSetExtractor implements ResultSetExtractor<Subcategory> {
    @Override
    public Subcategory extract(ResultSet set) throws SQLException{
        Subcategory subcategory = new Subcategory();
        subcategory.setId(set.getInt("subcategoryID"));
        subcategory.setTitle(set.getString("subcategoryTitle"));
        return subcategory;
    }
}