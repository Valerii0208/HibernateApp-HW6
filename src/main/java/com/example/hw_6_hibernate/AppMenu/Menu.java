package com.example.hw_6_hibernate.AppMenu;

import com.example.hw_6_hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Menu {
    @Autowired
    private UserRepository userRepository;

    private final String menu = """
             1. Create user
             --------------
             2. Update user
             --------------
             3. Delete user
             --------------
             4. Show user info
             --------------
             5. Show all users
             --------------
             0. Exit
             --------------
            """;

    public void runApp() {
        while (true) {
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    userRepository.save();
                    break;
                case 2:
                    userRepository.update();
                    break;
                case 3:
                    userRepository.delete();
                    break;
                case 4:
                    userRepository.getById();
                    break;
                case 5:
                    userRepository.getAll();
                    break;
            }
        }
    }
}
