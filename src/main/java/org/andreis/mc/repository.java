package org.andreis.mc;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class repository {
    public Connection c;
    private String url;
    public repository() throws Exception {

        url = "jdbc:sqlite:customitems.db";
        Class.forName("org.sqlite.JDBC").newInstance();

        c = getConnection();
        Statement s = c.createStatement();

        s.executeUpdate("CREATE TABLE IF NOT EXISTS chests ('x' TEXT, 'y' TEXT, 'z' TEXT, 'world' TEXT)");



    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url);
    }

    public void add(Location loc) {
        try {

            Statement s = c.createStatement();
            String st = String.format("INSERT INTO chests VALUES ('%s', '%s', '%s', '%s')", loc.getBlockX(),loc.getBlockY(),loc.getBlockZ(),loc.getWorld().getName());
            s.executeUpdate(st);
            s.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getallowance(Location loc) {
        try {
            //false=cant spawn
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery("Select * from chests");
            int x;
            int y;
            int z;
            String world;


            while (resultSet.next()){

                x=Integer.parseInt(resultSet.getString("x"));
                y=Integer.parseInt(resultSet.getString("y"));
                z=Integer.parseInt(resultSet.getString("z"));
                world=resultSet.getString("world");
                if(loc.getBlockX()==x && loc.getBlockY()==y && loc.getBlockZ()==z && world.equals(loc.getWorld().getName())){
                    return false;
                }


            }
            s.close();

            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return true;
        }
    }

}
