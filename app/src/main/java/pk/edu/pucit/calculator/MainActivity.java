package pk.edu.pucit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;






    public class MainActivity extends AppCompatActivity {
        public static Double calculateResult(String expression) {
            if (expression == null || expression.length() == 0) {
                return null;
            }
            return calc(expression.replace(" ", ""));
        }

        public static Double calc(String expression) {

            if (expression.startsWith("(") && expression.endsWith(")")) {
                return calc(expression.substring(1, expression.length() - 1));
            }
            String[] containerArr = new String[]{expression};
            double leftVal = getNextOperand(containerArr);
            expression = containerArr[0];
            if (expression.length() == 0) {
                return leftVal;
            }
            char operator = expression.charAt(0);
            expression = expression.substring(1);

            while (operator == '*' || operator == '/') {
                containerArr[0] = expression;
                double rightVal = getNextOperand(containerArr);
                expression = containerArr[0];
                if (operator == '*') {
                    leftVal = leftVal * rightVal;
                } else {
                    leftVal = leftVal / rightVal;
                }
                if (expression.length() > 0) {
                    operator = expression.charAt(0);
                    expression = expression.substring(1);
                } else {
                    return leftVal;
                }
            }
            if (operator == '+') {
                return leftVal + calc(expression);
            } else {
                return leftVal - calc(expression);
            }

        }

        private static double getNextOperand(String[] exp) {
            double res;
            if (exp[0].startsWith("(")) {
                int open = 1;
                int i = 1;
                while (open != 0) {
                    if (exp[0].charAt(i) == '(') {
                        open++;
                    } else if (exp[0].charAt(i) == ')') {
                        open--;
                    }
                    i++;
                }
                res = calc(exp[0].substring(1, i - 1));
                exp[0] = exp[0].substring(i);
            } else {
                int i = 1;
                if (exp[0].charAt(0) == '-') {
                    i++;
                }
                while (exp[0].length() > i && isNumber((int) exp[0].charAt(i))) {
                    i++;
                }
                res = Double.parseDouble(exp[0].substring(0, i));
                exp[0] = exp[0].substring(i);
            }
            return res;
        }


        private static boolean isNumber(int c) {
            int zero = (int) '0';
            int nine = (int) '9';
            return (c >= zero && c <= nine) || c == '.';
        }




    private Button btn1, btn2,btn3,btn4,btn5,btn6, btn7,btn8, btn9, btn0, btnPlus, btnMinus, btnMul, btnDiv, btnDel, btnPercent, btnEqual, btnAC, btnPoint, btndb0;
    TextView eq;
    TextView res;
    String inputField = "";
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button) findViewById(R.id.zero);
        btn1 = (Button) findViewById(R.id.one);
        btn2 = (Button) findViewById(R.id.two);
        btn3 = (Button) findViewById(R.id.three);
        btn4 = (Button) findViewById(R.id.four);
        btn5 = (Button) findViewById(R.id.five);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.seven);
        btn8 = (Button) findViewById(R.id.eight);
        btn9 = (Button) findViewById(R.id.nine);
        btnPlus = (Button) findViewById(R.id.plus);
        btnMinus = (Button) findViewById(R.id.minus);
        btnMul = (Button) findViewById(R.id.multiply);
        btnDiv = (Button) findViewById(R.id.divide);
        btnAC = (Button) findViewById(R.id.AC);
        btndb0 = (Button) findViewById(R.id.doubleZero);
        btnPercent = (Button) findViewById(R.id.percent);
        btnPoint = (Button) findViewById(R.id.point);
        btnDel = (Button) findViewById(R.id.del);
        btnEqual = (Button) findViewById(R.id.equal);
        eq = (TextView) findViewById(R.id.tv_equation);
        res = (TextView) findViewById(R.id.tv_result);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField = inputField + '1';
                eq.setText(inputField);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField = inputField + '2';
                eq.setText(inputField);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField = inputField + '3';
                eq.setText(inputField);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField = inputField + '4';
                eq.setText(inputField);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputField = inputField + '5';
                eq.setText(inputField);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputField = inputField + '6';
                eq.setText(inputField);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputField = inputField + '7';
                eq.setText(inputField);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputField = inputField + '8';
                eq.setText(inputField);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputField = inputField + '9';
                eq.setText(inputField);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputField = inputField + '0';
                eq.setText(inputField);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                int leng = inputField.length() - 1;
                if (leng >= 0) {
                    char lastIndex = inputField.charAt(leng);
                    if (lastIndex == '+' || lastIndex == '-' || lastIndex == '*' || lastIndex == '/' || lastIndex == '%') {
                        String temp = "";
                        for (int i = 0; i < leng; i++) {
                            temp = temp + inputField.charAt(i);
                        }
                        inputField = temp + "+";
                        eq.setText(inputField);
                    } else {
                        inputField = inputField + '+';
                        eq.setText(inputField);
                    }


                } else {
                    inputField = inputField + '+';
                    eq.setText(inputField);
                }

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                int leng = inputField.length() - 1;
                if (leng >= 0) {
                    char lastIndex = inputField.charAt(leng);
                    if (lastIndex == '+' || lastIndex == '-' || lastIndex == '*' || lastIndex == '/' || lastIndex == '%') {
                        String temp = "";
                        for (int i = 0; i < leng; i++) {
                            temp = temp + inputField.charAt(i);
                        }
                        inputField = temp + '-';
                        eq.setText(inputField);
                    } else {
                        inputField = inputField + '-';
                        eq.setText(inputField);
                    }


                } else {
                    inputField = inputField + '-';
                    eq.setText(inputField);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                int leng = inputField.length() - 1;
                if (leng >= 0) {
                    char lastIndex = inputField.charAt(leng);
                    if (lastIndex == '+' || lastIndex == '-' || lastIndex == '*' || lastIndex == '/' || lastIndex == '%') {
                        String temp = "";
                        for (int i = 0; i < leng; i++) {
                            temp = temp + inputField.charAt(i);
                        }
                        inputField = temp + '*';
                        eq.setText(inputField);
                    } else {
                        inputField = inputField + '*';
                        eq.setText(inputField);
                    }


                } else {
                    eq.setText("");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = false;
                try {
                    int leng = inputField.length() - 1;
                    if (leng >= 0) {
                        char lastIndex = inputField.charAt(leng);
                        if (lastIndex == '+' || lastIndex == '-' || lastIndex == '*' || lastIndex == '/' || lastIndex == '%') {
                            String temp = "";
                            for (int i = 0; i < leng; i++) {
                                temp = temp + inputField.charAt(i);
                            }
                            inputField = temp + '/';
                            eq.setText(inputField);
                        } else {
                            inputField = inputField + '/';
                            eq.setText(inputField);
                        }


                    } else {
                        eq.setText("");
                    }
                } catch (Exception e) {
                    return;
                }
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int leng = inputField.length() - 1;
                if (leng >= 0) {
                    char lastIndex;
                    lastIndex = inputField.charAt(leng);
                    if (lastIndex == '+' || lastIndex == '-' || lastIndex == '*' || lastIndex == '/') {
                        return;

                    } else {
                        String num = "";
                        while (leng >= 0) {
                            if (lastIndex != '+' && lastIndex != '-' && lastIndex != '*' && lastIndex != '/') {
                                num = lastIndex + num;
                                leng--;
                                lastIndex = inputField.charAt(leng);
                            } else {
                                float res = Float.parseFloat(num);
                                res = res / 100;
                                String str = Float.toString(res);
                                num = "";
                                String temp = "";
                                for (int i = 0; i <= leng; i++) {
                                    temp = temp + inputField.charAt(i);
                                }

                                inputField = temp + str;
                                eq.setText(inputField);
                                return;
                            }
                        }

                    }


                }

                else {
                    eq.setText("");
                }

            }


        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int leng = inputField.length() - 1;
                if (leng >= 0) {
                    if (inputField.charAt(leng) == '.') {
                        flag = false;

                    }
                    String temp = "";
                    for (int i = 0; i < leng; i++) {
                        temp = temp + inputField.charAt(i);
                    }
                    inputField = temp;
                    eq.setText(inputField);
                } else {
                    eq.setText("");
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num=(calculateResult(inputField));
                String str=Double.toString(num);
                res.setText(str);

            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eq.setText("");
                res.setText(" ");
                inputField = "";
                flag = false;
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == false) {
                    inputField = inputField + '.';
                    eq.setText(inputField);
                    flag = true;
                }
            }
        });


        btndb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField = inputField + "00";
                eq.setText(inputField);
            }
        });

    }


}
