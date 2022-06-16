package com.amina.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository
        extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c WHERE c.numeroPhone = ?1" )
    Optional<Contact> findContactByNumeroPhone(String numeroPhone);
    }