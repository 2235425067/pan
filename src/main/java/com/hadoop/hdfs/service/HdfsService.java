package com.hadoop.hdfs.service;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

//import com.hadoop.util.JsonUtil;

@Component
public class HdfsService {

    private static String hdfsPath="hdfs://119.3.167.84:9000";
    private static String hdfsName="taboo";
    private static final int bufferSize = 1024 * 1024 * 64;

    public  static List<com.example.test.bean.File> searchFile(String path, String searchContent) throws Exception {
        return getAllFile(path,searchContent);
    }
    public static List<com.example.test.bean.File> getAllFile(String path,String searchContent) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        if (!existFile(path)) {
            return null;
        }

        FileSystem fs = getFileSystem();
        // 目标路径
        Stack<String> stack=new Stack<>();
        stack.push("hdfs://119.3.167.84:9000"+path);
        List<com.example.test.bean.File> returnList = new ArrayList<>();
        while(stack.empty()==false){
            String top=stack.pop();
            FileStatus[] list=fs.listStatus(new Path(top));
            for(FileStatus f:list){
                com.example.test.bean.File file=new com.example.test.bean.File();
                Path filePath=f.getPath();
                file.setFilename(filePath.getName());
                file.setFilepath(filePath.toString());
                file.setTime(new Date(f.getAccessTime()) );
                if(f.isDir()){
                    stack.push(top+"/"+filePath.getName());
                    continue;
                }
                file.setLen((int)f.getLen());
                if(filePath.getName().contains(searchContent)) returnList.add(file);
            }
        }
        fs.close();
        return returnList;
    }
    public static boolean renameFile(String oldName, String newName) throws Exception {
        if (StringUtils.isEmpty(oldName) || StringUtils.isEmpty(newName)) {
            return false;
        }
        FileSystem fs = getFileSystem();
        // 原文件目标路径
        Path oldPath = new Path(oldName);
        // 重命名目标路径
        Path newPath = new Path(newName);
        boolean isOk = fs.rename(oldPath, newPath);
        fs.close();
        return isOk;
    }
    public static boolean mkdir(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        if (existFile(path)) {
            return true;
        }
        FileSystem fs = getFileSystem();
        // 目标路径
        Path srcPath = new Path(path);
        boolean isOk = fs.mkdirs(srcPath);
        fs.close();
        return isOk;
    }
    public static void downloadFile(String path, String downloadPath) throws Exception {
        if (StringUtils.isEmpty(path) || StringUtils.isEmpty(downloadPath)) {
            return;
        }
        String dest =downloadPath;
        String local = path;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dest),conf);
        FSDataInputStream fsdi = fs.open(new Path(dest));
        OutputStream output = new FileOutputStream(local);
        IOUtils.copyBytes(fsdi,output,4096,true);
        fs.close();
    }
    public static void getDownloadFileStream(HttpServletResponse res, String downloadPath) throws Exception {
        if (StringUtils.isEmpty(downloadPath)) {
            return;
        }
        String dest =downloadPath;
        Configuration conf = new Configuration();
        conf.set("dfs.client.use.datanode.hostname", "true");
        FileSystem fs = FileSystem.get(URI.create(dest),conf);
        FSDataInputStream fsdi = fs.open(new Path(dest));
        OutputStream output = res.getOutputStream();
        IOUtils.copyBytes(fsdi,output,4096,true);
        //output.write(fsdi.readByte());

//        String data = "中国";
//        OutputStream ps = res.getOutputStream();
//        //这句话的意思，使得放入流的数据是utf8格式
//        ps.write(data.getBytes("UTF-8"));

        fs.close();
    }
    public static List<String> readFile(HttpServletResponse res, String downloadPath) throws Exception {
        if (StringUtils.isEmpty(downloadPath)) {
            return null;
        }
        String dest =downloadPath;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dest),conf);
        FSDataInputStream fsdi = fs.open(new Path(dest));
        OutputStream output = res.getOutputStream();
        try {
            // 防止中文乱码
            BufferedReader reader = new BufferedReader(new InputStreamReader(fsdi));
            String lineTxt = "";
            StringBuffer sb = new StringBuffer();
            List<String> list=new ArrayList<>();
            while ((lineTxt = reader.readLine()) != null) {
                sb.append(lineTxt);
                list.add(lineTxt.toString());
            }
            String data=sb.toString();
            //output.write(data.getBytes("UTF-8"));
            return list;
        } finally {
            fsdi.close();
            fs.close();
        }
    }

    public static boolean existFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
        FileSystem fs = getFileSystem();
        Path srcPath = new Path(path);
        boolean isExists = fs.exists(srcPath);
        return isExists;
    }
    private static FileSystem getFileSystem() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://119.3.167.84:9000");
        conf.set("dfs.client.use.datanode.hostname", "true");
        FileSystem fs = FileSystem.newInstance(conf);
        return fs;
    }

    public static List<Map<String, String>> listFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        if (!existFile(path)) {
            return null;
        }

        FileSystem fs = getFileSystem();
        // 目标路径
        Path srcPath = new Path("hdfs://119.3.167.84:9000"+path);
        // 递归找到所有文件
        FileStatus[] list=fs.listStatus(new Path(path));
        List<Map<String, String>> returnList = new ArrayList<>();
        for(FileStatus f:list){
            Map<String, String> map = new HashMap<>();
            Path filePath=f.getPath();
            map.put("fileName", filePath.getName());
            map.put("filePath", filePath.toString());
            map.put("time", String.valueOf( f.getAccessTime()));
            if(f.isDir()){
                map.put("isDir", "true");
            }
            else{
                map.put("isDir", "false");
            }
            map.put("len", String.valueOf(f.getLen()));
            returnList.add(map);
        }
        fs.close();
        return returnList;
    }
    public static  void up(String url){
        Configuration conf = new Configuration();
        conf.set("dfs.replication", "1");
        try {
            FileSystem fs = FileSystem.get(new URI("hdfs://119.3.167.84:9000"), conf, "root");
            FSDataOutputStream outputStream = null;
            FileInputStream fileInputStream = null;
            try {
                Path path = new Path("/movies.csv");
                outputStream = fs.create(path);
                fileInputStream = new FileInputStream(new File(url));
                //输入流、输出流、缓冲区大小、是否关闭数据流，如果为false就在 finally里关闭
                IOUtils.copyBytes(fileInputStream, outputStream,4096, false);

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(fileInputStream != null){
                    IOUtils.closeStream(fileInputStream);
                }
                if(outputStream != null){
                    IOUtils.closeStream(outputStream);
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("1");
    }
    public static void createFile(String path, MultipartFile file) throws Exception {
        if (StringUtils.isEmpty(path) || null == file.getBytes()) {
            return;
        }
        String fileName = file.getOriginalFilename();
        FileSystem fs = getFileSystem();
        // 上传时默认当前目录，后面自动拼接文件的目录
        Path newPath = new Path(path + "/" + fileName);
        // 打开一个输出流
        FSDataOutputStream outputStream = fs.create(newPath);
        outputStream.write(file.getBytes());
        outputStream.close();
        fs.close();
    }
    public static boolean deleteFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }
//        if (!existFile(path)) {
//            return false;
//        }
        FileSystem fs = getFileSystem();
        Path srcPath = new Path(path);
        boolean isOk = fs.deleteOnExit(srcPath);
        fs.close();
        return isOk;
    }
    public static String getHdfsPath() {
        return hdfsPath;
    }
}