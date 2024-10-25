package com.myke.studios.config;

/**
 * dsdf.
 */
public abstract class AbstractKafkaController {

  /**
   * Producer.
   */
  private final KafkaProducer kafkaProducer;

  /**
   * Constructor.
   * @param kafkaProducer .
   */
  protected AbstractKafkaController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  /**
   * Publish.
   * @param message .
   */
  public void publish(final String message) {
    kafkaProducer.sendMessage(message);
  }
}
