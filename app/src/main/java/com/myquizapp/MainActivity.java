package com.myquizapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.myquizapp.config.constants;
import com.myquizapp.data.Questions;
import com.myquizapp.databinding.ActivityMainBinding;
import com.myquizapp.helper.QuestionGenerator;

import java.security.PrivateKey;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    private RadioButton checkButtons[]=new RadioButton[4];
    int CurrentIndex=0;
    private CountDownTimer Timer;
    List<Questions> questions;
    private int TimeLeft= constants.TotalExamTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initComponents();
        StartTime();


    }
    private void SumbitTest(){
        Toast.makeText(this, "Sumbitted", Toast.LENGTH_SHORT).show();
    }
    private void StartTime() {
        Timer=new CountDownTimer(constants.TotalExamTime*1000,1000) {
            @Override
            public void onTick(long l) {
                int min = TimeLeft/60;
                int sec = TimeLeft%60;
                binding.timer.setText("Time left: "+min+" min "+sec+" sec");
                TimeLeft--;
                binding.circularProgressBar.setProgress((float)TimeLeft/constants.TotalExamTime*100);
            }

            @Override
            public void onFinish() {
//                Toast.makeText(MainActivity.this, "Time Finished", Toast.LENGTH_SHORT).show();
                SumbitTest();
                binding.timer.setText("Time Finished");
            }
        };
        Timer.start();
    }

    private void initComponents() {
        checkButtons[0]=binding.option1;
        checkButtons[1]=binding.option2;
        checkButtons[2]=binding.option3;
        checkButtons[3]=binding.option4;
        for(RadioButton button : checkButtons){
            button.setOnClickListener(this);
        }
        questions= QuestionGenerator.getQusetions();
        Questions questions1 = questions.get(CurrentIndex);

        SetQuestionToView(questions1,CurrentIndex);
        binding.nextButton.setOnClickListener(e->
        {
            nextQuestion();    
        });
        binding.previousButton.setOnClickListener(e->{
            previousQuestion();
        });
        binding.submitButton.setOnClickListener(e->{
            SumbitTest();
        });
    }

    private void previousQuestion() {
        CurrentIndex=CurrentIndex-1;
        if(CurrentIndex<0){
            Toast.makeText(this, "Its the first question", Toast.LENGTH_SHORT).show();
        }else{
            SetQuestionToView(questions.get(CurrentIndex),CurrentIndex);
        }
    }

    private void nextQuestion() {
        CurrentIndex=CurrentIndex+1;
        if(CurrentIndex>questions.size()-1){
            Toast.makeText(this, "Its last question", Toast.LENGTH_SHORT).show();
        }else{
            SetQuestionToView(questions.get(CurrentIndex),CurrentIndex);
        }
    }

    @Override
    public void onClick(View view) {
//        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        RadioButton ClickedButton = (RadioButton) view;
        for(RadioButton button:checkButtons){
            button.setChecked(button.getId() == ClickedButton.getId());
        }
        questions.get(CurrentIndex).setCheckvalue(ClickedButton.getId());
    }
    private void SetQuestionToView(Questions question,int index){
        //setting question to views

        binding.question.setText((CurrentIndex+1)+". "+question.getQuestion());
        binding.option1.setText(question.getOption1());
        binding.option2.setText(question.getOption2());
        binding.option3.setText(question.getOption3());
        binding.option4.setText(question.getOption4());
        for(RadioButton button:checkButtons){
            button.setChecked(questions.get(CurrentIndex).getCheckvalue() == button.getId());
        }
    }
}