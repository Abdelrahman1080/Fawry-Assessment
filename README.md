# 🛒 E-Commerce Mini-System

This Java-based mini e-commerce simulation models the core components of an online shopping system. It includes product management, shopping cart handling, customer balance checking, expiration and shipping verification, and a checkout system with a receipt printout.
org.example
```plaintext
org.example
├── cart
│   └── Cart
├── customer
│   └── Customer
├── product
│   ├── Product                         (Base class)
│   ├── ExpirableProduct                (extends Product)
│   ├── ShippableProduct                (extends Product, implements Shippable)
│   ├── ShippableAndExpirableProduct   (extends ExpirableProduct, implements Shippable)
│   └── Shippable                       (Interface)
└── services
    ├── CheckoutService                 (Business logic for checkout)
    └── ShippingServiceImpl            (Implements shipping logic)




 🧪 Test Cases

 ✅ Test Case 1: Successful Checkout

 ❌ Test Case 2: Insufficient Balance
**Expected Output**:
* ❗ `IllegalStateException`: "Insufficient balance"



### ❌ Test Case 3: Empty Cart
**Expected Output**:
 ❗ `IllegalStateException`: "Cart is empty"


### ❌ Test Case 4: Expired Product
**Expected Output**:
* ❗ `IllegalStateException`: "Product expired: Oldcheese"

### ❌ Test Case 5: Out of Stock
**Expected Output**:
* ❗ `IllegalArgumentException`: "Not enough stock for product: Newcheese"
