package com.mk.notificationpush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private EditText etToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToken = findViewById(R.id.etToken);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        System.out.println("La obtención del token de registro FCM falló");
                        return;
                    }
                    // Obtener el nuevo token de registro FCM
                    String token = task.getResult();
                    System.out.println(token);
                    Toast.makeText(MainActivity.this, "Token registrado: " + token, Toast.LENGTH_SHORT).show();
                    etToken.setText(token);
                });

    }
}