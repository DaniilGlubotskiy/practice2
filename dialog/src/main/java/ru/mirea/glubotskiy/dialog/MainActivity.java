package ru.mirea.glubotskiy.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    ProgressDialog loadingDialogBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loading = findViewById(R.id.Progress);
        loadingDialogBar = new ProgressDialog(this);

        loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialogBar.ShowDialog("Loading");
            }
        });

        Button timePicker = findViewById(R.id.TimePicker);
        timePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePick = new TimePickerFragment();
                timePick.show(getSupportFragmentManager(),"time picker");
            }
        });

        Button datePicker = findViewById(R.id.DatePicker);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePick = new DatePickerFragment();
                datePick.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute){
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(hour + ": " + minute);
    }

    public void onClickShowDialog(View view) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(),"Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(),"Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }

    public void onCanselClicked() {
        Toast.makeText(getApplicationContext(),"Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
}