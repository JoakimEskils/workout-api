package com.workoutapi.controller;

import com.workoutapi.repository.ExerciseRepository;
import com.workoutapi.entity.Exercise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;

@RestController
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;
    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    @GetMapping(value = "/exercise", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }
    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exercise getExercise(@PathVariable long id){
        return exerciseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid exercise id %s", id)));
    }
    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Exercise createExercise(@Valid @RequestBody Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
}