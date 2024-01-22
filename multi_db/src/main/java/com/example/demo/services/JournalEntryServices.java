package com.example.demo.services;

import com.example.demo.entity.JournalEntry;
import com.example.demo.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JournalEntryServices {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllJournalEntry(){
        return new ArrayList<>(journalEntryRepository.findAll());
    }
}
