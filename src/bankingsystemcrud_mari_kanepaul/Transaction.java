/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystemcrud_mari_kanepaul;

import java.util.Date;

/**
 *
 * @author Kane
 */
public class Transaction {
    
    private int transactionid;
    private int accountid;
    private String transactiontype;
    private int amount;
    private Date transactiondate;

    public Transaction(int transactionid, int accountid, String transactiontype, int amount, Date transactiondate) {
        this.transactionid = transactionid;
        this.accountid = accountid;
        this.transactiontype = transactiontype;
        this.amount = amount;
        this.transactiondate = transactiondate;
    }

    public Transaction(int accountid, String transactiontype, int amount, Date transactiondate) {
        this.accountid = accountid;
        this.transactiontype = transactiontype;
        this.amount = amount;
        this.transactiondate = transactiondate;
    }

    public Transaction() {
    }
    
    

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }
    
    
    
}
