package com.example.courseLibrary.service;


import com.example.courseLibrary.entity.Publisher;
import com.example.courseLibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PblisherService {

    @Autowired
    PublisherRepository publisherRepository;

    //methods
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisher(long id){
        return publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("No publisher found with id: " + id));
    }

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void deletePublisher(long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("No publisher found with id: " + id));
        publisherRepository.deleteById(publisher.getId());
    }

    //
}
