package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView film, countFilms;
    int a = 0, tmp;
    ArrayList<String> arrayList;
    ArrayList<Integer> arrayInt = new ArrayList<>();

    /*
        10 фильмов, показывает фильм, нажимаем смотрели(Да/нет)
        убираем из списка, показываем снова пока не закончаться фильмы
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        film = findViewById(R.id.spin);
        countFilms = findViewById(R.id.lastfilm);
        Resources r = getResources();
        String[] s = r.getStringArray(R.array.films);
        arrayList = new ArrayList<>(Arrays.asList(s));
        tmp = arrayList.size();
    }

    public int random() {
        return (int) (Math.random() * arrayList.size());
    }

    @SuppressLint("SetTextI18n")
    public void nextFilm(View view) {
        a = random();
        if (arrayInt.contains(a)) a = random();
        else {
            film.setText(arrayList.get(a));
            arrayInt.add(a);
            tmp -= 1;
            countFilms.setText("Осталось " + tmp + " фильмов");
            if (tmp == 0) countFilms.setText("Фильмы закончились, сбросить?");
        }
    }

    @SuppressLint("SetTextI18n")
    public void reset(View view) {
        arrayInt.clear();
        countFilms.setText("Осталось 10 фильмов");
        //Toast.makeText(getApplicationContext(), Integer.toString(arrayInt.size()), Toast.LENGTH_SHORT).show();
        film.setText("Выберите фильм");
        tmp = arrayList.size();
    }
}