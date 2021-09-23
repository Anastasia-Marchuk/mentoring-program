package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string str
     * @throws NullPointerException if manufacturer is null.
     */
    public String generateMessage(Template template, Client client) throws NullPointerException{
        String finalText;
        try {

            if (template == null || client == null) {
                throw new NullPointerException();
            }
      }catch (NullPointerException e){}
         String address=client.getAddresses();
         String message=template.getMessage();
         finalText = "SEND TO: " + address + " MESSAGE: " + message;

       return finalText;
    }
}
