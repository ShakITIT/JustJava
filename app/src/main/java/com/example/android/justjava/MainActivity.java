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
         import android.widget.TextView;
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
        quantity = quantity + 1;
        displayQuantity (quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity (100);
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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolatetyCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean getsChocolate = chocolatetyCheckBox.isChecked();
        Log.v("Main Activity", "give him chocolate" + getsChocolate);
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, getsChocolate);
        displayMessage(priceMessage);
        
    }

    /**
     * Calculates the price of the order.
     *
     * @ returning the total price.
     */
    private int calculatePrice() {
        int price = quantity * 6;
        return price;
    }

    /**
     * @param price of the order
     * @param addSomeWhippedCream is whether the customer wants whipped cream or not.
     * @param getsChocolate is for people who want chocolate added.
     * @ return text summary
     */
    private String createOrderSummary (int price, boolean addSomeWhippedCream, boolean getsChocolate){
        String priceMessage = "Name: Shak Dizzle";
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


