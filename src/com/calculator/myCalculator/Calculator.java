package com.calculator.myCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Math;
import android.content.Context;
import android.os.Vibrator;

public class Calculator extends Activity {
    /** Called when the activity is first created. */
	
	final int MaxViewableNumber = 9999999;
	
	Button 		B1, B2, B3, B4, B5, B6, B7, B8, B9, B0, BSum, BDif, BMul, BDiv, BClear, BDot, BEqual;
	TextView 	Result;
	double 		num1=-1, 
				num2=-1, 
				result=0;
	char 		op=' ';
	int 		buttonPressed;
	
	boolean 	wrongOp = false;
	boolean 	dotPressed = false;
	boolean 	syntaxError = false;
	boolean 	noMoreNumbers = false;
	
	int 		countDecDigits=0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initLayout();
        final Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	final int vibrationDuration = 33;
    	
    	OnClickListener myListenerB1 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(1);
        		
        	}
        };
        
        OnClickListener myListenerB2 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(2);
        	}
        };

        OnClickListener myListenerB3 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(3);
        	}
        };

        OnClickListener myListenerB4 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(4);
        	}
        };

        OnClickListener myListenerB5 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(5);
        	}
        };

        OnClickListener myListenerB6 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(6);
        	}
        };

        OnClickListener myListenerB7 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(7);
        	}
        };

        OnClickListener myListenerB8 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(8);
        	}
        };

        OnClickListener myListenerB9 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(9);
        	}
        };

        OnClickListener myListenerB0 = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		NumPressed(0);
        	}
        };

        OnClickListener myListenerBSum = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		Log.v("Test click", "The button Sum has been pressed!");
        		ChangeOp("+");
        		OpPressed("+");
        	}
        };

        OnClickListener myListenerBDif = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		Log.v("Test click", "The button Dif has been pressed!");
        		ChangeOp("-");
        		OpPressed("-");
        	}
        };

        OnClickListener myListenerBMul = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		Log.v("Test click", "The button Mul has been pressed!");
        		ChangeOp("*");
        		OpPressed("*");
        	}
        };

        OnClickListener myListenerBDiv = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		Log.v("Test click", "The button Div has been pressed!");
        		ChangeOp("/");
        		OpPressed("/");
        	}
        };
        
        OnClickListener myListenerBDot = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
    			Log.v("Test click", "The button Dot has been pressed!");
    			if (num1==-1) {
    				num1=0;
    			}
    			else if (num2==-1 && op!=' ') {
    				num2=0;
    				Result.append("0");
    			}
    			if (syntaxError)
    				Result.setText("0.");
    			else if (!dotPressed)
    				Result.append(".");
    			if (num1==0 && num2==-1 && op==' ' && Float.parseFloat(Result.getText().toString())!=0) {
    				Result.setText("0");
    			}
    			syntaxError = false;
    			dotPressed = true;
        	}
        };

        OnClickListener myListenerBClear = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		Log.v("Test click", "The button Canc has been pressed!");
        		ClearAll();
        	}
        };
        
        OnClickListener myListenerBEqual = new OnClickListener() {
        	public void onClick(View v) {
        		mVibrator.vibrate(vibrationDuration);
        		Log.v("Test click", "The button Equal has been pressed!");
        		if (num1!=-1 && num2!=-1) {
        			switch(op) {
        				case('+'): 
        					result = num1 + num2;
        					PrintResult();
        					break;
        				case('-'):
        					result = num1 - num2;
        					PrintResult();
        					break;
        				case('*'):
        					result = num1 * num2;
        					PrintResult();
        					break;
        				case('/'):
        					result = num1 / num2;
        					PrintResult();
        					break;
        				default:
        					wrongOp = true;
        			}
        		}
        		else if (num1!=-1 && num2==-1 && op==' ') {
        			result = num1;
        			PrintResult();
        		}
        		else {
        			char c = Result.getText().toString().charAt(Result.getText().toString().length()-1);
        			if (c=='+' || c=='-' || c=='*' || c=='/') {
        				wrongOp = true;
        				Result.setText("Syntax Err.");
        				syntaxError = true;
        			}
        		}
        		num1 = -1;
    			num2 = -1;
    			op = ' ';
    			dotPressed = false;
    			noMoreNumbers = false;
    			countDecDigits=0;
        	}
        };
    	
        B1.setOnClickListener(myListenerB1);
    	B2.setOnClickListener(myListenerB2);
    	B3.setOnClickListener(myListenerB3);
    	B4.setOnClickListener(myListenerB4);
    	B5.setOnClickListener(myListenerB5);
    	B6.setOnClickListener(myListenerB6);
    	B7.setOnClickListener(myListenerB7);
    	B8.setOnClickListener(myListenerB8);
    	B9.setOnClickListener(myListenerB9);
    	B0.setOnClickListener(myListenerB0);
    	BSum.setOnClickListener(myListenerBSum);
    	BDif.setOnClickListener(myListenerBDif);
    	BMul.setOnClickListener(myListenerBMul);
    	BDiv.setOnClickListener(myListenerBDiv);
    	BDot.setOnClickListener(myListenerBDot);
    	BClear.setOnClickListener(myListenerBClear);
    	BEqual.setOnClickListener(myListenerBEqual);
    }
    
    public void onStart() {
    	super.onStart();
    }
    
    public void onResume() {
    	super.onResume();
    }
    
    public void onPause() {
    	super.onPause();
    }
    
    public void onStop() {
    	super.onStop();
    }
    
    public void onRestart() {
    	super.onRestart();
    }
    
    public void onDestroy() {
    	super.onDestroy();
    }
    
    private void initLayout() {
    	B1 = (Button)findViewById(R.id.button1);
    	B2 = (Button)findViewById(R.id.button2);
    	B3 = (Button)findViewById(R.id.button3);
    	B4 = (Button)findViewById(R.id.button4);
    	B5 = (Button)findViewById(R.id.button5);
    	B6 = (Button)findViewById(R.id.button6);
    	B7 = (Button)findViewById(R.id.button7);
    	B8 = (Button)findViewById(R.id.button8);
    	B9 = (Button)findViewById(R.id.button9);
    	B0 = (Button)findViewById(R.id.button0);
    	BSum = (Button)findViewById(R.id.buttonSum);
    	BDif = (Button)findViewById(R.id.buttonDif);
    	BMul = (Button)findViewById(R.id.buttonMul);
    	BDiv = (Button)findViewById(R.id.buttonDiv);
    	BClear = (Button)findViewById(R.id.buttonClear);
    	BDot = (Button)findViewById(R.id.buttonDot);
    	BEqual = (Button)findViewById(R.id.buttonEq);
    	Result = (TextView)findViewById(R.id.textView1);
    }
    
    private void PrintResult() {
    	long resultInt = Math.round(result);
    	if (result-resultInt==0)
			Result.setText(Double.toString(Math.round(result)).subSequence(0, Double.toString(result).indexOf(".")));
		else
			Result.setText(Double.toString(Math.round(result*1000.0)/1000.0));
    	if (result>MaxViewableNumber) {
    		Result.setText(Double.toString(result).subSequence(0, 3));
    		Result.append(Double.toString(result).subSequence(Double.toString(result).indexOf("E"), Double.toString(result).length()));
    	}
    	else if (result<-MaxViewableNumber) {
    		Result.setText(Double.toString(result).subSequence(0, 4));
    		Result.append(Double.toString(result).subSequence(Double.toString(result).indexOf("E"), Double.toString(result).length()));
    	}
    }
    
    private void NumPressed(int buttonPressed) {
    	Log.v("Test click", "The button " + buttonPressed + " has been pressed!");
		if (num1==-1) {
			num1 = buttonPressed;
			Result.setText(Integer.toString(buttonPressed));
		}
		else if (num2==-1 && !dotPressed && op!=' ') {
			num2 = buttonPressed;
			Result.append(Integer.toString(buttonPressed));
		}
		else if (op==' ') {
			if (dotPressed) {
				countDecDigits--;
				num1 = num1 + buttonPressed*(float)Math.pow(10, countDecDigits);
			}
			else {
				num1 = num1*10 + buttonPressed;
			}
			Result.append(Integer.toString(buttonPressed));
		}
		else if (op!=' ') {
			if (dotPressed) {
				countDecDigits--;
				num2 = num2 + buttonPressed*(float)Math.pow(10, countDecDigits);
			}
			else {
				num2 = num2*10 + buttonPressed;
			}
			Result.append(Integer.toString(buttonPressed));
		}
    }
    
    private void ChangeOp(String newOp) {
    	if(op!=' ' && noMoreNumbers && num2==-1) {
			op = newOp.charAt(0);
			Result.setText(Result.getText().toString().substring(0, Result.getText().toString().length()-1));
			Result.append(newOp);
		}
    }
    
    private void OpPressed(String insertedOp) {
    	while(!noMoreNumbers) {
    		if (Result.getText().toString().equals(Double.toString(Math.round(result*1000.0)/1000.0))) {
    			num1 = result;
    		}
    		else if (Result.getText().toString().equals(Integer.toString((int)result))) {
    			num1 = result;
    		}
    		if (num1==-1)
    			num1=0;
    		if (Result.getText().toString().charAt(Result.getText().length()-1)=='.')
    			Result.append("0");
    		dotPressed = false;
    		countDecDigits=0;
   			Result.append(insertedOp);
    		op = insertedOp.charAt(0);
    		noMoreNumbers = true;
		}
    }
    
    private void ClearAll() {
    	num1 = -1;
		num2 = -1;
		op = ' ';
		dotPressed = false;
		syntaxError = false;
		noMoreNumbers = false;
		countDecDigits=0;
		Result.setText("0");
    }
    
}