/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movies;

import java.util.*;
/**
 *
 * @author Pratap Kumar
 */
public class MovieMapping {
    
    private HashMap<Movie, LinkedList<Person>> movieMap;

    public MovieMapping() {
        movieMap = new HashMap<Movie, LinkedList<Person>>();
    }
    
    public HashMap<Movie, LinkedList<Person>> getMovieMap() {
        return movieMap;
    }
    
    public void addMovieCrewPerson(Movie movie, Person person) {
        LinkedList<Person> persons = movieMap.get(movie);
        if (persons == null) {
            persons = new LinkedList<Person>();
            movieMap.put(movie, persons);
        }
        persons.add(person);
    }
    
    public List<Movie> getListOfMoviesAPersonActed(String actorFullName) {
        List<Movie> movies = new ArrayList<Movie>();
        for (Map.Entry<Movie, LinkedList<Person>> entry : movieMap.entrySet()) {
            LinkedList<Person> persons = entry.getValue();
            for (Person person : persons) {
                if (person instanceof Actor && person.toString().equals(actorFullName)) {
                    movies.add(entry.getKey());
                    break;
                }
            }
        }
        return movies;
    }
    
    public List<Technician> getAllTechnicians(String movieName) {
        List<Technician> technicians = new ArrayList<Technician>();
        for (Map.Entry<Movie, LinkedList<Person>> entry : movieMap.entrySet()) {
            if (entry.getKey().getTitle().equals(movieName)) {
                LinkedList<Person> persons = entry.getValue();
                for (Person person : persons) {
                    if (person instanceof Technician) {
                        technicians.add((Technician) person);
                    }
                }
                break;
            }
        }
        return technicians;
    }
    
    public List<String> getListOfCharacterNames(String actor) {
        List<String> characterNames = new ArrayList<String>();
        for (Map.Entry<Movie, LinkedList<Person>> entry : movieMap.entrySet()) {
            LinkedList<Person> persons = entry.getValue();
            for (Person person : persons) {
                if (person instanceof Actor && person.toString().equals(actor)) {
                    for (Map.Entry<String, Actor> character : entry.getKey().getCast().entrySet()) {
                        if (character.getValue().equals(person)) {
                            characterNames.add(character.getKey());
                        }
                    }
                    break;
                }
            }
        }
        return characterNames;
    }
    
    public List<String> getAllActors() {
        List<String> actors = new ArrayList<String>();
        Set<Actor> actorSet = new HashSet<Actor>();
        for (Map.Entry<Movie, LinkedList<Person>> entry : movieMap.entrySet()) {
            LinkedList<Person> persons = entry.getValue();
            for (Person person : persons) {
                if (person instanceof Actor) {
                    actorSet.add((Actor) person);
                }
            }
        }
        for (Actor actor : actorSet) {
            actors.add(actor.toString());
        }
        return actors;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("******************************************************\n");
        sb.append("Details of all movies in mapper\n");
        for (Map.Entry<Movie, LinkedList<Person>> entry : movieMap.entrySet()) {
            sb.append("******************************************************\n");
            sb.append(entry.getKey().toString() + "\n");
            sb.append("Movie crew\n");
            sb.append("------------------------------------------------------\n");
            sb.append("Name\t\t\tRole\n");
            sb.append("------------------------------------------------------\n");
            LinkedList<Person> persons = entry.getValue();
            for (Person person : persons) {
                sb.append(String.format("%-20s\t%-20s\n", person.toString(), ((Technician) person).getRole()));
            }
        }
        return sb.toString();
    }
    
}
