package com.airtravel.flightbooking.boot;

import com.airtravel.flightbooking.model.Airport;
import com.airtravel.flightbooking.model.Flight;
import com.airtravel.flightbooking.model.FlightOffer;
import com.airtravel.flightbooking.repo.AirportRepo;
import com.airtravel.flightbooking.repo.FlightRepo;
import com.airtravel.flightbooking.repo.OfferRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

@Component
@Transactional
public class DataLoader {
    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private static final String airportsFile = "/data/airport-codes.csv";
    private static final String flightsFile = "/data/flights.csv";
    private static final String offerFile = "/data/offer.csv";

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    @Order(1)
    CommandLineRunner loadAirports(AirportRepo airoprtRepo) {
        return (args) -> {
            loadFromCsv(resourceLoader, airportsFile, v -> new Airport(v[0], v[1]), airoprtRepo);
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner loadFlights(FlightRepo flightRepo) {
        return (args) -> {
            loadFromCsv(resourceLoader, flightsFile,
                    v -> new Flight( v[0], v[1], v[2] , v[3]),
                    flightRepo);
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner loadOffer(OfferRepo offerRepo) {
        return (args) -> {
            loadFromCsv(resourceLoader, offerFile, v -> new FlightOffer(v[0], v[1], v[2]), offerRepo);
        };
    }

    public static void loadFromCsv(ResourceLoader resourceLoader, String sourceCsvFile,
                                   Function<String[], Object> objectMapper, CrudRepository repo) {
        logger.debug("++++++++++++++ Loading " + sourceCsvFile + " ..........");

        Resource resource = resourceLoader.getResource("classpath:" + sourceCsvFile);

        try (Stream<String> stream = Files.lines(Paths.get(resource.getFile().getAbsolutePath()))) {
            stream.forEach(line -> {
                logger.debug("++++++++++++++" + line);
                try {
                    String[] values = line.split(",");
                    Object entity = objectMapper.apply(values);
                    repo.save(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("++++++++++++++ Loading " + sourceCsvFile + " DONE !");

    }
}
