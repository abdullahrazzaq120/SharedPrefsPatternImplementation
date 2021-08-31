package com.example.sharedprefspatternimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView name, email, id, tenant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameId);
        email = findViewById(R.id.emailId);
        id = findViewById(R.id.idId);
        tenant = findViewById(R.id.tenantId);

        showPrefsData();
    }

    private void showPrefsData() {
        User model = SharedPrefsDeployment.getUserAuth(getApplicationContext());

        email.setText(model.getEmail() + "");
        id.setText(model.getId() + "");
        name.setText(model.getName() + "");
        tenant.setText(model.getTenant() + "");
    }

    public void saveAll(View view) {
        User model = new User();
        model.setEmail("abdullah@gmail.com");
        model.setTenant("Abdullah123Tenant");
        model.setName("Abdullah Razzaq");
        model.setId(199);

        SharedPrefsDeployment.saveUserAuth(model, getApplicationContext(), SharedPrefrenceConstants.ALL_PREFS);

        new Handler().postDelayed(() -> {
            finish();
            startActivity(getIntent());
            overridePendingTransition(0, 0);
        }, 500);
    }

    public void removeAll(View view) {
        SharedPrefsDeployment.removeFile(getApplicationContext(), SharedPrefrenceConstants.ALL_PREFS);
        finish();
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }
}