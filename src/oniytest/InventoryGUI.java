package oniytest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private ProductDatabase productDatabase;
private JTextField idField, nameField, priceField, quantityField, categoryField;
 public InventoryGUI() {
        productDatabase = new ProductDatabase();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Product Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
JSplitPane splitPane = new JSplitPane();
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        frame.getContentPane().add(splitPane);
        // Left panel for the table
        JPanel leftPanel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Price", "Quantity","Category"}, 0);
        table = new JTable(tableModel);
        loadTableData();

        JScrollPane scrollPane = new JScrollPane(table);
        leftPanel.add(scrollPane, BorderLayout.CENTER);
        // Create an empty panel
        JPanel emptyPanel = new JPanel();

// Add the split pane to the frame
        frame.getContentPane().add(splitPane, BorderLayout.CENTER);
// Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        splitPane.setLeftComponent(leftPanel);

        // Right panel - currently empty
        JPanel rightPanel = new JPanel();
        splitPane.setRightComponent(rightPanel);

        frame.setVisible(true);


        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id =Integer.parseInt( JOptionPane.showInputDialog("Enter Product ID:"));
                String name = JOptionPane.showInputDialog("Enter Product Name:");
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Product Price:"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Product Quantity:"));
                String catagory= JOptionPane.showInputDialog("Enter Product catagory:");

                Product product = new Product(id, name, price, quantity,catagory);
                productDatabase.addProduct(product);  // Save product to database
                tableModel.addRow(new Object[]{id, name, price, quantity,catagory});
            }
        });

        // Update Button Action
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) tableModel.getValueAt(selectedRow, 0);
                    String name = JOptionPane.showInputDialog("Enter New Product Name:", tableModel.getValueAt(selectedRow, 1));
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Enter New Product Price:", tableModel.getValueAt(selectedRow, 2)));
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter New Product Quantity:", tableModel.getValueAt(selectedRow, 3)));
                    String catagory= JOptionPane.showInputDialog("Enter Product catagory:", tableModel.getValueAt(selectedRow, 4));

                    Product product = new Product(id, name, price, quantity,catagory);
                    productDatabase.removeProduct(productDatabase.getProducts().get(selectedRow)); // Remove old product
                    productDatabase.addProduct(product); // Add updated product

                    tableModel.setValueAt(name, selectedRow, 1);
                    tableModel.setValueAt(price, selectedRow, 2);
                    tableModel.setValueAt(quantity, selectedRow, 3);
                    tableModel.setValueAt(catagory, selectedRow, 4);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a product to update.");
                }
            }
        });

        // Delete Button Action
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Product product = productDatabase.getProducts().get(selectedRow);
                    productDatabase.removeProduct(product); // Remove product from database
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a product to delete.");
                }
            }
        });

        frame.setVisible(true);
    }

    private void loadTableData() {
        for (Product product : productDatabase.getProducts()) {
            tableModel.addRow(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getQuantity(),product.getCategory()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryGUI::new);
    }
}

