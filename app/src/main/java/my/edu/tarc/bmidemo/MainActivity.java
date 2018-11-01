package my.edu.tarc.bmidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextHeight, editTextWeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        textViewResult = findViewById(R.id.textViewMessage);
        imageViewResult = findViewById(R.id.imageViewResult);
    }

    public void calculateBMI(View view){
        if(TextUtils.isEmpty(editTextHeight.getText())){
            editTextHeight.setError("Enter your body height");
            return;
        }
        if(TextUtils.isEmpty(editTextWeight.getText())){
            editTextWeight.setError("Enter your body weight");
            return;
        }

        double height = Double.parseDouble(editTextHeight.getText().toString());
        double weight = Double.parseDouble(editTextWeight.getText().toString());
        height /= 100; //Convert cm to m
        double bmi = weight / (height * height);

        if (bmi < 18.5){
            imageViewResult.setImageResource(R.drawable.under);
            textViewResult.setText("BMI: Underweight");
        } else if(bmi>=18.5 && bmi <=24.9) {
            imageViewResult.setImageResource(R.drawable.normal);
            textViewResult.setText("BMI: Normal");
        }else{
            imageViewResult.setImageResource(R.drawable.over);
            textViewResult.setText("BMI: Over weight");
        }
        imageViewResult.setVisibility(View.VISIBLE);
    }

    public void resetInput(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        imageViewResult.setImageResource(R.drawable.empty);
        textViewResult.setText(getString(R.string.welcome_message));
        imageViewResult.setVisibility(View.INVISIBLE);
    }
}
