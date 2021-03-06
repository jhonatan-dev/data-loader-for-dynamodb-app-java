package com.jhonatan_dev.dataloaderfordynamo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class DataloaderfordynamoApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(DataloaderfordynamoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("Data Loader for Dynamo, initialized! d|o_o|b");
  }
}
