package com.springjpa;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springjpa.services.UserService;

@Profile("user")
@Configuration
public class EventPublisherConfiguration {

  @Bean
  public TopicExchange senderTopicExchange() {
    return new TopicExchange("eventExchange");
  }

  @Bean
  public UserService eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange) {
    return new UserService(rabbitTemplate, senderTopicExchange);
  }
}
