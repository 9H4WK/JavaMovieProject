/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movies;

/**
 *
 * @author Pratap Kumar
 */
public class Actor extends Person {
    
    private int age;
    private double remuneration;
    
    public Actor(String firstName, String lastName, int age, double remuneration) {
        super(firstName, lastName);
        this.age = age;
        this.remuneration = remuneration;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getRemuneration() {
        return remuneration;
    }
    
    @Override
    public int compareTo(Person other) {
        if (other instanceof Actor) {
            Actor otherActor = (Actor) other;
            return Double.compare(otherActor.remuneration, remuneration);
        } else {
//            return super.compareTo(other);
            return 1;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t\tAge: " + age;
    }
}
