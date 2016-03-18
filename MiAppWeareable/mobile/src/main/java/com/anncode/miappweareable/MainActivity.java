package com.anncode.miappweareable;

import android.app.Notification;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int ID_NOTIFICATION = 1;
    EditText edtTextoNotificacion;
    public void enviarNotificacion(View v){
        //Codigo para enviar una notificacion al Watch
        edtTextoNotificacion = (EditText) findViewById(R.id.edtTextoNotificacion);
        String mensaje = edtTextoNotificacion.getText().toString();

        if (mensaje.isEmpty())
                mensaje = getResources().getString(R.string.mensaje_generico);

        NotificationCompat.WearableExtender wearNotification = new NotificationCompat.WearableExtender();

        Notification notificacion = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getResources().getString(R.string.titulo_notificacion))
                .setContentText(mensaje)
                .extend(wearNotification)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplication());
        notificationManagerCompat.notify(ID_NOTIFICATION, notificacion);
    }
}
