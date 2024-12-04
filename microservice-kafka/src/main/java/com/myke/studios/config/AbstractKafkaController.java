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
   * @param topicName .
   * @param identifier .
   */
  public void publish(final T message,final String topicName,final String identifier) {
    kafkaProducer.send(message, topicName, identifier);
  }
}
