package com.myke.studios.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka sender.
 */
@Service
public class KafkaProducer {

  /**
   * Kafka template to send.
   */
  private final KafkaTemplate<String, String> kafkaTemplate;
  /**
   * Topic name to create the comunication.
   */
  private final String topicName = "pokemon-topic";

  /**
   * Creating model of message (template).
   * @param kafkaTemplate dependency injection of template.
   */
  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  /**
   * Sending message.
   * @param message itself.
   */
  public void sendMessage(String message) {
    kafkaTemplate.send(topicName, message);
    System.out.println("Mensaje enviado por Pokeapi: " + message);
  }
}
