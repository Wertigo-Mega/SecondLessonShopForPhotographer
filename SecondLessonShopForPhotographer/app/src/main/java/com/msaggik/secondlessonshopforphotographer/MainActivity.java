package com.msaggik.secondlessonshopforphotographer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создадим поля
    private float korge = 10; // бисквитные коржы
    private int korgeDiscount = 26; // скидка на коржы
    private float slivki = 14; // сливки
    private int slivkiDiscount = 5; // скидка на сливки
    private float frech = 3; // фрукты
    private int frechDiscount = 12; // скидка на фрукты
    private float opex = 5; // орехи
    private int opexDiscount = 12; // скидка на орехи
    private float berries = 7; // ягоды
    private int berriesDiscount = 19; // скидка на данный объектив
    private float uvFilter = 50; // UV фильтр
    private float account = 45; // баланс на счету

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить фото-комплект
            possibilityOut.setText("Имеется достаточно средств для покупки");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки");
            balanceOut.setText(" - ");
        }
    }

    // метод подсчёта стоимости фото-комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (korge * (100 - korgeDiscount) + slivki * (100 - slivkiDiscount)
                + frech * (100 - frechDiscount) + opex * (100 - opexDiscount)
                + berries * (100 - berriesDiscount)) / 100 + uvFilter * 3;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки фото-комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить фото-комплект
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }
}