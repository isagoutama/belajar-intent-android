package com.example.belajarintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.belajarintent.model.Orang;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static final String EXTRA_ORANG = "extra_orang";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = findViewById(R.id.tv_object);

        Orang orang = getIntent().getParcelableExtra(EXTRA_ORANG);
        tvObject.setText(orang.getNama()+" "+orang.getUmur()+" "+orang.getKota());
    }
}
