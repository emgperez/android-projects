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
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    // Topping choices
    boolean withCream = false;
    boolean withChocolate = false;

    // Cup price
    //int cupPrice = 0;


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

        //getToppingState(view);

        CheckBox creamTopping = (CheckBox)findViewById(R.id.whipped_cream_topping);
        CheckBox chocolateTopping = (CheckBox)findViewById(R.id.chocolate_topping);
        boolean wCream = creamTopping.isChecked();
        boolean wChocolate = chocolateTopping.isChecked();

        EditText textName= (EditText)findViewById(R.id.user_name);
        String username = textName.getText().toString();



        int price = calculatePrice(wCream, wChocolate);

        // Log the values
        Log.v("MainActivity", "Has whipped cream: " + wCream);
        Log.v("MainActivity", "Has whipped cream: " + wChocolate);
        Log.v("MainActivity", "Name: " + username);

        displayMessage(createOrderSummary(username, price, wCream, wChocolate));

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
    private void displayQuantity(int figure) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + figure);
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
     * @param creamTopping value of whipped cream topping
     * @param chocolateTopping value of chocolate topping
     */
    private int calculatePrice(boolean creamTopping, boolean chocolateTopping) {

        int cupPrice = 0;

        // Modify the price depending on the chosen topping
        if (creamTopping && chocolateTopping){
            cupPrice = 8;
        } else if (creamTopping) {
            cupPrice = 6;
        } else if (chocolateTopping) {
            cupPrice = 7;
        } else
            cupPrice = 5;

        return quantity * cupPrice;

    }

    /**
     * Get topping check box state
     */
    private void getToppingState(View view)
    {
        CheckBox creamTopping = (CheckBox)findViewById(R.id.whipped_cream_topping);
        CheckBox chocolateTopping = (CheckBox)findViewById(R.id.chocolate_topping);
        withCream = creamTopping.isChecked();
        withChocolate = chocolateTopping.isChecked();

    }

    /**
     * Creates order summary
     *
     * @param price of the order
     * @param toppingOne topping for whipped cream
     * @param toppingTwo topping for chocolate
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean toppingOne, boolean toppingTwo) {

        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + toppingOne;
        priceMessage += "\nAdd chocolate? " + toppingTwo;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
}