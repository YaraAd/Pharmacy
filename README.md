# Pharmacy Management System

A simple Java-based pharmacy management project that allows managing products, inventory, and receipts. This project demonstrates object-oriented programming, file serialization, and basic data handling in Java.

## Features

### Product Management
- Add, remove, and list products (medicine or cosmetic).

### Inventory Management
- Track product quantities, check availability, and reduce stock when products are sold.

### User and Receipt Management
- Create receipts for purchases, apply user discounts, and calculate total prices.

### Data Persistence
- Product data is saved and loaded from a file (`products.dat`) using Java Serialization.

## Project Structure

- **Product.java** – Represents a product with ID, name, price, quantity, and category.  
- **ProductDatabase.java** – Handles storage and retrieval of products using serialization.  
- **Inventory.java** – Manages stock and product availability.  
- **Receipt.java** – Generates receipts for purchases and calculates totals.  
- **User.java** – Represents a user and manages discount eligibility.  
- **Cosmetic.java / Medicine.java** – Specialized product classes.  

## Usage

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
