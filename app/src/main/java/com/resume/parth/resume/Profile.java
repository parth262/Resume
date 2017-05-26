package com.resume.parth.resume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {

    ImageView iv1;
    Spinner course;
    TextView pass_year;
    TextView marks_value;
    RelativeLayout rl;
    TranslateAnimation tra;
    TextView marks;
    String[] string = {"GTU", "G.S.H.E.B.", "G.S.E.B."};
    ArrayAdapter arrayAdapter;
    private List<Skills> skillsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Final aFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView = (RecyclerView) findViewById(R.id.rv1);
        aFinal = new Final(skillsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aFinal);

        prepareSkillsList();


        init();
        rl.startAnimation(tra);

        onClickListener();
    }



    private void init() {
        iv1 = (ImageView) findViewById(R.id.profile_pic);
        course = (Spinner) findViewById(R.id.courses);
        arrayAdapter = new ArrayAdapter(Profile.this, android.R.layout.simple_spinner_dropdown_item, string);
        course.setAdapter(arrayAdapter);
        pass_year = (TextView) findViewById(R.id.pass_year_value);
        marks = (TextView) findViewById(R.id.marks);
        marks_value = (TextView) findViewById(R.id.marks_value);
        rl = (RelativeLayout) findViewById(R.id.rl);
        tra = new TranslateAnimation(0,0,500,0);
        tra.setDuration(1000);


    }

    private void prepareSkillsList() {

        Skills skills = new Skills(R.drawable.c,"C");
        skillsList.add(skills);
        skills = new Skills(R.drawable.cpp,"C++");
        skillsList.add(skills);
        skills = new Skills(R.drawable.java,"JAVA");
        skillsList.add(skills);
        skills = new Skills(R.drawable.html,"HTML");
        skillsList.add(skills);
        skills = new Skills(R.drawable.css,"CSS");
        skillsList.add(skills);
        skills = new Skills(R.drawable.mysql,"MYSQL");
        skillsList.add(skills);
        skills = new Skills(R.drawable.android,"ANDROID STUDIO");
        skillsList.add(skills);

        aFinal.notifyDataSetChanged();




    }

    private void onClickListener() {
        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                switch (position) {
                    case 0:
                        pass_year.setText("Running");
                        marks.setText("CPI:");
                        marks_value.setText("7.7");
                        break;

                    case 1:
                        pass_year.setText("March-2014");
                        marks.setText("Percentile:");
                        marks_value.setText("97.03");
                        break;

                    case 2:
                        pass_year.setText("March-2012");
                        marks.setText("Percentile:");
                        marks_value.setText("97.59");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }
}

