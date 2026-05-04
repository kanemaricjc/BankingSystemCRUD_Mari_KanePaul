/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingsystemcrud_mari_kanepaul;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;


/**
 *
 * @author Kane
 */
public class BankingSystemCRUD_LastName_FirstName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        
        UIManager.put("Component.accentColor", new Color(0, 80, 157));
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.intercellSpacing", new Dimension(0, 1));
        UIManager.put("Component.arc", 10);
        UIManager.put("Table.selectionBackground", new Color(200, 220, 240));
        UIManager.put("Table.selectionForeground", Color.BLACK);
        FlatLightLaf.setup();
        
    } catch (Exception ex) {
        System.err.println("Failed to initialize FlatLaf");
    }
        java.awt.EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
    }
    
}
