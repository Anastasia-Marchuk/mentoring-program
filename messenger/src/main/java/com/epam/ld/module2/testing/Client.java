package com.epam.ld.module2.testing;

/**
 * The type Client.
 */
public class Client {
    private String addresses;

    public Client(){}

    public Client(String address){
        this.addresses=address;
    }

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getAddresses() {
        return addresses;
    }

    public String getMessageFromClient() {
        return "I'm from "+addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }
}
