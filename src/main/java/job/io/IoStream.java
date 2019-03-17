package job.io;

import java.io.*;

public class IoStream {

//    逐个字节拷贝
    public static void copy_byte(FileInputStream source, FileOutputStream to) throws IOException {
        int i = 0 ;
        long start = System.currentTimeMillis();

        while ((i = source.read())!= -1){
            to.write(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+ (end-start));
    }
    public static void copy_byte_buffer(FileInputStream source, FileOutputStream to) throws IOException {
        byte[] bytes = new byte[1024];
        int len = 0 ;
        long start = System.currentTimeMillis();

        while ((len = source.read(bytes))!= -1){
            to.write(len);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+ (end-start));
    }

//    利用字节缓冲区流BufferedInputStream和
// BufferedOutputStream来直接逐字节读写（速度较快）
    public static void copy_byte_StreamByte(BufferedInputStream source
            , BufferedOutputStream to) throws IOException {

        int i = 0;
        long start = System.currentTimeMillis();

        while ((i = source.read())!= -1){
            to.write(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+ (end-start));
    }

//    利用字节缓冲区流BufferedInputStream和
// BufferedOutputStream通过构造一个缓冲数组进行读写（速度最快）
    public static void copy_byte_StreamBuffer(BufferedInputStream source
            , BufferedOutputStream to) throws IOException {

        byte[] bytes = new byte[1024];
        int leng = 0 ;
        long start = System.currentTimeMillis();

        while ((leng = source.read(bytes))!= -1){
            to.write(leng);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+ (end-start));
    }
//    利用字符流InputStreamWriter和 OutputStreamWriter直接按字节读取
    public static void reader_by_char(String source
            , String to) throws IOException {

        FileInputStream fis = new FileInputStream(source);
        InputStreamReader isr = new InputStreamReader(fis);

        FileOutputStream fps = new FileOutputStream(to);
        OutputStreamWriter osw = new OutputStreamWriter(fps);

        char[] chars = new char[1024];
        int leng = 0 ;
        long start = System.currentTimeMillis();

        while ((leng= isr.read(chars)) != -1){
            osw.write(chars);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时"+ (end-start));
    }
/***
 * 字符缓冲流读写
 * bufferedWrite / bufferedRead
 *
 * */
    public static void copy_by_buffered(String source, String to) throws IOException {

        FileReader fr = new FileReader(source);
        BufferedReader br = new BufferedReader(fr);//创建缓冲流读的对象

        FileWriter fw = new FileWriter(to);
        BufferedWriter bw = new BufferedWriter(fw);//创建缓冲流 写的对象

        int i = 0 ;
        long start = System.currentTimeMillis();

        while ((i = br.read()) != -1){
            bw.write(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("用时 ：" + (end-start));
        br.close();
        fr.close();
        bw.close();
        fw.close();
    }

    /**
     *字符缓冲流按照数组大小逐块读写
     * bufferdWrite / bufferedRead
     * */

    public static void copy_by_char(String source, String to) throws IOException {
        FileReader fr = new FileReader(source);
        BufferedReader br = new BufferedReader(fr);//构建缓冲流读对象

        FileWriter fw = new FileWriter(to);
        BufferedWriter bw = new BufferedWriter(fw);

        long start = System.currentTimeMillis();

        char[] chars =new char[1024];
        int length = 0;
        while ((length = br.read(chars)) != -1){
            bw.write(chars);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" +(end-start));
        br.close();
        fr.close();
        bw.close();
        fw.close();
    }

    /**
     *字符缓冲流逐行读写
     * 使用bufferWriter/bufferedReader的readLine方法
     * */

    public static void copy_by_readLine(String source, String to) throws IOException {
        FileReader fr = new FileReader(source);
        BufferedReader br = new BufferedReader(fr);//创建缓冲流读对象

        FileWriter fw = new FileWriter(to);
        BufferedWriter bw = new BufferedWriter(fw);

        long start = System.currentTimeMillis();
        String s;
        while ((s = br.readLine()) != null){
            bw.write(s);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end-start));

        br.close();
        fr.close();
        bw.close();
        fw.close();
    }
    /**
     *     字符流按字符处理数据，速度较之于同原理的字节流快，
     *     但是使用范围较小，仅限文本文件；
     *
     *     字节流处理范围广，文本，音频，视频都可以处理。
     *
     * */
    /**
     * 对象流
     * */
}
