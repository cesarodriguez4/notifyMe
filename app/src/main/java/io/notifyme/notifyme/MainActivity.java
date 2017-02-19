package io.notifyme.notifyme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send_message(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.sms_send, Toast.LENGTH_SHORT);
        toast.show();
    }
}
