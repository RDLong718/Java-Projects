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
interface CommDevice {

    public void transmit(String a, String b);

    public abstract boolean receive(String a, String b);
}
