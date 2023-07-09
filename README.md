**ShoppingCart**

Build with mvn clean install.

Run application with java -jar ./target/shopping-cart.jar <<path-to-product-list-file>> for example:

    java -jar ./target/shopping-cart.jar sampleinput.txt


Sample Input
Apple
Banana
Orange
Papaya

Sample Output
Product name|Unit price(INR)|Quantity  |Price(INR)
----------------------------------------------------
Banana              |2           |1         |2         
Orange              |5           |1         |5         
Papaya              |10          |1         |10        
Grapes              |12          |1         |12
----------------------------------------------------
                          Total price(INR): |29 
