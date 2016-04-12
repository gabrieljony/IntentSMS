package com.example.gabriel.intentmensagemsms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTexto;
    private Button btnEnviar;
    private ScrollView scvSMS;
    private EditText edtNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);

        edtTexto = (EditText)findViewById(R.id.edtTexto);
        edtNum = (EditText)findViewById(R.id.edtNum);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);
        scvSMS = (ScrollView)findViewById(R.id.scvSMS);

        btnEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("vnd.android-dir/mms-sms");
        i.putExtra("address", edtNum.getText().toString());
        i.putExtra("sms_body", edtTexto.getText().toString());
        startActivity(i);
        /*SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(edtNum.getText().toString(), null, edtTexto.getText().toString(), null, null);*/

    }
}
