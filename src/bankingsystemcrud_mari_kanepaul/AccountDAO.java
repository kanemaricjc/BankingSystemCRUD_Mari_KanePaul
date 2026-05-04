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

public class AccountDAO {

    public boolean addAccount(Account account) {
        
        String sql = "INSERT INTO account (Customer_customer_id, account_type, balance) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerid());
            stmt.setString(2, account.getAccounttype());
            stmt.setLong(3, account.getBalance());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("account_id"),
                        rs.getInt("Customer_customer_id"), 
                        rs.getString("account_type"),
                        rs.getInt("balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public boolean updateAccountBalance(int accountId, int newBalance) {
        String sql = "UPDATE account SET balance=? WHERE account_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newBalance);
            stmt.setInt(2, accountId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAccount(int accountId) {
        String sql = "DELETE FROM account WHERE account_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> searchAccounts(String keyword) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT a.* FROM account a JOIN customer c ON a.Customer_customer_id = c.customer_id " +
                     "WHERE c.first_name LIKE ? OR c.last_name LIKE ? OR CAST(a.account_id AS CHAR) LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    accounts.add(new Account(
                            rs.getInt("account_id"),
                            rs.getInt("Customer_customer_id"),
                            rs.getString("account_type"),
                            rs.getInt("balance")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
    public Account getAccountById(int accountId) {
        String sql = "SELECT * FROM account WHERE account_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, accountId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Account(
                            rs.getInt("account_id"),
                            rs.getInt("Customer_customer_id"),
                            rs.getString("account_type"),
                            rs.getInt("balance")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<AccountDetails> getAllAccountsWithNames() {
    List<AccountDetails> list = new ArrayList<>();
    String sql = "SELECT a.account_id, c.first_name, c.last_name, c.email, c.phone_number, a.account_type, a.balance " +
                 "FROM Account a JOIN Customer c ON a.Customer_customer_id = c.customer_id";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            list.add(new AccountDetails(
                rs.getInt("account_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("account_type"),
                rs.getLong("balance")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    
}
