package com.epam.ld.module2.testing.template;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Template.
 */

public class Template {
    String message;
    File fileName;


    /**
     * @param fileInput  filiInput
     * @throws IOException exception
     */
        public Template(File fileInput) throws IOException {
        this.fileName=fileInput;
        BufferedReader inputStream = new BufferedReader(new FileReader(
                fileName));
    //    File UIFile = new File("/projects/test/src/main/resources/output.txt");

        StringBuilder builder=new StringBuilder("");
        String count;
        while ((count = inputStream.readLine()) != null) {
            builder.append(count+"\n");
        }
        this.message=builder.toString();
        inputStream.close();
    }


//    public Template (String str) {
//        Scanner keyboard = new Scanner(str);
//        System.out.println("Choose name of the file:"+"\n"+"1file"+"\n"+"2file"+"\n"+"3file");
//
//        String fileName = keyboard.nextLine();
//
//
//      //  PrintStream out = new PrintStream(new OutputStream());
//        while (fileName.equals("1file")||fileName.equals("2file")||fileName.equals("3file")) {
//            System.out.println("Wrong file name, try again.");
//           // out.println("Wrong file name, try again.");
//            fileName = keyboard.nextLine();
//        }
//        this.fileName= new File(fileName);
//
//    }

    /**
     * @param str str
     */
    public Template(String str){
            this.message=str;
    }


//   // public static String userInput(InputStream in, PrintStream out) {
//    public static File userInput(String in) {
//        Scanner keyboard = new Scanner(in);
//        System.out.println("Choose name of the file:"+"\n"+"1file"+"\n"+"2file"+"\n"+"3file");
//
//        String fileName = keyboard.nextLine();
//
//        while (fileName.equals("1file")||fileName.equals("2file")||fileName.equals("3file")) {
//          //  out.println("Wrong file name, try again.");
//            System.out.println("Wrong file name, try again.");
//            fileName = keyboard.nextLine();
//        }
//        File file=new File(fileName);
//
//        return file;
//    }

//    public static String getBoundIntegerFromUser(IntegerAsker asker) {
//        String input = asker.ask("Choose name of the file:\"+\"\\n\"+\"1file\"+\"\\n\"+\"2file\"+\"\\n\"+\"3file\"");
//        while (input!="1file"||input!="2file"||input!="3file")
//            input = asker.ask("Wrong name of the file, try again.");
//        return input;
//    }


    public String getMessage(){
        return this.message;
    }


}
