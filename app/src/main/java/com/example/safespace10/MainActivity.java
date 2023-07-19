package com.example.safespace10;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String NUMERO1 = "123456789";
    private static final String NUMERO2 = "987654321";
    private static final String NUMERO3 = "555555555";

    private Button sosButton;
    private Button registroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sosButton = findViewById(R.id.sosButton);
        registroButton = findViewById(R.id.registroButton());

        sosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensajeSOS();
            }
        });

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registro.class);
                startActivity(intent);
            }
        });
    }

    private void enviarMensajeSOS() {
        String mensaje = "¡S.O.S! Necesito ayuda urgente.";

        SmsManager smsManager = SmsManager.getDefault();

        try {
            smsManager.sendTextMessage(NUMERO1, null, mensaje, null, null);
            smsManager.sendTextMessage(NUMERO2, null, mensaje, null, null);
            smsManager.sendTextMessage(NUMERO3, null, mensaje, null, null);

            Toast.makeText(this, "Mensaje de S.O.S enviado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al enviar el mensaje", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}


