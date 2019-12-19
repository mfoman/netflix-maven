package com.netflix.controllers;

import com.netflix.App;
import com.netflix.csvreader.MovieReader;
import com.netflix.models.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private BorderPane borderPane;

    @FXML
    private ListView listview1;

    @FXML
    private ListView listview2;

    @FXML
    private ListView listview3;

    @FXML
    private ListView listview4;

    @FXML
    private Button login;

    @FXML
    public void search(ActionEvent e) {
        System.out.println("lolololo");
    }

    @FXML
    public void handleloginbutton() {
        Stage page1Stage = new Stage();
        page1Stage.setTitle("Log in");

        GridPane grid = new GridPane();

        TextField brugernavn = new TextField();
        TextField kode = new TextField();
        brugernavn.setPromptText("Brugernavn:");
        kode.setPromptText("Kode:");

        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(brugernavn, kode);

        grid.getChildren().add(hbox1);

        Scene scene = new Scene(grid);
    }

    @FXML
    public void sefilm(){
        BorderPane pane = new BorderPane();
        VBox filmv = new VBox();
        ListView listFilm = new ListView();
        InputStream inputStream = App.class.getResourceAsStream("assets/film.txt");
        MovieReader mr = new MovieReader(inputStream, ';');
        List<Movie> mlist = mr.getAllMovies();
        ArrayList<String> titlelist = new ArrayList<>();
        for(Movie movie:mlist){
            titlelist.add(movie.getTitle());
        }

        listFilm.getItems().add(titlelist);
        filmv.getChildren().add(listFilm);
        pane.getChildren().add(filmv);

        Parent root = pane;

        Stage stage1 = new Stage();
        stage1.setTitle("Film");

        stage1.setScene(new Scene(root));
        stage1.show();
    }

    @FXML
    public void seSerier(){
        BorderPane pane2 = new BorderPane();
        VBox serier1 = new VBox();
        ListView listserier = new ListView();

        serier1.getChildren().addAll(listserier);
        pane2.getChildren().addAll(serier1);

        Parent root2 = pane2;

        Stage stage2 = new Stage();
        stage2.setTitle("Serier");

        stage2.setScene(new Scene(root2));
        stage2.show();
    }
}
