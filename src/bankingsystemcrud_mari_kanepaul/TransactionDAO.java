/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystemcrud_mari_kanepaul;

/**
 *
 * @author Kane
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public boolean addTransaction(Transaction transaction) {
        
        String sql = "INSERT INTO transaction (Account_account_id, transaction_type, amount, transaction_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getAccountid());
            stmt.setString(2, transaction.getTransactiontype());
            stmt.setString(3, String.valueOf(transaction.getAmount()));
            stmt.setDate(4, new java.sql.Date(transaction.getTransactiondate().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transaction";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int amountInt = 0;
                try {
                    amountInt = Integer.parseInt(rs.getString("amount"));
                } catch (NumberFormatException ex) {
                    amountInt = 0; 
                }
                transactions.add(new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("Account_account_id"), 
                        rs.getString("transaction_type"),
                        amountInt,
                        rs.getDate("transaction_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
    
    public List<Transaction> getTransactionsByAccount(int accountId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transaction WHERE Account_account_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int amountInt = 0;
                    try {
                        amountInt = Integer.parseInt(rs.getString("amount"));
                    } catch (NumberFormatException ex) {
                        amountInt = 0;
                    }
                    transactions.add(new Transaction(
                            rs.getInt("transaction_id"),
                            rs.getInt("Account_account_id"),
                            rs.getString("transaction_type"),
                            amountInt,
                            rs.getDate("transaction_date")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
