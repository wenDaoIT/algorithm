package com.demo.Others;

import java.util.Scanner;

public class zhiyinshu {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("please input a integer:");
        int a = input.nextInt();
        for (int i = 2; i <= a;) {
            if(a%i==0)
            {
                a/=i;
                System.out.print(i+" ");
            }else {
            i++;
            }
        }

        }

    }
