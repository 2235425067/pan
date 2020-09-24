package com.hadoop.hdfs.service;

import com.example.test.bean.Friend;
import org.apache.hadoop.conf.Configuration;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.io.File;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;
@Component
public class hbaseService {
    public static Configuration configuration;
    public static Connection connection;	//connection object
    public static Admin admin;			//operation object
    public static Connection link;	//connection object
    public static void initconnection() throws Exception
    {
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","119.3.167.84,117.78.2.224,119.3.249.45");  //hbase 服务地址
        configuration.set("hbase.zookeeper.property.clientPort","2181"); //端口号
        connection = ConnectionFactory.createConnection(configuration);
        admin = connection.getAdmin();

        link=connection;
    }
    public static void putImage(String tableName,String name,byte[] imageFile) throws Exception
    {
        initconnection();
        Table table = connection.getTable(TableName.valueOf(tableName));
        List<Put> putList = new ArrayList<Put>();
        Put put1;
        put1 = new Put(Bytes.toBytes(name));
        put1.addColumn(Bytes.toBytes("base"), Bytes.toBytes("image"), imageFile);
        putList.add(put1);
        table.put(putList);
        table.close();
    }
    public static  byte[] getImage(String tableName,String name) throws Exception
    {
        initconnection();
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get=new Get(name.getBytes());
        Result rs=table.get(get);
        byte[] bs = rs.value();
        table.close();
        return bs;
    }
    public static  List<HashMap<String,Object>> getFriendList(String tableName,List<Friend> list) throws Exception
    {
        initconnection();
        Table table = connection.getTable(TableName.valueOf(tableName));
        List<HashMap<String,Object>> ansList=new ArrayList<>();
        for(Friend friend:list){
            Get get=new Get(friend.getFriendname().getBytes());
            Result rs=table.get(get);
            if(rs.isEmpty()){
                get=new Get("default".getBytes());
                rs=table.get(get);
            }
            byte[] image = rs.value();
            String FileBuf = Base64.getEncoder().encodeToString(image);
            HashMap<String,Object> map=new HashMap<>();
            map.put("image","data:image/png;base64,"+FileBuf);
            map.put("friendname",friend.getFriendname());
            map.put("name",friend.getName());
            ansList.add(map);
        }
        table.close();
        return ansList;
    }
}
