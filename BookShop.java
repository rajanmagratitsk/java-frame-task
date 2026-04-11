import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BookShop extends JFrame {
    JComboBox<String> bookBox;
    JTextField memberField;
    JTextArea receiptArea;
    JLabel totalLabel;
    ArrayList<String[]> sales = new ArrayList<>();
    
    // Book data: {title, price, genre}
    String[][] books = {
        {"Java Programming", "45", "Technical"},
        {"The Alchemist", "25", "Fiction"},
        {"Harry Potter", "30", "Fantasy"},
        {"Clean Code", "50", "Technical"},
        {"Sherlock Holmes", "20", "Mystery"}
    };
    
    public BookShop() {
        setTitle("📚 Book Shop - Member Purchase System");
        setSize(700, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Top Panel - Purchase
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        topPanel.setBorder(BorderFactory.createTitledBorder("📖 Purchase Books"));
        
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        topPanel.add(new JLabel("Select Book:"), gbc);
        gbc.gridx = 1;
        bookBox = new JComboBox<>();
        for (String[] b : books) {
            bookBox.addItem(b[0] + " - $" + b[1] + " (" + b[2] + ")");
        }
        topPanel.add(bookBox, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        topPanel.add(new JLabel("Member ID:"), gbc);
        gbc.gridx = 1;
        memberField = new JTextField(15);
        topPanel.add(memberField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        topPanel.add(new JLabel("Quantity:"), gbc);
        gbc.gridx = 1;
        JTextField qtyField = new JTextField(5);
        topPanel.add(qtyField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        JButton buyBtn = new JButton("🛒 Buy Book");
        buyBtn.setBackground(new Color(100, 150, 255));
        topPanel.add(buyBtn, gbc);
        
        // Center Panel - Receipt
        receiptArea = new JTextArea();
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        receiptArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("🧾 Purchase Receipt"));
        
        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        
        JPanel buttonPanel = new JPanel();
        JButton cancelBtn = new JButton("❌ Cancel Last");
        JButton clearBtn = new JButton("🗑️ Clear All");
        JButton printBtn = new JButton("🖨️ Print Receipt");
        JButton discountBtn = new JButton("🎁 Apply Discount");
        
        buttonPanel.add(cancelBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(discountBtn);
        buttonPanel.add(printBtn);
        
        totalLabel = new JLabel("Total: $0.00 | Member Discount: 0%", SwingConstants.RIGHT);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(totalLabel, BorderLayout.SOUTH);
        
        // Add to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Button Actions
        buyBtn.addActionListener(e -> {
            try {
                int idx = bookBox.getSelectedIndex();
                int qty = Integer.parseInt(qtyField.getText());
                if (qty <= 0) throw new Exception();
                
                String title = books[idx][0];
                double price = Double.parseDouble(books[idx][1]);
                String genre = books[idx][2];
                double total = price * qty;
                String memberId = memberField.getText().trim();
                if (memberId.isEmpty()) memberId = "Guest";
                
                sales.add(new String[]{title, String.valueOf(qty), String.format("%.2f", price), 
                                       String.format("%.2f", total), genre, memberId});
                updateReceipt();
                qtyField.setText("");
                memberField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(BookShop.this, "Enter valid quantity!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelBtn.addActionListener(e -> {
            if (!sales.isEmpty()) {
                sales.remove(sales.size() - 1);
                updateReceipt();
            }
        });
        
        clearBtn.addActionListener(e -> {
            sales.clear();
            updateReceipt();
        });
        
        discountBtn.addActionListener(e -> applyDiscount());
        
        printBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(BookShop.this, "📄 Receipt printed!\nThank you for shopping!", 
                                         "Print", JOptionPane.INFORMATION_MESSAGE);
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    void applyDiscount() {
        String[] options = {"10% (Member)", "20% (Premium)", "5% (Student)", "None"};
        int choice = JOptionPane.showOptionDialog(this, "Select Discount Type:", "Member Discount",
                     JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        double discount = 0;
        if (choice == 0) discount = 0.10;
        else if (choice == 1) discount = 0.20;
        else if (choice == 2) discount = 0.05;
        
        updateReceiptWithDiscount(discount);
    }
    
    void updateReceipt() {
        updateReceiptWithDiscount(0);
    }
    
    void updateReceiptWithDiscount(double discount) {
        receiptArea.setText("");
        double grandTotal = 0;
        
        if (sales.isEmpty()) {
            receiptArea.setText("📚 No purchases yet\nSelect a book and click 'Buy Book'");
        } else {
            receiptArea.append(String.format("%-25s %-8s %-10s %-12s %-10s\n", 
                "Book Title", "Qty", "Price", "Total", "Member ID"));
            receiptArea.append("------------------------------------------------------------------------\n");
            
            for (String[] sale : sales) {
                double itemTotal = Double.parseDouble(sale[3]);
                receiptArea.append(String.format("%-25s %-8s $%-9s $%-11s %-10s\n", 
                    sale[0], sale[1], sale[2], sale[3], sale[5]));
                grandTotal += itemTotal;
            }
            receiptArea.append("------------------------------------------------------------------------\n");
        }
        
        double discountAmount = grandTotal * discount;
        double finalTotal = grandTotal - discountAmount;
        
        if (discount > 0) {
            totalLabel.setText(String.format("Total: $%.2f | Discount: $%.2f (%.0f%%) | Final: $%.2f", 
                              grandTotal, discountAmount, discount * 100, finalTotal));
            receiptArea.append(String.format("\n💰 Subtotal: $%.2f\n", grandTotal));
            receiptArea.append(String.format("🎉 Discount (%d%%): -$%.2f\n", (int)(discount * 100), discountAmount));
            receiptArea.append(String.format("💵 FINAL TOTAL: $%.2f\n", finalTotal));
        } else {
            totalLabel.setText(String.format("Total: $%.2f | Member Discount: 0%%", grandTotal));
            receiptArea.append(String.format("\n💰 TOTAL: $%.2f\n", grandTotal));
        }
    }
    
    public static void main(String[] args) {
        new BookShop();
    }
}
