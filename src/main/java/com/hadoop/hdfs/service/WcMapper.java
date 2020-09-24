package com.hadoop.hdfs.service;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//自定义的Mapper类必须继承Mapper类，并重写map方法实现自己的逻辑
public class WcMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    //处理输入文件的每一行都会调用一次map方法，文件有多少行就会调用多少次
    protected void map(
            LongWritable key,
            Text value,
            Context context)
            throws java.io.IOException, InterruptedException {
        String line =value.toString();
        String[] words=line.split(" ");
        for(String w : words){
            context.write(new Text(w),new LongWritable(1));
        }
    }
}