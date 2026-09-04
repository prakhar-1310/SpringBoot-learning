package com.prakhar.ETEjournal.cache;

import com.prakhar.ETEjournal.Entity.ConfigJournalApp;
import com.prakhar.ETEjournal.Repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class AppCache {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String, String> configMap;

    @PostConstruct
    public void init(){
        configMap = new HashMap<>();
        List<ConfigJournalApp> all = configJournalAppRepository.findAll();
        for (ConfigJournalApp x : all) {
            configMap.put(x.getKey(), x.getValue());
        }
    }

}
