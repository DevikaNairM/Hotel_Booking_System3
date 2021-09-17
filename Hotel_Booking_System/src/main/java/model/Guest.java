package model;

import org.checkerframework.checker.units.qual.A;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Guest {

    private String name;
    LocalDate dateOfBirth;
    //List<String> country;
   // List<String> language;
   // List<String> hobbies;
    String[] country;
    String[]language;
    String[] hobbies;

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getCountry() {
        return country;
    }

    public String[] getLanguage() {
        return language;
    }

    public Guest(String name, LocalDate dateOfBirth, String[] country, String[] language, String[] hobbies) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.language = language;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country=" + Arrays.toString(country) +
                ", language=" + Arrays.toString(language) +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public String[] getHobbies() {
        return hobbies;
    }
}
