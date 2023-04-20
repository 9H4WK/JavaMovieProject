/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movies;

import enums.Roles;
/**
 *
 * @author Pratap Kumar
 */
public class Technician extends Person {
    
    private Roles role;
    
    public Technician(String firstName, String lastName, Roles role) {
        super(firstName, lastName);
        this.role = role;
    }
    
    public Roles getRole() {
        return role;
    }
    
    @Override
    public int compareTo(Person other) {
        if (other instanceof Technician) {
            Technician otherTechnician = (Technician) other;
            return role.compareTo(otherTechnician.role);
        } else {
//            return super.compareTo(other);
            return 1;
        }
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "\t\t" + role.name();
    }
    
}
