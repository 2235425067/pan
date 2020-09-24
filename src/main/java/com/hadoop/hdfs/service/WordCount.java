package com.hadoop.hdfs.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
@Component
public class WordCount {

//    public static void main(String[] args) throws IOException,
//            URISyntaxException, InterruptedException, ClassNotFoundException {
//        hdfs();
//    }
    public static  void solveWordCount(String path,String name,String fileName) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(WordCount.class);
        job.setMapperClass(WcMapper.class);
        job.setReducerClass(WcReducer.class);
        FileInputFormat.setInputPaths(job, new Path(path));
        Path outPath = new Path("hdfs://119.3.167.84:9000/pan/"+name+"/大数据操作结果/WordCount/"+fileName);
        FileSystem fileSystem = outPath.getFileSystem(new Configuration());//上下不同点
        if(fileSystem.exists(outPath)){
            fileSystem.delete(outPath,true);
        }
        FileOutputFormat.setOutputPath(job, new Path("hdfs://119.3.167.84:9000/pan/"+name+"/大数据操作结果/WordCount/"+fileName));
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setOutputFormatClass(MyOut.class);


        //MyOut.setOutputName(job, "score");//自定义输出
        job.waitForCompletion(true);
        job.waitForCompletion(true);
    }
    //自定义MyOut类继承TextOutPutFormat，并覆盖其中的setOutPutName方法，此方法在FileOutputFormat类中为protected修饰，不能直接调用
    private static class MyOut extends TextOutputFormat{

        protected static void setOutputName(JobContext job, String name) {
            job.getConfiguration().set(BASE_OUTPUT_NAME, name);
        }
    }
}