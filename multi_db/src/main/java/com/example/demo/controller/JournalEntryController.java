package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import com.example.demo.services.JournalEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryServices journalEntryServices;

    Map<String, JournalEntry> journalEntryMap = new HashMap<>();
    @GetMapping("getJournal")
    public ResponseEntity<? extends Object> getJournalEntry(){
        try {
            List<JournalEntry> response = journalEntryServices.getAllJournalEntry();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("addJournal")
    public String addJournalEntry(@RequestBody JournalEntry journalEntry){
        journalEntryServices.saveEntry(journalEntry);
        return "Record Entered Successfully";
    }
}
