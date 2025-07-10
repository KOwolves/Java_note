package JavaIO;

import java.io.*;
import java.text.SimpleDateFormat;

public class JavaIO {
    public void testFile(){
        File testFile = new File("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt");

        // 创建
        try{
            boolean isCreated = testFile.createNewFile();
            System.out.println(isCreated);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        File testDir = new File("D:\\Projects\\Java\\Notes\\src\\JavaIO");

        // 信息
        System.out.println(testFile.exists());
        System.out.println(testDir.exists());

        System.out.println(testFile.isFile());
        System.out.println(testDir.isDirectory());

        System.out.println(testFile.getName());
        System.out.println(testFile.length());
        System.out.println(testFile.getPath());
        System.out.println(testFile.getAbsolutePath());
        long timeModified = testFile.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(timeModified));

        try {
            boolean isDeleted = testFile.delete();
            System.out.println(isDeleted);
            System.out.println(testFile.exists());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // 遍历
        String[] names = testDir.list();
        System.out.println("The list of files in " + testDir.getAbsolutePath() + " includes:");
        if (names != null) {
            for(String name : names){
                System.out.println(name);
            }
        }

        File[] files = testDir.listFiles();
        System.out.println("The list of files in " + testDir.getAbsolutePath() + " includes:");
        if (files != null) {
            for(File file : files){
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public boolean searchFile(File dir, String name){
        File[] files = dir.listFiles();
        if (files != null) {
            for(File file : files){
                if (file.isFile()){
                    if (file.getName().equals(name)){
                        System.out.println("The path of " + name + "is: " + file.getAbsolutePath());
                        return true;
                    }
                }
                else {
                    return searchFile(file, name);
                }
            }
        }
        return false;
    }



    public void testFileBytesIO(boolean in_or_out){
        if (in_or_out){
            // 文件字节输入流
            try {
                // FileInputStream fis = new FileInputStream("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt");
                InputStream is = new FileInputStream("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt");

                // int b1 = is.read();
                // System.out.println((char)b1);

                byte[] buffer = new byte[10];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, len));
                }

                // byte[] Bytesbuffer = is.readAllBytes();
                // System.out.println(new String(Bytesbuffer));


                is.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            // 文件字节输出流
            try {
                OutputStream os = new FileOutputStream("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt", true);
                os.write("Hello World\n".getBytes());
                os.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public boolean copyFile(File source, File dest){
        try (
                // 自动释放资源即自动调用close方法
                InputStream is = new FileInputStream(source);
                OutputStream os = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[10];
            int len;
            while( (len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            is.close();
            os.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        /*
        释放资源写法1
        finally {
            try {
                if (is != null) {
                    is.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            try {
                if (os != null) {
                    os.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        */
    }

    public void testFileCharsIO(boolean in_or_out){
        if (in_or_out){
            try {
                Reader fr = new FileReader("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt");
                char[] buffer = new char[10];
                int len;
                while((len = fr.read(buffer)) != -1) {
                    System.out.print(new String(buffer, 0, len));
                }

                fr.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                Writer fw = new FileWriter("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt", true);
                String str = "Hello java\n";
                fw.write(str);

                char[] buffer = "Hello Java\n".toCharArray();
                fw.write(buffer);

                fw.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        JavaIO javaIO = new JavaIO();

        // 查文件位置
        if(!javaIO.searchFile(new File("D:\\Projects\\Java\\Notes\\src"), "JavaIO.java")){
            System.out.println("File not found.");
        }

        // 复制文件
        if(javaIO.copyFile(new File("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test.txt"), new File("D:\\Projects\\Java\\Notes\\src\\JavaIO\\test_copy.txt"))){
            System.out.println("File copied.");
        }
        else {
            System.out.println("File not copied.");
        }


    }
}
