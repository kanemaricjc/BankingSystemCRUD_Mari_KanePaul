/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystemcrud_mari_kanepaul;

/**
 *
 * @author Kane
 */
public class Account {
    
    private int accountid;
    private int customerid;
    private String accounttype;
    private int balance;

    public Account(int accountid, int customerid, String accounttype, int balance) {
        this.accountid = accountid;
        this.customerid = customerid;
        this.accounttype = accounttype;
        this.balance = balance;
    }

    public Account(int customerid, String accounttype, int balance) {
        this.customerid = customerid;
        this.accounttype = accounttype;
        this.balance = balance;
    }

    public Account() {
    }
    
    

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    
    
}
