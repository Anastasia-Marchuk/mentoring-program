package com.epam.ld.module2.testing;


import com.epam.ld.module2.testing.template.Asker;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * The type Messenger.
 */
public class Messenger {
    private MailServer mailServer;
    private TemplateEngine templateEngine;
    private  static Scanner scanner;

    /**
     * Instantiates a new Messenger.
     *
     * @param mailServer     the mail server
     * @param templateEngine the template engine
     */
    public Messenger(MailServer mailServer,
                     TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    /**
     * Send message.
     *
     * @param client   the client
     * @param template the template
     */
    public void sendMessage(Client client, Template template) {
        try {
        String messageContent =
                templateEngine.generateMessage(template, client);

            mailServer.send(client.getAddresses(), messageContent);
            System.out.println("ADDRESS: " + client.getAddresses() + "\n" + messageContent);
        } catch (NullPointerException e){

        }
    }

    /**
     * @param args main
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {

        while(true) {
            System.out.println("Do you want to write message or take it from file?\n 1. write\n 2. file");

            scanner = new Scanner(System.in);
            String answer=scanner.nextLine();
            if (answer.equals("write")) {
                sendMessageFromConsole();
            } else if (answer.equals("file")) {
                System.out.println("Write an address");
                String address=scanner.nextLine();
                System.out.println("Choose number of file\n 1. 1file.txt\n 2. 2file.txt\n 3. 3file.txt");
                switch (scanner.nextLine()) {
                    case "1":
                        sendMessageFromFile("/home/anastasia/EpamMentoringProgram/messenger/src/main/resources/1file.txt",address);
                        break;
                    case "2":
                        sendMessageFromFile("/home/anastasia/EpamMentoringProgram/messenger/src/main/resources/2file.txt", address);
                        break;
                    case "3":
                        sendMessageFromFile("/home/anastasia/EpamMentoringProgram/messenger/src/main/resources/3file.txt",address);
                        break;

                    default:
                        System.out.println("Try again");
                        break;

                }
            }else {
                System.out.println("Try again");
            }
        }


    }

    private static void sendMessageFromConsole() {
        MailServer mailServer=new MailServer();
        TemplateEngine templateEngine=new TemplateEngine();
        Messenger messenger=new Messenger(mailServer, templateEngine);
        Client client=new Client();

        Asker asker=new Asker();
        String answer=asker.ask("What address is?");
        client.setAddresses(answer);

        String messageAnswer=asker.ask("What message do you want to send?");
        Template template=new Template(messageAnswer);

        messenger.sendMessage(client,template);

    }

    /**
     * @throws IOException io
     * @param address address
     * @param path path
     */
    public static void sendMessageFromFile(String path, String address) throws IOException {

        Client client=createClient(address);

        MailServer mailServer=new MailServer();
        TemplateEngine templateEngine=new TemplateEngine();
        Messenger messenger=new Messenger(mailServer, templateEngine);


        Template template=new Template(new File(path));
        messenger.sendMessage(client,template);
    }

    /**
     * @param address address
     * @return client
     */
    public static Client createClient(String address){
        Client client=new Client();
        client.setAddresses(address);
        return client;
    }


}