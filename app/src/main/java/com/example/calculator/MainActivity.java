package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tvEnteredExpression;
    private StringBuilder currentInput = new StringBuilder(); // Store the current input expression
    private String enteredExpression = ""; // Store the entered expression

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        tvEnteredExpression = findViewById(R.id.tvEnteredExpression);

        // Set click listeners for all buttons
        Button[] buttons = {
                findViewById(R.id.btn0), findViewById(R.id.btn1), findViewById(R.id.btn2),
                findViewById(R.id.btn3), findViewById(R.id.btn4), findViewById(R.id.btn5),
                findViewById(R.id.btn6), findViewById(R.id.btn7), findViewById(R.id.btn8),
                findViewById(R.id.btn9), findViewById(R.id.btnDecimal), findViewById(R.id.btnAdd),
                findViewById(R.id.btnSubtract), findViewById(R.id.btnMultiply),
                findViewById(R.id.btnDivide), findViewById(R.id.btnClear), findViewById(R.id.btnClearAll),
                findViewById(R.id.btnEqual)
        };

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick(v);
                }
            });
        }
    }

    public void onButtonClick(View view) {
        String buttonText = ((Button) view).getText().toString();

        switch (buttonText) {
            case "Clear All":
                currentInput.setLength(0);
                enteredExpression = "";
                tvResult.setText("");
                break;
            case "Clear":
                if (currentInput.length() > 0) {
                    currentInput.deleteCharAt(currentInput.length() - 1);
                }
                break;
            case "=":
                calculateResult();
                break;
            default:
                currentInput.append(buttonText);
                break;
        }

        // Update the TextViews
        tvEnteredExpression.setText(currentInput.toString() + enteredExpression);
    }

    private void calculateResult() {
        try {
            enteredExpression = currentInput.toString(); // Save the entered expression
            Expression expression = new ExpressionBuilder(currentInput.toString()).build();
            double result = expression.evaluate();
            currentInput.setLength(0); // Clear the current input
            // Show the result in tvResult
            tvResult.setText(String.valueOf(result));
        } catch (ArithmeticException | IllegalArgumentException e) {
            // Handle errors during evaluation (e.g., division by zero)
            tvResult.setText("Error");
        }
    }
}
