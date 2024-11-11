package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class DemoController {

    List<Contact> contactsList = new ArrayList<>();

    @PostMapping("/addContact")
    String addContact(@RequestBody Contact contact) {
        for (Contact c : contactsList) {
            if (contact.getEmail().equals(c.getEmail())) {
                return "Contact already exists with this email!";
            }
        }
        contactsList.add(contact);
        return "Contact added successfully!";
    }

    @GetMapping("/getContactDetails")
    public Contact getContactDetails(@RequestParam String name) {
        for (Contact contact : contactsList) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        throw new IllegalArgumentException("Contact not found!");
    }

}
