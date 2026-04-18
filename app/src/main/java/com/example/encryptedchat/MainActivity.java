package com.example.encryptedchat;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        input = new EditText(this);
        input.setHint("Enter message");

        btn = new Button(this);
        btn.setText("Send");

        layout.addView(input);
        layout.addView(btn);

        setContentView(layout);

        btn.setOnClickListener(v -> {
            try {
                String msg = input.getText().toString();
                String enc = CryptoUtils.encrypt(msg);
                String dec = CryptoUtils.decrypt(enc);
                Toast.makeText(this, "Encrypted: " + enc + "\nDecrypted: " + dec, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
