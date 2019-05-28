package com.example.belajarintent;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.belajarintent.model.Orang;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity, btnMoveWithDataActivity, btnMoveWithObjectActivity, btnDialNumber, btnResultActivity;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActivity = findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);

        btnMoveWithObjectActivity = findViewById(R.id.btn_move_with_object_activity);
        btnMoveWithObjectActivity.setOnClickListener(this);

        btnDialNumber = findViewById(R.id.btn_dial_phone);
        btnDialNumber.setOnClickListener(this);

        btnResultActivity = findViewById(R.id.btn_result_activity);
        btnResultActivity.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Muhammad Isa Goutama");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 18);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_move_with_object_activity:
                Orang orang = new Orang();
                orang.setNama("Muhammad Isa Goutama");
                orang.setUmur(18);
                orang.setKota("Depok");

                Intent moveWithOjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithOjectIntent.putExtra(MoveWithObjectActivity.EXTRA_ORANG, orang);
                startActivity(moveWithOjectIntent);
                break;

            case R.id.btn_dial_phone:
                String phoneNumber = "081558802904";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_result_activity:
                Intent resultActivity = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(resultActivity, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == ResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(ResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil dipilih : %s", selectedValue));
            }
        }
    }
}
