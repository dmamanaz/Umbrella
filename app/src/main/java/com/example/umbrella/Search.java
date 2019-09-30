package com.example.umbrella;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends Activity implements AdapterView.OnItemSelectedListener {
ImageView backBtn;
EditText getZip;
Spinner spinner;
String  myUnits;
int userZipCode;
TextView alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner = findViewById(R.id.sp_unit_switcher);
        backBtn = findViewById(R.id.iv_back_btn);
        getZip = findViewById(R.id.et_zipCodeEntry);
        alert = findViewById(R.id.tv_alert);
        SharedPreferences sharedPreferences = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
        userZipCode = sharedPreferences.getInt("zip", 0);
        if(userZipCode > 1000){
            String myZip = String.valueOf(userZipCode);
            getZip.setHint(myZip);
        }


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperature_option, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // Spinner click listener
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

backBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        try{
            String zip_string = getZip.getText().toString();
            int user_zip = new Integer(zip_string).intValue();

            SharedPreferences sharedPreferences= getSharedPreferences("Mydata", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("zip", user_zip);
            editor.putString("unit", myUnits);
            editor.commit();

        }catch (Exception e){
            Toast.makeText(Search.this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
        if(getZip.length() == 5){
            Intent intent = new Intent(Search.this, MainActivity.class);
            startActivity(intent);
            setResult(RESULT_OK, intent);
            finish();
        } else if (getZip.length() > 0){
            alert.setText("Enter 5 digit zip code");
        }
        else if(userZipCode > 1000){
            Intent intent = new Intent(Search.this, MainActivity.class);
            startActivity(intent);
            setResult(RESULT_OK, intent);
            finish();
        }
        else {
            alert.setText("Enter 5 digit zip code");
        }

    }
});
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                myUnits = "Celsius";
                break;
            case 1:
                myUnits = "Fahrenheit";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}
