package com.example.belajarintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_NAME = "extra_name";

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        int umur = getIntent().getIntExtra(EXTRA_AGE, 0);

        tvData = findViewById(R.id.tv_data);
        tvData.setText(nama +" : "+umur);
    }
}
