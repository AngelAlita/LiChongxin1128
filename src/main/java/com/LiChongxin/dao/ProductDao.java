package com.LiChongxin.dao;

import com.LiChongxin.model.Product;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into Product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "delete from Product where ProductId = ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1,productId);
        ptmt.executeUpdate();
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update Product set ProductName = ?,ProductDescription = ?,Picture = ?,price = ?,CategoryID = ? where ProductId = ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setString(1,instance.getProductName());
        ptmt.setString(2,instance.getProductDescription());
        ptmt.setBinaryStream(3,instance.getPicture());
        ptmt.setDouble(4,instance.getPrice());
        ptmt.setInt(5,instance.getCategoryId());
        ptmt.setInt(6,instance.getProductId());

        ptmt.executeUpdate();
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from Product where ProductId = ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1,productId);
        ResultSet rs = ptmt.executeQuery();
        Product product =null;
        if(rs.next())
        {
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        String sql = "select * from Product where CategoryId = ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1,categoryId);
        ResultSet rs = ptmt.executeQuery();
        Product product =null;
        List<Product> list = new ArrayList<Product>();
        while(rs.next())
        {
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        String sql = "select * from Product where price between ? and ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setDouble(1,minPrice);
        ptmt.setDouble(2,maxPrice);
        ResultSet rs = ptmt.executeQuery();
        Product product =null;
        List<Product> list = new ArrayList<Product>();
        while(rs.next())
        {
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        String sql = "select * from Product ";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        Product product =null;
        List<Product> list = new ArrayList<Product>();
        while(rs.next())
        {
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {

        String sql = "select * from Product where ProductName = ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setString(1,productName);
        ResultSet rs = ptmt.executeQuery();
        Product product =null;
        List<Product> list = new ArrayList<Product>();
        while(rs.next())
        {
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
            list.add(product);
        }
        return list;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        String sql = "select * from Product where ProductId = ?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1,productId);
        ResultSet rs = ptmt.executeQuery();
        Product product =null;
        List<Product> list = new ArrayList<Product>();
        while(rs.next())
        {
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPicture(rs.getBinaryStream("picture"));
            product.setProductDescription(rs.getString("productDescription"));
            product.setPrice(rs.getDouble("price"));
            product.setCategoryId(rs.getInt("categoryId"));
            list.add(product);
        }
        return list;
    }
}
