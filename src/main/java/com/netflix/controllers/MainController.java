package com.netflix.controllers;

import com.netflix.App;
import com.netflix.csvreader.MovieReader;
import com.netflix.csvreader.SeriesReader;
import com.netflix.models.Movie;
import com.netflix.models.Series;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private ListView listView1;

    @FXML
    private ListView listView2;

    @FXML
    private ListView listView3;

    @FXML
    private ListView listView4;

    @FXML
    private Button login;

    @FXML
    private ImageView imageView;


    MovieReader mr = new MovieReader(App.class.getResourceAsStream("assets/film.txt"), ';');
    List<Movie> mlist = mr.getAllMovies();

    SeriesReader sr = new SeriesReader(App.class.getResourceAsStream("assets/serier.txt"), ';');
    List<Series> slist = sr.getAllSeries();

    public void initialize(){

        ObservableList<String> titlelistfilm = FXCollections.observableArrayList();
        ObservableList<String> titlelistserier = FXCollections.observableArrayList();

        for(Movie movie:mlist){
            titlelistfilm.add(movie.getTitle());
        }

        for(Series series:slist){
            titlelistserier.add(series.getTitle());
        }

        ObservableList<String> film1 = FXCollections.observableArrayList(titlelistfilm.subList(0,25));
        ObservableList<String> film2 = FXCollections.observableArrayList(titlelistfilm.subList(25,50));
        ObservableList<String> film3 = FXCollections.observableArrayList(titlelistfilm.subList(50,75));
        ObservableList<String> film4 = FXCollections.observableArrayList(titlelistfilm.subList(75,100));

        ObservableList<String> serier1 = FXCollections.observableArrayList(titlelistserier.subList(0,25));
        ObservableList<String> serier2 = FXCollections.observableArrayList(titlelistserier.subList(25,50));
        ObservableList<String> serier3 = FXCollections.observableArrayList(titlelistserier.subList(50,75));
        ObservableList<String> serier4 = FXCollections.observableArrayList(titlelistserier.subList(75,100));

        ObservableList<String> FilmSerierList1 = FXCollections.observableArrayList();
        FilmSerierList1.addAll(film1);
        FilmSerierList1.addAll(serier1);

        ObservableList<String> FilmSerierList2 = FXCollections.observableArrayList();
        FilmSerierList2.addAll(film2);
        FilmSerierList2.addAll(serier2);

        ObservableList<String> FilmSerierList3 = FXCollections.observableArrayList();
        FilmSerierList3.addAll(film3);
        FilmSerierList3.addAll(serier3);

        ObservableList<String> FilmSerierList4 = FXCollections.observableArrayList();
        FilmSerierList4.addAll(film4);
        FilmSerierList4.addAll(serier4);

        listView1.setOrientation(Orientation.HORIZONTAL);
        listView1.setItems(FilmSerierList1);
        listView2.setOrientation(Orientation.HORIZONTAL);
        listView2.setItems(FilmSerierList2);
        listView3.setOrientation(Orientation.HORIZONTAL);
        listView3.setItems(FilmSerierList3);
        listView4.setOrientation(Orientation.HORIZONTAL);
        listView4.setItems(FilmSerierList4);

        ArrayList<String[]> genrelistfilm = new ArrayList<>();

        for (Movie movie:mlist){
            genrelistfilm.add(movie.getGenre());
        }

        List<String> genrearray = new ArrayList<String>();
        for (Object obj : genrelistfilm) {
            if (obj instanceof String[]) {
                String[] strArray = (String[]) obj;
                //System.out.println(Arrays.toString(strArray));
                String newStringfilm = Arrays.toString(strArray);
                newStringfilm = newStringfilm.substring(1,newStringfilm.length()-1);
                genrearray.add(newStringfilm.substring(1,newStringfilm.length()-1));


            }
        }

        String[] genrelistelist = {"Crime", "Drama", "Drama", "Biography", "Drama", "History", "Biography", "Drama", "Sport", "Drama", "Romance", "War", "Drama", "Mystery", "Drama", "History", "Romance", "Adventure", "Family", "Fantasy", "Drama", "Adventure", "Biography", "Drama", "Mystery", "Romance", "Thriller", "Horror", "Mystery", "Thriller", "Crime", "Drama", "Crime", "Drama", "Thriller", "Drama", "Film-Noir", "Drama", "Romance", "Biography", "Drama", "Family", "Musical", "Crime", "Drama", "Crime", "Drama", "Action", "Adventure", "Family", "Adventure", "Sci-fi", "Family", "Sci-fi", "Crime", "Drama", "Thriller", "Drama", "Mystery", "Thriller", "Adventure", "Drama", "War","Comedy", "Musical", "Romance", "Drama", "Family", "Fantasy", "Comedy", "War", "Comedy", "Romance", "Adventure", "Drama", "History", "Drama", "War", "Biography", "Drama", "History", "Action", "Adventure", "Drama", "Action", "Adventure", "Drama", "Drama", "Romance", "Drama", "Romance", "War", "Drama", "War", "Drama", "Western", "Action", "Adventure", "Drama", "Sport", "Drama", "Comedy", "Romance", "Crime", "Drama", "Drama", "Musical", "Romance", "Drama", "Romance", "War", "Drama", "Family", "Musical", "Crime", "Drama", "Sci-fi", "Drama", "Romance", "War", "Adventure", "Drama", "Western", "Adventure", "Drama", "Thriller", "Biography", "Drama", "War", "Biography", "Crime", "Drama", "Adventure", "Drama", "Western", "Western", "Comedy", "Drama", "Romance", "Drama", "War", "Action", "Drama", "Thriller", "Biography", "Drama", "History", "Adventure", "Drama", "Western", "Adventure", "Sci-fi", "Thriller", "Horror", "Biography", "Drama", "Music", "Crime", "Drama", "Drama", "War", "Drama", "War", "Action", "Biography", "Crime", "Action", "Crime", "Drama", "Comedy", "Drama", "Romance", "Comedy", "Romance", "Drama", "Romance", "Drama", "Comedy", "Drama", "Drama", "Comedy", "Romance", "Crime", "Drama", "Thriller", "Drama", "Western", "Drama", "Western", "Drama", "History", "Crime", "Drama", "Fantasy", "Drama", "Sci-fi", "Comedy", "Drama", "Music", "Drama", "Comedy", "Drama", "Romance", "Comedy", "Drama", "Crime", "Drama", "Comedy", "Drama", "Drama", "Romance", "Adventure", "Drama", "Romance", "Adventure", "Western", "Adventure", "Biography", "Drama", "Comedy", "Drama", "War", "Crime", "Drama", "Film-Noir", "Film-Noir", "Mystery","Drama", "Romance", "Crime", "Drama", "Mystery", "Thriller", "Film-Noir", "Mystery", "Thriller", "Drama", "Adventure", "Mystery", "Thriller", "Biography", "Drama", "Musical"};
        List<String> genrelisteList = Arrays.asList(genrelistelist);
        Set<String> uniqueL = new HashSet<String>();
        uniqueL.addAll(genrelisteList);
        Integer numberOfUniqueStrings = uniqueL.size();
        System.out.println(numberOfUniqueStrings);
        System.out.println(uniqueL);

        List<File> fileimgs = new ArrayList<>();
        String[] chaArray = {"&", "And", "and"};
        List<String> chalist = Arrays.asList(chaArray);

        List<Image> listOfImages = FXCollections.observableArrayList();
        for(Movie movie:mlist){
            listOfImages.add(new Image(movie.getImageSrc()));
        }

        listView1.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();

            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                for (Movie movie :mlist){
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        imageView.setImage(new Image(movie.getImageSrc()));
                        setText(name);
                        setGraphic(imageView);
                    }
                }
            }
        });
    }

    @FXML
    public void seSerier(){
        ObservableList<String> titlelistserier = FXCollections.observableArrayList();

        for(Series series:slist){
            titlelistserier.add(series.getTitle());
        }

        ObservableList<String> serier1 = FXCollections.observableArrayList(titlelistserier.subList(0,25));
        ObservableList<String> serier2 = FXCollections.observableArrayList(titlelistserier.subList(25,50));
        ObservableList<String> serier3 = FXCollections.observableArrayList(titlelistserier.subList(50,75));
        ObservableList<String> serier4 = FXCollections.observableArrayList(titlelistserier.subList(75,100));

        listView1.setOrientation(Orientation.HORIZONTAL);
        listView1.setItems(serier1);
        listView2.setOrientation(Orientation.HORIZONTAL);
        listView2.setItems(serier2);
        listView3.setOrientation(Orientation.HORIZONTAL);
        listView3.setItems(serier3);
        listView4.setOrientation(Orientation.HORIZONTAL);
        listView4.setItems(serier4);
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
        page1Stage.setScene(scene);
        page1Stage.show();
    }

    @FXML
    public void seActionfilm() {
        HashMap<String, String[]> map = new HashMap<String, String[]>();
        String[] genrearray = {};

        ObservableList<String> obserAction = FXCollections.observableArrayList();
        for (Movie movie:mlist){
            map.put(movie.getTitle(),movie.getGenre());
            //genrearray.add(movie.getGenre());
        }

        HashMap<String, String> map1 = new HashMap<String, String>();
        List<String> species = new ArrayList<>();
        for (Movie movie:mlist) {
            for (Map.Entry me : map.entrySet()) {
                species.add(me.getValue().toString());
                if (species.contains(Arrays.toString(movie.getGenre()))) {
                    map1.put(me.getKey().toString(), (String) me.getValue());

                }

            }
        }
        System.out.println(species);
    }

    @FXML
    public void seAdventurefilm() {

    }

    @FXML
    public void seBiofilm() {

    }
    @FXML
    public void seNoirfilm() {

    }
    @FXML
    public void seHorrorfilm() {

    }
    @FXML
    public void seRomancefilm() {

    }

    @FXML
    public void seWarfilm() {

    }

    @FXML
    public void seHistoryfilm() {

    }

    @FXML
    public void seWesternfilm() {

    }

    @FXML
    public void seSportfilm() {

    }

    @FXML
    public void seSciFifilm() {

    }

    @FXML
    public void seDramafilm() {

    }

    @FXML
    public void seThrillerfilm() {

    }

    @FXML
    public void seMusicfilm() {

    }

    @FXML
    public void seCrimefilm() {

    }
    @FXML
    public void seFantasyfilm() {

    }
    @FXML
    public void seFamilyfilm() {

    }
    @FXML
    public void seMysteryfilm() {

    }
    @FXML
    public void seComedyfilm() {

    }
    @FXML
    public void seMusicalfilm() {

    }

    @FXML public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked on " + listView1.getSelectionModel().getSelectedItem());
    }

}
