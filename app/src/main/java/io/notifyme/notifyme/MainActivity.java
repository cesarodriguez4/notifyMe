package io.notifyme.notifyme;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send_message(View view) {


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_DENIED) {

                Log.d("permission", "permission denied to SEND_SMS - requesting it");
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, 1);
            } else {
                newMessage();
            }
        }
    }

    public void newMessage() {
        EditText text = (EditText)findViewById(R.id.message);
        EditText number = (EditText)findViewById(R.id.phone_number);

        String message = text.getText().toString();
        String number_phone = number.getText().toString();


        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number_phone, null, message, null, null);

        Toast toast = Toast.makeText(getApplicationContext(), R.string.sending_sms, Toast.LENGTH_SHORT);
        toast.show();
    }

}
