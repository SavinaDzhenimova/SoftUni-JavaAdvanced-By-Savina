package p07_Google;

import java.util.ArrayList;

public class Person {
    String name;
    ArrayList<Pokemon> pokemons;
    ArrayList<Parents> parents;
    ArrayList<Children> children;
    Car car;
    Company company;

    public Person() {
    }

    public Person(String name, ArrayList<Pokemon> pokemons, ArrayList<Parents> parents,
                  ArrayList<Children> children) {
        this.name = name;
        this.parents = parents;
        this.pokemons = pokemons;
        this.children = children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public ArrayList<Parents> getParents() {
        return parents;
    }

    public void printFormat(){
        System.out.println(name);
        System.out.println("Company:");
        if (company!=null) {
            System.out.println(company.format());
        }

        System.out.println("Car:");
        if (car!=null) {
            System.out.println(car.format());
        }

        System.out.println("Pokemon:");
        if (!getPokemons().isEmpty()) {
            getPokemons().forEach(pokemon -> System.out.printf("%s%n", pokemon.format()));
        }

        System.out.println("Parents:");
        if (!getParents().isEmpty()) {
            getParents().forEach(parent -> System.out.printf("%s%n", parent.format()));
        }

        System.out.println("Children:");
        if (!getChildren().isEmpty()) {
            getChildren().forEach(children -> System.out.printf("%s%n", children.format()));
        }
    }
}