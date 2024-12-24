package com.example.maket;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float x1, x2;
    private static final int MIN_DISTANCE = 150; // Минимальная дистанция для свайпа

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим кнопки
        ImageButton likeButton = findViewById(R.id.like_button);
        ImageButton dislikeButton = findViewById(R.id.dislike_button);

        // Находим элемент для анимации свайпа
        View eventCard = findViewById(R.id.event_card);

        // Обработка нажатия на кнопку лайка
        likeButton.setOnClickListener(v -> {
            onSwipeRight(); // Свайп вправо
            animateSwipe(eventCard, "right"); // Анимация вправо
        });

        // Обработка нажатия на кнопку дизлайка
        dislikeButton.setOnClickListener(v -> {
            onSwipeLeft(); // Свайп влево
            animateSwipe(eventCard, "left"); // Анимация влево
        });
    }

    // Метод для обработки свайпа вправо
    private void onSwipeRight() {
        Toast.makeText(this, "Свайп вправо: сохранено", Toast.LENGTH_SHORT).show();
        // Добавьте логику для свайпа вправо
    }

    // Метод для обработки свайпа влево
    private void onSwipeLeft() {
        Toast.makeText(this, "Свайп влево: удалено", Toast.LENGTH_SHORT).show();
        // Добавьте логику для свайпа влево
    }

    // Метод для анимации свайпа
    private void animateSwipe(View view, String direction) {
        float translationX = direction.equals("right") ? view.getWidth() : -view.getWidth();
        view.animate()
                .translationX(translationX)
                .alpha(0)
                .setDuration(300)
                .withEndAction(() -> {
                    view.setTranslationX(0);
                    view.setAlpha(1);
                    // Обновление содержимого карточки (например, переключение на следующую)
                })
                .start();
    }}
