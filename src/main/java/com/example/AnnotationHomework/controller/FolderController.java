package com.example.AnnotationHomework.controller;


import com.example.AnnotationHomework.models.Folder;
import com.example.AnnotationHomework.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolder(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFile(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}