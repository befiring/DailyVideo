package com.befiring.myutils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 * Created by Wang Meng on 2017/8/24.
 */

/**
 * 文件操作工具类
 */
public class IoUtil {

    /**
     * 写入文件方法一
     * @param filePath 文件路径
     * @param content  写入内容
     */
    public static void writeToFileA(String filePath, String content) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw"); //"rw"读写  "r"只读
            long fileLength = randomAccessFile.length();
            randomAccessFile.seek(fileLength);
            randomAccessFile.write(content.getBytes("GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件方法二（Java FileWriter 默认是用（ISO-8859-1 or US-ASCII）西方编码）
     * @param filePath 文件路径
     * @param content  写入内容
     */
    public static void writeToFileB(String filePath, String content) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件方法三，可设置写入文字的编码
     * @param filePath 文件路径
     * @param content  写入内容
     */
    public static void writeToFileC(String filePath,String content){
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), "GBK");
            BufferedWriter writer=new BufferedWriter(osw);
            //PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePathAndName)));
            //PrintWriter writer = new PrintWriter(new FileWriter(filePathAndName));
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("写文件内容操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 创建目录
     */
    public static void createDirectory(String dir) {
        if (null != dir && !dir.equals("")) {
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    /**
     * main方法测试
     */
    public static void main(String[] args) {
        String fileName="E:/test.txt";
        String content="new append";
        writeToFileA(fileName,content);
    }
}
