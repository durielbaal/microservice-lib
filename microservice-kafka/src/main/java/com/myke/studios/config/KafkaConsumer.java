package com.myke.studios.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kefka receiver.
 */
@Service
public class KafkaConsumer {

  /**
   * Receiving message.
   * @param message itself.
   */
  @KafkaListener(topics = "pokemon-topic", groupId = "pokedb-group")
  public void consume(String message) {
    System.out.println("Mensaje recibido en PokeDB: " + message);
  }
}
