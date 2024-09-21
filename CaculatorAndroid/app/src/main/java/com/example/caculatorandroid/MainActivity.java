package com.example.caculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Stack;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private TextView tvInput;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInput = findViewById(R.id.tvInput);

        initializeButtons();
    }

    private void initializeButtons() {
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide,
                R.id.btnDot, R.id.btnLeftParen, R.id.btnRightParen
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(v -> appendToInput(button.getText().toString()));
        }

        findViewById(R.id.btnEqual).setOnClickListener(v -> evaluateExpression());
        findViewById(R.id.btnDelete).setOnClickListener(v -> clearInput());
        findViewById(R.id.btnBackspace).setOnClickListener(v -> backspace());
    }

    private void appendToInput(String value) {
        input.append(value);
        tvInput.setText(input.toString());
    }

    private void clearInput() {
        input.setLength(0);
        tvInput.setText("");
    }

    private void backspace() {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
            tvInput.setText(input.toString());
        }
    }

    private void evaluateExpression() {
        try {
            BigDecimal result = evaluate(input.toString());
            tvInput.setText(result.stripTrailingZeros().toPlainString());
            input.setLength(0);
            input.append(tvInput.getText());
        } catch (Exception e) {
            tvInput.setText("Error");
            input.setLength(0);
        }
    }

    // Expression evaluation logic
    public BigDecimal evaluate(String expression) {
        Stack<BigDecimal> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i++));
                }
                i--;
                values.push(new BigDecimal(numBuilder.toString()));
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (isOperator(c)) {
                while (!ops.empty() && hasPrecedence(c, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    private BigDecimal applyOp(char op, BigDecimal b, BigDecimal a) {
        switch (op) {
            case '+': return a.add(b);
            case '-': return a.subtract(b);
            case '*': return a.multiply(b);
            case '/':
                if (b.compareTo(BigDecimal.ZERO) == 0)
                    throw new ArithmeticException("Division by zero");
                return a.divide(b, 10, RoundingMode.HALF_UP);
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}