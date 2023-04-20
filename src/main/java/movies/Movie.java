/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movies;

import enums.Genre;
import enums.MPAA_Rating;
import java.util.HashMap;
/**
 *
 * @author Pratap Kumar
 */
public class Movie implements Comparable<Genre> {
    
    private String title;
    private Genre genre;
    private MPAA_Rating rating;
    private double collections;
    private HashMap<String, Actor> characters;
    
    public Movie(String title, Genre genre, MPAA_Rating rating, double collections) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.collections = collections;
        this.characters = new HashMap<String, Actor>();
    }
    
    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public MPAA_Rating getRating() {
        return rating;
    }

    public double getCollections() {
        return collections;
    }
    
    public void addCharacter(String characterName, Actor actor) {
        characters.put(characterName, actor);
    }
    
    public HashMap<String, Actor> getCast() {
        return characters;
    }

    public int compareTo(Genre genre) {
        return this.genre.compareTo(genre);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append("\n");
        sb.append("Genre: ").append(genre.toString()).append("\t");
        sb.append("Rating: ").append(rating.toString()).append("\n");
        sb.append("Collections: $").append(String.format("%.2f", collections)).append("\n");
        sb.append("Cast:\n");
        sb.append("------------------------------------------------------\n");
        sb.append(String.format("%-20s%s\n", "Character Played", "Actor Name"));
        sb.append("------------------------------------------------------\n");
        for (String characterName : characters.keySet()) {
            Actor actor = characters.get(characterName);
            sb.append(String.format("%-20s%s\n", characterName, actor.toString()));
        }
        sb.append("------------------------------------------------------\n");
        return sb.toString();
    }
}
