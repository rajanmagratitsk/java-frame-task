import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Mobile Phone Class
class MobilePhone {
    private int id;
    private String brand;
    private String model;
    private double price;
    private int quantity;
    
    public MobilePhone(int id, String brand, String model, double price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
}

// Main Shop Frame
public class MobileShopFrame extends JFrame {
    private List<MobilePhone> phoneList;
    private DefaultTableModel tableModel;
    private JTable phoneTable;
    
    // Input Fields
    private JTextField idField, brandField, modelField, priceField, quantityField;
    private JTextField searchField;
    private JLabel totalValueLabel;
    private JLabel totalPhonesLabel;
    
    public MobileShopFrame() {
        phoneList = new ArrayList<>();
        initializeUI();
        loadSampleData();
        updatePhoneTable();
        updateTotalValue();
    }
    
    private void initializeUI() {
        setTitle("Mobile Phone Shop Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input Panel
        mainPanel.add(createInputPanel(), BorderLayout.NORTH);
        
        // Table Panel
        mainPanel.add(createTablePanel(), BorderLayout.CENTER);
        
        // Control Panel
        mainPanel.add(createControlPanel(), BorderLayout.SOUTH);
        
        add(mainPanel);
        
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Phone Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Labels and Fields
        String[] labels = {"ID:", "Brand:", "Model:", "Price ($):", "Quantity:"};
        
        idField = new JTextField(10);
        brandField = new JTextField(15);
        modelField = new JTextField(15);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);
        
        JTextField[] fields = {idField, brandField, modelField, priceField, quantityField};
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.EAST;
            inputPanel.add(new JLabel(labels[i]), gbc);
            
            gbc.gridx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            inputPanel.add(fields[i], gbc);
        }
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton addButton = new JButton("Add Phone");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        
        addButton.addActionListener(e -> addPhone());
        updateButton.addActionListener(e -> updatePhone());
        deleteButton.addActionListener(e -> deletePhone());
        clearButton.addActionListener(e -> clearFields());
        
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(buttonPanel, gbc);
        
        return inputPanel;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
        tablePanel.setBorder(BorderFactory.createTitledBorder("Phone Inventory"));
        
