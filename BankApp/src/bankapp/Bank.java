/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author rdlon
 */
public class Bank {
    
    private Account acct;
    private String name;
    private CDAccount cdacct;
    
    
    Bank(){        
    }

    Bank(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;        
    }
    public void setAcct (Account acct){
        this.acct = acct;
    }
    
    public String getName (){
    return name;
}
    public Account getAccount(){
        return acct;
    }
    
    
    
    
}
