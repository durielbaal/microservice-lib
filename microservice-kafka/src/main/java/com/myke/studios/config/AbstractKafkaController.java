package com.myke.studios.config;

/**
 * Abstract kafka controller.
 * @param <T> .
 */
public abstract class AbstractKafkaController<T> {

  /**
   * Producer.
   */
  private final KafkaProducer<T> kafkaProducer;

  /**
   * Constructor.
   * @param kafkaProducer .
   */
  protected AbstractKafkaController(KafkaProducer<T> kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  /**
   * Publish.
   * @param message .
   */
  public void publish(final T message) {
    kafkaProducer.sendMessage(message);
  }
}
