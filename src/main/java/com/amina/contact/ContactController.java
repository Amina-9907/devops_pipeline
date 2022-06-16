package com.amina.contact;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="api/v1/contacts")
public class ContactController {
    private ContactService contactService;
    @Autowired
    public ContactController (ContactService contactService){
        this.contactService= contactService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Contact> getContacts(){
        return this.contactService.afficherContacts();
    }

    @PostMapping(path="/add")
    public void ajouterContact(@RequestBody Contact contact){
        contactService.ajouterContact(contact);
    }
    @DeleteMapping(path = "delete/{IdContact}")
    public void deleteContact(@PathVariable("IdContact") Long IdContact){
        contactService.deleteContact(IdContact);
    }

     @PutMapping(path = "update/{IdContact}")
    public void updateContact(
            @PathVariable ("IdContact")Long IdContact,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String numeroPhone,
            @RequestParam(required = false) String adresse,
            @RequestParam(required = false) String email) {
        contactService.updateContact( IdContact, nom, prenom, numeroPhone, adresse, email);

    }

}
