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
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        //display(quantity);
        //displayPrice(quantity * 5);
        //String priceMessage = "Total: $" + (quantity * 5);
        //priceMessage = priceMessage + "\nThank you!";
        //displayMessage(priceMessage);

        // January 2018
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));


    }

    /**
     * This method displays the given text on the screen
     */
    private void displayMessage(String message){

        TextView orderSummaryTextView = (TextView)findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quant) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quant);
    }

    /**
     * Increment quantity by one
     */
    public void increment(View view) {

        quantity +=1;
        displayQuantity(quantity);
    }

    /**
     * Decrease quantity by one
     */
    public void decrement(View view) {

        quantity-=1;
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order
     */
    private int calculatePrice() {

        return quantity * 5;

    }

    /**
     * Creates order summary
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price) {

        String priceMessage = "Name: Captain Slow";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
}