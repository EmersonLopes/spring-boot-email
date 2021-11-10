package com.example.springbootemail.repositories;

import com.example.springbootemail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
