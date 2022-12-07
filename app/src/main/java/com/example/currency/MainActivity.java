package com.example.currency;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.currency.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Button btn_clear, btn_convert;
    private TextView tv_input, tv_output;
    private EditText txt_input, txt_output;
    private double input, output, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_convert = findViewById(R.id.btn_convert);
        btn_clear = findViewById(R.id.btn_clear);

        tv_input = findViewById(R.id.tv_input);
        tv_output = findViewById(R.id.tv_output);

        txt_input = findViewById(R.id.txt_input);
        txt_output = findViewById(R.id.txt_output);

        input = 0.0;
        output = 0.0;
        amount = 24000.0;

        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(txt_output.getText().toString().trim().length() == 0 ) {
                        input = Double.parseDouble(txt_input.getText().toString());
                        output = input * amount;
                        txt_output.setText("" + output);

                    }
                    if(txt_input.getText().toString().trim().length() == 0 ) {
                        input = Double.parseDouble(txt_output.getText().toString());
                        output = input / amount;
                        txt_input.setText("" + output);

                    }
                    if(txt_input.getText().toString().trim().length() + txt_output.getText().toString().trim().length()  == 0 ){
                        Toast.makeText (getApplicationContext() , "You didn't enter numbers", Toast.LENGTH_SHORT ).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }


        }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_input.setText("");
                txt_output.setText("");
                input = 0.0;
                output = 0.0;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}