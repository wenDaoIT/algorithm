package com.demo.Others;

import java.awt.*;
import java.io.*;


public class SparseArray {
    //编写的五子棋程序中，有存盘退出和续上盘的功能
    public static void main(String[] args) throws IOException {

        int chessArr1[][]= new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        chessArr1[0][0] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1){
                for(int data : row){
                    System.out.printf("%d\t",data);
                }
                System.out.println();
        }

        //原始数组有多少个数
        int sum = 0;
        for (int i = 0; i <11; i++) {
            for(int j=0; j<11; j++){
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        //输出稀疏数组
        int count = 0;
        for (int i = 0; i <11; i++) {
            for (int j=0;j<11;j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];

                }
            }
        }
        //保存为文件
        File file = new File("D:\\My文档\\IDEAdemo\\hexo-boot-2.3.0\\algorithm"+File.separator+"chess.data");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter write = new OutputStreamWriter(fos, "UTF-8");



        System.out.println();
        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);

            if (i == sparseArr.length - 1) {
                write.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2]);
            } else {
                write.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
            }
        }


        System.out.println("写入文件中...");
        write.close();
        fos.close();



        //重新生成一个新chess数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //读取稀疏赋值给新chesss数组
        for (int i = 1; i <sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];

        }

        System.out.println("打开文件中...");
        Desktop.getDesktop().open(file);

        System.out.println("------------------------------先读取_chess.data");
        // 创建 FileReader 对象
        FileInputStream fis = new FileInputStream(file);

        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());// 转成char加到StringBuffer对象中
        }

        System.out.println(sb.toString());
        reader.close();// 关闭读取流
        fis.close();// 关闭输入流,释放系统资源

        System.out.println("恢复后的数组");
        for (int[] row : chessArr2) {
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();

        }













     }
}
