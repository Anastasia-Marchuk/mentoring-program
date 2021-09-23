package com.epam.ld.module2.testing.cucumber;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.MailServer;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import io.cucumber.java.en.*;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CucumberSteps {

        Template template;
        File filename;
        Client client;
        Messenger messenger;
        String message;
        MailServer mailServer;
        TemplateEngine templateEngine;
        String strAddress;


        @Given("create the client")
        public void createClient() {
            client = new Client();
        }

        @When("set address to client as {string}")
        public void setAddressClient(String address) {
                client.setAddresses(address);
        }

        @When("get address from client")
        public void checkAddressMessage() {
            strAddress=client.getAddresses();
        }

        @When("get message from client")
        public void checkMessage() {
                strAddress=client.getMessageFromClient();
        }

        @Then("the message should be {string}")
        public void checkMessage(String address) {
            assertThat(address, is(strAddress));
        }



        @Given("the template is {string}")
        public void createTemplate( String message ) {
            template=new Template(message);

        }

        @When("the mailserver is created")
        public void createMailServer() {
            mailServer=new MailServer();
        }

        @When("the templateEngine is created")
        public void createTemplateEngine() {
            templateEngine=new TemplateEngine();
        }

        @Then ("generating template {string}")
        public void generatingMessage(String message){
            assertThat(message, is(templateEngine.generateMessage(template,client)));
        }

}