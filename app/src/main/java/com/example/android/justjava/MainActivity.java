/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/

 package com.example.android.justjava;



         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.EditText;
         import android.widget.TextView;
         import android.widget.Toast;

         import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity ==100){
     // Show an error message as toast
            Toast.makeText(this, "U cannot overdose on our coffee", Toast.LENGTH_SHORT).show();
     // Exit this message early b/c there's nothing left to do.
            return;
        }
        quantity = quantity + 1;
        displayQuantity (quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
     // Show an error message as toast
            Toast.makeText(this, "U must try some of our coffee", Toast.LENGTH_SHORT).show();
            // Exit this message early b/c there's nothing left to do.
            return;
        }
        quantity = quantity - 1;
        displayQuantity (quantity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "NAME IN FIELD AT TOP:" + name);

     // See if the customer wants whipped cream.
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

     //See if the customer wants chocolate
        CheckBox chocolatetyCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean getsChocolate = chocolatetyCheckBox.isChecked();
        Log.v("Main Activity", "give him chocolate" + getsChocolate);

        int price = calculatePrice(hasWhippedCream, getsChocolate);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, getsChocolate);
        displayMessage(priceMessage);
        
    }

    /**
     * Calculates the price of the order.
     * @ add price of whipped cream
     * @ add price of chocolate
     * @ returning the total price.
     */
    private int calculatePrice(boolean hasWhippedCream, Boolean getsChocolate) {
     // Price of 1 cup of coffee
        int basePrice = 5;

     // Add $1 if the customer wants whipped cream
        if (hasWhippedCream){
            basePrice = basePrice + 1;

        }

     // Add $2 if the customer wants chocolate
        if (getsChocolate){
            basePrice = basePrice + 2;

        }

     // Calculate the total order price by multiplying by quantity
        return quantity * basePrice;
    }

    /**
     * @param name of the customer
     * @param price of the order
     * @param addSomeWhippedCream is whether the customer wants whipped cream.
     * @param getsChocolate is for people who want chocolate added.
     * @ return text summary
     */
    private String createOrderSummary (String name, int price, boolean addSomeWhippedCream, boolean getsChocolate){
        String priceMessage = "Name:" + name;
        priceMessage += "\nAdd some whipped cream? " + addSomeWhippedCream;
        priceMessage += "\nGets Chocolate? " + getsChocolate;
        priceMessage = priceMessage + "\nQuantity:" + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThanks, Bitch!";
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }
}


