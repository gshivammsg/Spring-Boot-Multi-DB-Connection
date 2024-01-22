package com.example.demo.controller;

import com.example.demo.entity.JournalEntry;
import com.example.demo.services.JournalEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryServices journalEntryServices;

    Map<String, JournalEntry> journalEntryMap = new HashMap<>();
    @GetMapping("getJournal")
    public List<JournalEntry> getJournalEntry(){
        List<JournalEntry> journalEntries = journalEntryServices.getAllJournalEntry();
        return journalEntries;
    }

    @PostMapping("addJournal")
    public String addJournalEntry(@RequestBody JournalEntry journalEntry){
        journalEntryServices.saveEntry(journalEntry);
        return "Record Entered Successfully";
    }
}
