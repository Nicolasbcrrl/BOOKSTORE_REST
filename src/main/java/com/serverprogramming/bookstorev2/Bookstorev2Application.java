package com.serverprogramming.bookstorev2;

import com.serverprogramming.bookstorev2.domain.Book;
import com.serverprogramming.bookstorev2.domain.BookRepository;
import com.serverprogramming.bookstorev2.domain.Category;
import com.serverprogramming.bookstorev2.domain.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bookstorev2Application {
    private static final Logger log = LoggerFactory.getLogger(Bookstorev2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Bookstorev2Application.class, args);
    }

    @Bean
    public CommandLineRunner booktransaction(BookRepository bookRepository, CategoryRepository categoryRepository){
        return (args) -> {
            log.info("save a couple of books");
            categoryRepository.save(new Category("Fantasy"));
            categoryRepository.save(new Category("Sci-Fi"));
            categoryRepository.save(new Category("Horror"));
            categoryRepository.save(new Category("Romance"));
            categoryRepository.save(new Category("Mystery"));
            categoryRepository.save(new Category("Thriller"));
            categoryRepository.save(new Category("Drama"));
            categoryRepository.save(new Category("Comedy"));

            bookRepository.save(new Book("978-3-16-148410-0", "The Witcher The Last Wish", "Andrzej Sapkowski", 2016, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-1", "The Witcher Sword of Destiny", "Andrzej Sapkowski", 2017, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-2", "The Witcher Blood of Elves", "Andrzej Sapkowski", 2018, 14.20, categoryRepository.findByName("Drama")));
            bookRepository.save(new Book("978-3-16-148410-3", "The Witcher Time of Contempt", "Andrzej Sapkowski", 2019, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-4", "The Witcher Baptism of Fire", "Andrzej Sapkowski", 2020, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-5", "The Witcher Tower of Swallows", "Andrzej Sapkowski", 2021, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-6", "The Witcher Lady of the Lake", "Andrzej Sapkowski", 2022, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-7", "The Witcher Season of Storms", "Andrzej Sapkowski", 2023, 14.20, categoryRepository.findByName("Fantasy")));
            bookRepository.save(new Book("978-3-16-148410-8", "Cyberpunk 2077", "Mike Pondsmith", 2024, 14.20, categoryRepository.findByName("Sci-Fi")));
            bookRepository.save(new Book("978-3-16-148410-9", "Ready player one", "Ernest Cline", 2025, 14.20, categoryRepository.findByName("Sci-Fi")));
            bookRepository.save(new Book("978-3-16-148410-9", "Les Fleurs du Mal", "Charles Baudelaire", 2025, 14.20, categoryRepository.findByName("Romance")));
            bookRepository.save(new Book("978-3-16-148410-9", "Back to the Future", "Robert Zemeckis", 2025, 14.20, categoryRepository.findByName("Sci-Fi")));

            log.info("fetch all books");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }
        };

    }

}
