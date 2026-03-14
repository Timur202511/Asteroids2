package com.example.asteroids;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private ImageView bg1, bg2, rocket, asteroid1, asteroid2, asteroid3;

    private double offset = 0;
    private double asteroid1_x = 900 + Math.random() * 300;
    private double asteroid2_x = 900 + Math.random() * 300;
    private double asteroid3_x = 900 + Math.random() * 300;

    @FXML
    public void initialize() {
        Image background = new Image(getClass().getResourceAsStream("/images/background.jpg"));
        Image imagesAsteroid = new Image(getClass().getResourceAsStream("/images/asteroid.png"));
        rocket.setImage(new Image(getClass().getResourceAsStream("/images/rocket.png")));

        asteroid1.setImage(imagesAsteroid);
        asteroid2.setImage(imagesAsteroid);
        asteroid3.setImage(imagesAsteroid);
        asteroid1.setLayoutY(Math.random() * 540);
        asteroid2.setLayoutY(Math.random() * 540);
        asteroid3.setLayoutY(Math.random() * 540);
        bg1.setImage(background);
        bg2.setImage(background);
        bg2.setLayoutX(900);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {

                offset -= 1; // offset = offset - 1;
                if (offset <= -900) {
                    offset = 0;
                }
                asteroid1_x -= 2;
                asteroid1.setRotate(asteroid1_x);
                asteroid2.setRotate(asteroid2_x);
                asteroid3.setRotate(asteroid3_x);

                if (asteroid1_x <= -100) {
                    asteroid1_x = 900 + Math.random() * 300;
                    asteroid1.setLayoutY(Math.random() * 540);
                }
                asteroid1.setLayoutX(asteroid1_x);
                bg1.setLayoutX(offset);
                bg2.setLayoutX(offset + 900);

                asteroid2_x -= 2.2;

                if (asteroid2_x <= -100) {
                    asteroid2_x = 900 + Math.random() * 300;
                    asteroid2.setLayoutY(Math.random() * 540);
                }
                asteroid2.setLayoutX(asteroid2_x);
                bg1.setLayoutX(offset);
                bg2.setLayoutX(offset + 900);

                asteroid3_x -= 2.5;

                if (asteroid3_x <= -100) {
                    asteroid3_x = 900 + Math.random() * 300;
                    asteroid3.setLayoutY(Math.random() * 540);
                }
                asteroid3.setLayoutX(asteroid3_x);
                bg1.setLayoutX(offset);
                bg2.setLayoutX(offset + 900);
            }


        };
        timer.start();

    }

    public void handleKeyPressed(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.UP && rocket.getLayoutY() >= 0) {
            rocket.setLayoutY(rocket.getLayoutY() - 10);
            rocket.setRotate(85);
        }
        if (keyEvent.getCode() == KeyCode.DOWN && rocket.getLayoutY() <= 510) {
            rocket.setLayoutY(rocket.getLayoutY() + 10);
            rocket.setRotate(95);

        }
    }

    public void handleKeyReleased(KeyEvent keyEvent) {
        rocket.setRotate(90);
    }
}