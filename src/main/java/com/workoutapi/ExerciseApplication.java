package com.workoutapi;
        import com.workoutapi.entity.Exercise;
        import com.workoutapi.repository.ExerciseRepository;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class ExerciseApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class);
    }
    @Bean
    public CommandLineRunner sampleData(ExerciseRepository repository) {
        return (args) -> {
            repository.save(new Exercise("Overhead Press", "Shoulder exercise.", 5));
            repository.save(new Exercise("Bench Press", "Chest exercise.", 4));
            repository.save(new Exercise("Barbell Row", "Back exercise.", 3));
        };
    }
}
