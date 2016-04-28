package hobber.com.calculix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    enum op
    {
        no_op,
        add,
        minus,
        divide,
        multiply
    }

    String data1 = " ";
    String data2 = " ";

    String equation;
    op     operation = op.no_op;

    private boolean checkOperator(String data)
    {
        if(data.contains("+") || data.contains("-") || data.contains("*") || data.contains("/"))
            return true;

        return false;
    }

    public void click_button1(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "1";
        else
            equation += "1";

        if(checkOperator(equation))
            data2 += "1";
        else
            data1 += "1";

        //Log.v("calculix", "data1 is " + data1);
        //Log.v("calculix", "data2 is " + data2);

        tv.setText(equation);
    }

    public void click_button2(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "2";
        else
            equation += "2";

        if(checkOperator(equation))
            data2 += "2";
        else
            data1 += "2";

        tv.setText(equation);
    }

    public void click_button3(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "3";
        else
            equation += "3";

        if(checkOperator(equation))
            data2 += "3";
        else
            data1 += "3";

        tv.setText(equation);
    }
    public void click_button4(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "4";
        else
            equation += "4";

        if(checkOperator(equation))
            data2 += "4";
        else
            data1 += "4";

        tv.setText(equation);
    }
    public void click_button5(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "5";
        else
            equation += "5";

        if(checkOperator(equation))
            data2 += "5";
        else
            data1 += "5";

        tv.setText(equation);
    }
    public void click_button6(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "6";
        else
            equation += "6";

        if(checkOperator(equation))
            data2 += "6";
        else
            data1 += "6";

        tv.setText(equation);
    }
    public void click_button7(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "7";
        else
            equation += "7";

        if(checkOperator(equation))
            data2 += "7";
        else
            data1 += "7";

        tv.setText(equation);
    }
    public void click_button8(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "8";
        else
            equation += "8";

        if(checkOperator(equation))
            data2 += "8";
        else
            data1 += "8";

        tv.setText(equation);
    }
    public void click_button9(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "9";
        else
            equation += "9";

        if(checkOperator(equation))
            data2 += "9";
        else
            data1 += "9";

        tv.setText(equation);

    }
    public void click_button0(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            equation =  "0";
        else
            equation += "0";

        if(checkOperator(equation))
            data2 += "0";
        else
            data1 += "0";

        tv.setText(equation);
    }

    public void click_button_clear(View view)
    {
        data1 = "";
        data2 = "";
        operation = op.no_op;
        equation = "";
        TextView tv = (TextView) findViewById(R.id.display);
        tv.setText("0");
    }

    private int compute()
    {
        if(data1.isEmpty() || data2.isEmpty())
            return 1;

        double v1 = Double.parseDouble(data1);
        double v2 = Double.parseDouble(data2);
        double result = 0;

        switch (operation) {
            case add:
                result = v1 + v2;
                break;
            case minus:
                result = v1 - v2;
                break;
            case divide:
                result = v1 / v2;
                break;
            case multiply:
                result = v1 * v2;
                break;
            default:
                //TODO error.
                break;
        }

        data1 = String.valueOf(result);
        data2 = "";
        operation = op.no_op;

        equation = data1;

        return 0;
    }

    public void click_button_plus(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            return;

        if(operation != op.no_op)
            if(compute() != 0) return;

        equation += "+";

        operation = op.add;

        tv.setText(equation);

    }

    public void click_button_multi(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            return;

        if(operation != op.no_op)
            if(compute() != 0) return;

        equation += "*";

        operation = op.multiply;

        tv.setText(equation);
    }

    public void click_button_divide(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            return;

        if(operation != op.no_op)
            if(compute() != 0) return;

        equation += "/";

        operation = op.divide;

        tv.setText(equation);
    }

    public void click_button_minus(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            return;

        if(operation != op.no_op)
            if(compute() != 0) return;

        equation += "-";

        operation = op.minus;

        tv.setText(equation);
    }

    public void click_button_eq(View view)
    {
        CharSequence text;
        TextView tv = (TextView) findViewById(R.id.display);
        text = tv.getText();

        if(text.equals("0"))
            return;

        if(operation != op.no_op)
            compute();

        tv.setText(equation);
    }

    public void click_button_dot(View view)
    {
        //No operation.
    }
}
