/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firewallapp;

/**
 *
 * @author rdlon
 */
public class Firewall implements CommDevice {

    private String permittedReceiver;
    private String buffer;

    public Firewall(String string) {
        permittedReceiver = string;

    }

    @Override
    public void transmit(String destination, String buffer) {
        this.permittedReceiver = destination;
        this.buffer = buffer;
        System.out.println("Data scheduled for transmission to " + this.permittedReceiver);

    }

    @Override
    public boolean receive(String first, String second) {
        if (first.equals(this.permittedReceiver)) {
            this.buffer = second;
        } else {
            this.buffer = "";

            System.out.println("Attempted breach of firewall by " + first);
            return false;
        }
        return true;
    }
}
