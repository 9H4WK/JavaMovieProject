/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movies;

import enums.Genre;
import enums.MPAA_Rating;
import enums.Roles;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Pratap Kumar
 */
public class MovieDriver {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //Create MovieMapping object as mapper and initialize it.
        MovieMapping mapper = new MovieMapping();
        
        //Read given movies.txt and assign objects accordingly
        String fileName = "movies.txt";
        Scanner scanner = new Scanner(new File(fileName));
        
		//Start loop
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                //Create a Movie object as movie with given data from movies.txt
                Movie movie = new Movie(line, Genre.POETRY, MPAA_Rating.G, 0);
                if(line.equals("Movie")){
                    String title = scanner.nextLine();
                    String genre = scanner.nextLine();
                    String collecxnString = scanner.nextLine();
                    String rating = scanner.nextLine();
//                    System.out.println("Movies : " + title + " : " + convertMoneyToDouble(collecxnString));
                    movie = new Movie(title, Genre.valueOf(genre.toUpperCase()), MPAA_Rating.valueOf(rating), convertMoneyToDouble(collecxnString.toLowerCase()));
                }else if (line.equals("Actors")) {  // If "Actors"
                    line = scanner.nextLine();
                    String[] data = line.split("-");
                    if (!line.contains("-")) {
                        continue;
                    }
                    String characterName = line.split("-")[0];
                    String actorName = line.split("-")[1];
                    int age = Integer.parseInt(scanner.nextLine());
                    String remuneration = scanner.nextLine();
//                    System.out.println("Actors : " + characterName + " " + actorName + " " + age + " " + remuneration);
                    Actor actor = new Actor(actorName.split(" ")[0], actorName.split(" ")[0], age, convertMoneyToDouble(remuneration));        //Create an Actor object actor and add character name and actor object to the movie 
                    movie.addCharacter(characterName, actor);
                }else if (line.equals("Technicians")) {     // If "Technicians"
                    String technicianName = scanner.nextLine();
                    String technicianRole = scanner.nextLine();
//                    System.out.println("Technician : " + technicianName + " " + technicianRole);
                    //Create Technician object and add technician object to movie
                    Technician technician = new Technician(technicianName.split(" ")[0], technicianName.split(" ")[1], Roles.valueOf(technicianRole.toUpperCase().replace(" ", "_")));
                    mapper.addMovieCrewPerson(movie, (Technician)technician);
                }
            }//End loop
            
            
		
        //Print mapper
        System.out.println(mapper.toString());
        //Method call for getting all technicians of a given movie name
        mapper.getAllTechnicians("Baahubali: The Beginning");
        //Method call for getting character names of an actor in different movies
        mapper.getListOfCharacterNames("Shivudu");
        //Method call for getting all movie names of given actor name.
        mapper.getListOfMoviesAPersonActed("");
        //Method call for printing all actors in mapper
        mapper.getAllActors();
        //Method call printing list of all movies based on gross collections in descending order
        mapper.toString();
    }
    
    public static double convertMoneyToDouble(String moneyString) {
        String[] parts = moneyString.split(" ");
        double amount = Double.parseDouble(parts[0].replace("$", ""));
        String scale = parts[1].toLowerCase();
        switch (scale) {
            case "billion":
                amount *= 1000000000;
                break;
            case "million":
                amount *= 1000000;
                break;
            default:
                amount = 0;
        }
        return Double.parseDouble(String.format("%.2f", amount));
    }

    
}
