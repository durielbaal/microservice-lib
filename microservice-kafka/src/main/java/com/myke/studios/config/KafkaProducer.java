package com.myke.studios.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka sender.
 * @param <T> .
 */
@Service
public class KafkaProducer<T> {

  /**
   * Kafka template to send.
   */
  private final KafkaTemplate<String, T> kafkaTemplate;

  /**
   * Creating model of message (template).
   * @param kafkaTemplate dependency injection of template.
   */
  public KafkaProducer(KafkaTemplate<String, T> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  /**
   * Send response of pokedb.
   * @param response .
   * @param topicName .
   * @param reference id or reference as identifier/origin.
   */
  public  void send(T response, String topicName, String reference) {
    kafkaTemplate.send(topicName, reference, response);
  }
}
