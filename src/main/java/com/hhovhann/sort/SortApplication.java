package com.hhovhann.sort;

import com.hhovhann.sort.service.SortingStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SortApplication implements CommandLineRunner {
    @Autowired
    SortingStrategyService sortingStrategyService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SortApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SortApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            LOGGER.info("Input name list is empty");
            return;
        }
        LOGGER.info("Running sorting strategy ...");
        String[] sorted = sortingStrategyService.sortWords(args);
        for (int i = 0; i < sorted.length; i++) {
            LOGGER.info("Sorted names list: index {} -> {}", i, args[i]);
        }
    }
}
