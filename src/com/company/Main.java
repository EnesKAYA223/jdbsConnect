package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        dbHelper dbHelper = new dbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        try {

            connection = dbHelper.getConnection();
            String sql = "delete from city where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,5);
            int result = statement.executeUpdate();
            System.out.println("Kayit silindi");

        } catch (SQLException exception) {
            dbHelper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
        }

    }


}

/*
{

        dbHelper dbHelper = new dbHelper();
        PreparedStatement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        try {

            connection = dbHelper.getConnection();
            String sql = "update city set population=55555 where id=4085";
            statement=connection.prepareStatement(sql);
            int result = statement.executeUpdate();
            System.out.println("Kayit güncellendi.");

        } catch (SQLException exception) {
            dbHelper.showErrorMassage(exception);
        } finally {
            statement.close();
            connection.close();
        }

    }






  public static void İnsert(){

   dbHelper dbHelper=new dbHelper();
        PreparedStatement statement=null;
        ResultSet resultSet;
        Connection connection=null;
        try {

            connection=dbHelper.getConnection();
            String sql="insert into city " +
                    "(Name,CountryCode,Population) values (?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,"Düzce 2");
            statement.setString(2,"TUR");
            statement.setInt(3,40000);



            int result=statement.executeUpdate();
            System.out.println("Kayıt Eklendi.");

        }catch (SQLException exception){
            dbHelper.showErrorMassage(exception);
        }
        finally {
            statement.close();
            connection.close();
        }


  }




        dbHelper dbHelper=new dbHelper();
        Statement statement=null;
        ResultSet resultSet;
        Connection connection=null;
        try {

            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select Code,Name,Continent from country");
            ArrayList<Country> countries =new ArrayList<>();
            while (resultSet.next()){
                countries.add(new Country(resultSet.getString("Code"),
                        resultSet.getString("Name"),resultSet.getString("Continent")));
            }
            System.out.println(countries.size());

        }catch (SQLException exception){
            dbHelper.showErrorMassage(exception);
        }
        finally {

            connection.close();
        }

    }*/

