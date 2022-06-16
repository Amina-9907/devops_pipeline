package com.amina.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {

        this.contactRepository = contactRepository;
    }

    public List<Contact> afficherContacts() {

        return contactRepository.findAll();
    }

    public void ajouterContact(Contact contact) {
        Optional<Contact> contactOptional = contactRepository.findContactByNumeroPhone(contact.getNumeroPhone());
        if (contactOptional.isPresent()) {
            throw new IllegalStateException("numeroPhone existant");
        }
        contactRepository.save(contact);

    }

    public void deleteContact(Long IdContact) {
        boolean exist = contactRepository.existsById(IdContact);
        if (!exist) {
            throw new IllegalStateException("le contact n'existe pas");
        }
        contactRepository.deleteById(IdContact);
    }

    @Transactional
    public Contact updateContact(Long IdContact, String prenom, String nom,
                                 String numeroPhone, String adresse, String email) {
        Contact contact = contactRepository.findById(IdContact).orElseThrow(() -> new IllegalStateException("id introuvable"));

        if (prenom != null && prenom.length() > 0 && !Objects.equals(contact.getPrenom(), prenom)) {
            contact.setPrenom(prenom);
        }
        if (nom != null && nom.length() > 0 && !Objects.equals(contact.getNom(), nom)) {
            contact.setNom(nom);
        }
        if (numeroPhone != null && numeroPhone.length() > 0 && !Objects.equals(contact.getNumeroPhone(), numeroPhone)) {
            contact.setNumeroPhone(numeroPhone);
        }
        if (adresse != null && adresse.length() > 0 && !Objects.equals(contact.getAdresse(), adresse)) {
            contact.setAdresse(adresse);
        }
        if (email != null && email.length() > 0 && !Objects.equals(contact.getEmail(), email)) {
            contact.setEmail(email);
        }

        return contact;

    }
}
