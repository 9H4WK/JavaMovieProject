/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movies;

import java.util.Objects;
/**
 *
 * @author Pratap Kumar
 */
public abstract class Person implements Comparable<Person> {
    
    private String firstName;
    private String lastName;
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
//    public String getRole() {
//    if (this instanceof Technician) {
//        return ((Technician) this).getRole();
//    }
//    return null;
//}
    
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }
    
    @Override
    public abstract int compareTo(Person other);
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
