package com.asierla.das_entrega;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String valor = "eu";
        if (extras != null) {
            valor= extras.getString("idioma");
        }
        // Configurar el idioma antes de cargar la vista (opcional)
        Locale nuevaloc = new Locale(valor);
        Locale.setDefault(nuevaloc);
        Configuration configuration =
                getBaseContext().getResources().getConfiguration();
        configuration.setLocale(nuevaloc);
        configuration.setLayoutDirection(nuevaloc);

        Context context =
                getBaseContext().createConfigurationContext(configuration);
        getBaseContext().getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 🔹 Configurar los botones después de cargar la interfaz
        Button btnSpanish = findViewById(R.id.btnSpanish);
        Button btnEuskara = findViewById(R.id.btnEuskara);

        btnSpanish.setOnClickListener(v -> {
            finish();
            getIntent().putExtra("idioma", "es");
            startActivity(getIntent());
        });

        btnEuskara.setOnClickListener(v -> {
            finish();
            getIntent().putExtra("idioma", "eu");
            startActivity(getIntent());
        });
    }

    // Método para cambiar el idioma
    public void setLocale(Context context, String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
