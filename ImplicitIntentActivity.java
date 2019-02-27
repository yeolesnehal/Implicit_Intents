package edu.sjsu.android.implicit_intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openURL = (Button)findViewById(R.id.openURL);
        Button dialNumber = (Button)findViewById(R.id.dialNumber);
        openURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText websiteURL = (EditText)findViewById(R.id.websiteURL);
                String webpage = websiteURL.getText().toString();
                if(!webpage.contains("http://www")){
                    webpage = "http://www." + webpage;
                }
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                startActivity(webIntent);

            }
        });


        dialNumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText phoneNumber = (EditText)findViewById(R.id.phoneNumber);
                Uri number = Uri.parse("tel:"+phoneNumber.getText().toString());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);

            }
        });
    }

    public void finishImplicitIntentActivity(View v) {
        ImplicitIntentActivity.this.finish();
    }
}