        // Create table model
        String[] columns = {"ID", "Brand", "Model", "Price ($)", "Quantity", "Total Value"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        phoneTable = new JTable(tableModel);
        phoneTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        phoneTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                loadSelectedPhone();
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(phoneTable);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchPhones();
            }
        });
        searchPanel.add(searchField);
        
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchPhones());
        searchPanel.add(searchButton);
        
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshTable());
        searchPanel.add(refreshButton);
        
        tablePanel.add(searchPanel, BorderLayout.NORTH);
        
        return tablePanel;
    }
    
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new BorderLayout(10, 10));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Summary"));
        
        totalValueLabel = new JLabel("Total Inventory Value: $0.00");
        totalValueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalValueLabel.setForeground(new Color(0, 100, 0));
        
        totalPhonesLabel = new JLabel("Total Phone Models: 0");
        totalPhonesLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statsPanel.add(totalValueLabel);
        statsPanel.add(Box.createHorizontalStrut(20));
        statsPanel.add(totalPhonesLabel);
        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        
        controlPanel.add(statsPanel, BorderLayout.WEST);
        controlPanel.add(exitButton, BorderLayout.EAST);
        
        return controlPanel;
    }
    
    private void addPhone() {
        try {
            // Validate inputs
            if (idField.getText().trim().isEmpty() || brandField.getText().trim().isEmpty() ||
                modelField.getText().trim().isEmpty() || priceField.getText().trim().isEmpty() ||
                quantityField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int id = Integer.parseInt(idField.getText().trim());
            String brand = brandField.getText().trim();
            String model = modelField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            
            // Validate price and quantity
            if (price < 0 || quantity < 0) {
                JOptionPane.showMessageDialog(this, "Price and quantity cannot be negative!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check if ID already exists
            for (MobilePhone phone : phoneList) {
                if (phone.getId() == id) {
                    JOptionPane.showMessageDialog(this, "Phone with this ID already exists!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            MobilePhone newPhone = new MobilePhone(id, brand, model, price, quantity);
            phoneList.add(newPhone);
            updatePhoneTable();
            clearFields();
            updateTotalValue();
            
            JOptionPane.showMessageDialog(this, "Phone added successfully!");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID, Price, and Quantity!", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updatePhone() {
        int selectedRow = phoneTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a phone to update!", 
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());
            
            if (price < 0 || quantity < 0) {
                JOptionPane.showMessageDialog(this, "Price and quantity cannot be negative!", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            MobilePhone phone = phoneList.get(selectedRow);
            phone.setPrice(price);
            phone.setQuantity(quantity);
            
            updatePhoneTable();
            clearFields();
            updateTotalValue();
            
            JOptionPane.showMessageDialog(this, "Phone updated successfully!");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Price and Quantity!", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deletePhone() {
        int selectedRow = phoneTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a phone to delete!", 
                "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this phone?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            phoneList.remove(selectedRow);
            updatePhoneTable();
            clearFields();
            updateTotalValue();
            JOptionPane.showMessageDialog(this, "Phone deleted successfully!");
        }
    }
    
    private void loadSelectedPhone() {
        int selectedRow = phoneTable.getSelectedRow();
        if (selectedRow != -1 && selectedRow < phoneList.size()) {
            MobilePhone phone = phoneList.get(selectedRow);
            idField.setText(String.valueOf(phone.getId()));
            brandField.setText(phone.getBrand());
            modelField.setText(phone.getModel());
            priceField.setText(String.valueOf(phone.getPrice()));
            quantityField.setText(String.valueOf(phone.getQuantity()));
            
            // Make ID field non-editable when updating
            idField.setEditable(false);
        }
    }
    
    private void clearFields() {
        idField.setText("");
        brandField.setText("");
        modelField.setText("");
        priceField.setText("");
        quantityField.setText("");
        idField.setEditable(true);
        phoneTable.clearSelection();
    }
    
    private void updatePhoneTable() {
        tableModel.setRowCount(0);
        for (MobilePhone phone : phoneList) {
            Object[] row = {
                phone.getId(),
                phone.getBrand(),
                phone.getModel(),
                String.format("%.2f", phone.getPrice()),
                phone.getQuantity(),
                String.format("%.2f", phone.getPrice() * phone.getQuantity())
            };
            tableModel.addRow(row);
        }
        
        totalPhonesLabel.setText("Total Phone Models: " + phoneList.size());
    }
    
    private void searchPhones() {
        String searchText = searchField.getText().trim().toLowerCase();
        if (searchText.isEmpty()) {
            updatePhoneTable();
            return;
        }
        
        tableModel.setRowCount(0);
        for (MobilePhone phone : phoneList) {
            if (phone.getBrand().toLowerCase().contains(searchText) || 
                phone.getModel().toLowerCase().contains(searchText)) {
                Object[] row = {
                    phone.getId(),
                    phone.getBrand(),
                    phone.getModel(),
                    String.format("%.2f", phone.getPrice()),
                    phone.getQuantity(),
                    String.format("%.2f", phone.getPrice() * phone.getQuantity())
                };
                tableModel.addRow(row);
            }
        }
    }
    
    private void refreshTable() {
        searchField.setText("");
        updatePhoneTable();
    }
    
    private void updateTotalValue() {
        double total = 0;
        int totalQuantity = 0;
        for (MobilePhone phone : phoneList) {
            total += phone.getPrice() * phone.getQuantity();
            totalQuantity += phone.getQuantity();
        }
        totalValueLabel.setText(String.format("Total Inventory Value: $%.2f (Total Units: %d)", total, totalQuantity));
    }
    
    private void loadSampleData() {
        phoneList.add(new MobilePhone(101, "Apple", "iPhone 14", 999.99, 10));
        phoneList.add(new MobilePhone(102, "Samsung", "Galaxy S23", 899.99, 15));
        phoneList.add(new MobilePhone(103, "Google", "Pixel 7", 699.99, 8));
        phoneList.add(new MobilePhone(104, "OnePlus", "11", 799.99, 12));
        phoneList.add(new MobilePhone(105, "Xiaomi", "13 Pro", 599.99, 20));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new MobileShopFrame();
        });
    }
}