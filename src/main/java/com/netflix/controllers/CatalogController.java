package com.netflix.controllers;

import com.netflix.App;
import com.netflix.csvreader.MovieReader;
import com.netflix.csvreader.NoImageException;
import com.netflix.csvreader.SeriesReader;
import com.netflix.models.Movie;
import com.netflix.models.Series;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CatalogController {

    @FXML
    public FlowPane list;
    public ToggleGroup genre;
    public ToggleGroup type;

    @FXML
    public void initialize() {
        this.addMovies(this.getFilter());
    }

    @FXML
    public void filter() {
        RadioButton btn = (RadioButton) this.type.getSelectedToggle();
        this.clearList();

        if (btn.getText().equals("Movie")) {
            this.addMovies(this.getFilter());
        } else {
            this.addSeries(this.getFilter());
        }
    }

    public void addMovies(String filter) {
        MovieReader reader = new MovieReader(App.class.getResourceAsStream("assets/film.txt"));

        try {
            for (Movie m : reader.getAllMovies()) {
                if (!m.inGenre(filter)) continue;

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
        } catch (NoImageException e) {
            e.printStackTrace();
        }
    }

    public void addSeries(String filter) {
        SeriesReader reader = new SeriesReader(App.class.getResourceAsStream("assets/serier.txt"));

        try {
            for (Series s : reader.getAllSeries()) {
                if (!s.inGenre(filter)) continue;

                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/media.fxml"));

                VBox series = null;

                try {
                    series = fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Label lbl = (Label) series.lookup("#title");
                lbl.setText(s.getTitle());

                ImageView img = (ImageView) series.lookup("#img");
                Image image = null;

                image = new Image(s.getImageSrc());

                img.setImage(image);
                this.list.getChildren().add(series);
            }
        } catch (NoImageException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loginClicked() {
        System.out.println("login clicked");
    }

    @FXML
    public void movieSelect() {
        this.clearList();
        this.addMovies(this.getFilter());
    }

    @FXML
    public void seriesSelect() {
        this.clearList();
        this.addSeries(this.getFilter());
    }

    public void clearList() {
        this.list.getChildren().clear();
    }

    public String getFilter() {
        RadioButton btn = (RadioButton) this.genre.getSelectedToggle();
        return btn.getText();
    }
}
