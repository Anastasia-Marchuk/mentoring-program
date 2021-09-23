package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.MailServer;
import com.epam.ld.module2.testing.Messenger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Asker {

    private  static Scanner scanner;
    private  static String str;



    public Asker(String str){
this.str=str;
    }

    public Asker(){
        this.str="Choose file:";
    }


    /**
     * @param message message
     * @return answer
     */
    public String ask(String message) {
        System.out.println(message);
        scanner = new Scanner(System.in);
        String answer=scanner.nextLine();
        return answer;
    }




}