/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author Pratap Kumar
 */
public enum Genre {
    BIOGRAPHY(3),
    DRAMA(5),
    FANTASY(3),
    HORROR(17),
    MYSTERY(10),
    POETRY(1),
    ROMANCE(12),
    SCIENCE_FICTION(8),
    THRILLER(13);
    
    private final int age;
    
    private Genre(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
}

//int age = enums.Genre.HORROR.getAge();

