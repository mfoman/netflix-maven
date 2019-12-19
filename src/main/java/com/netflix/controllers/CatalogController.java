package com.netflix.controllers;

import com.netflix.App;
import com.netflix.csvreader.MovieReader;
import com.netflix.models.Movie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class CatalogController {

    @FXML
    public FlowPane list;

    @FXML
    public void initialize() {
        MovieReader reader = new MovieReader(App.class.getResourceAsStream("assets/film.txt"), ';');

        for (Movie m : reader.getAllMovies()) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/media.fxml"));

            VBox movie = null;

            try {
                movie = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Label lbl = (Label) movie.lookup("#title");
            lbl.setText(m.getTitle());

            ImageView img = (ImageView) movie.lookup("#img");
            Image image = null;

            image = new Image(m.getImageSrc());

            img.setImage(image);
            this.list.getChildren().add(movie);
        }
    }

    @FXML
    public void loginClicked() {
        System.out.println("login clicked");
    }

    @FXML
    public void movieSelect() {
        System.out.println("movies selected");
    }

    @FXML
    public void seriesSelect() {
        System.out.println("series selected");
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
