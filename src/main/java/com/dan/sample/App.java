package com.dan.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ModelRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        repository.deleteAll();
        repository.save(new Model("TestString",1));
        repository.save(new Model("AnotherString",2));
        
        //findAll
        System.out.println("All Models: ");
        System.out.println("------------------");
        List<Model> allModels = repository.findAll();
        for(Model m : allModels) {
            System.out.println(m);
        }
        System.out.println("------------------\n");

        
        //find by string prop:
        System.out.println("Find by String prop: ");
        System.out.println("------------------");
        List<Model> foundByString = repository.findByaStringProp("TestString");
        for(Model m : foundByString) {
            System.out.println(m);
        }
        System.out.println("------------------\n");
       
        //find by int prop:
        System.out.println("Find by Int prop: ");
        System.out.println("------------------");
        List<Model> foundByInt = repository.findByanIntProp(1);
        for(Model m : foundByInt) {
            System.out.println(m);
        }
        System.out.println("------------------\n");

        
        //find by id
        System.out.println("Find by id: ");
        System.out.println("------------------");
        Model foundById = repository.findOne(allModels.get(0).getId());
        System.out.println(foundById);   
        System.out.println("------------------\n");

    }
}
