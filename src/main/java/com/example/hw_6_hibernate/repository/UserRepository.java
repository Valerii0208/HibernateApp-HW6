package com.example.hw_6_hibernate.repository;

import com.example.hw_6_hibernate.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Scanner;

@Repository
@Transactional
public class UserRepository {
    Scanner scanner = new Scanner(System.in);
    @PersistenceContext
    private EntityManager entityManager;

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public void save() {
        System.out.println("Enter first name:");
        String inputFirstName = scanner.next();

        System.out.println("Enter last name:");
        String inputLastName = scanner.next();

        System.out.println("Enter city:");
        String inputCityName = scanner.next();

        System.out.println("Enter age:");
        int inputAge = scanner.nextInt();

        entityManager.persist(new User(inputFirstName, inputLastName, inputCityName, inputAge));
    }

    public void update() {
        System.out.println("Enter user id what you want to update");
        Long userId = scanner.nextLong();
        User user = findById(userId);

        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println("Enter new first name:");
            String newFirstName = scanner.next();

            System.out.println("Enter new last name:");
            String newLastName = scanner.next();

            System.out.println("Enter new city:");
            String newCity = scanner.next();

            System.out.println("Enter new age:");
            int newAge = scanner.nextInt();

            entityManager.merge(new User(userId, newFirstName, newLastName, newCity, newAge));
        }
    }

    public void delete() {
        System.out.println("Enter user id:");
        long userId = scanner.nextLong();
        User user = findById(userId);
        if (findById(userId) == null) {
            System.out.println("User not found");
        } else {
            entityManager.remove(user);
        }
    }

    public void getById() {
        System.out.println("Enter id:");
        long userId = scanner.nextLong();
        User user = findById(userId);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println(user);
        }
    }

    public void getAll() {
        Query getAll = entityManager.createQuery("SELECT u FROM User u");
        getAll.getResultList().forEach(System.out::println);
    }
}
