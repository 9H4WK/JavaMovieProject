/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Pratap Kumar
 */
public enum MPAA_Rating {
    G("General Audiences", 0),
    NC_17("Adults Only", 18),
    PG("Parental Guidance Suggested", 12),
    PG_13("Parents Strongly Cautioned", 13),
    R("Restricted", 17);
    
    private final String description;
    private final int age;
    
    private MPAA_Rating(String description, int age) {
        this.description = description;
        this.age = age;
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getAge() {
        return age;
    }
}
