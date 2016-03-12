package com.afm.kafka.config;

/**
 * Created by rchen on 3/8/16.
 */
//@Service
public class KafkaConfigBuilder {

//    private List<String> topics = Arrays.asList(new String[]{"orders", "payment"});
//    private List<String> groupIds = Arrays.asList(new String[]{"orderId", "paymentId"});
//    List<KafkaConsumerConfig> consumerConfigs = new ArrayList<>();
//
//    @PostConstruct
//    public void buildConsumers() {
//        for (int i = 0; i < topics.size(); i++) {
//            consumerConfigs.add(build(topics.get(i), groupIds.get(i)));
//        }
//    }
//
//    @Bean
//    @Profile({"default","integration"})
//    public KafkaConsumerConfig build(String topic, String groupId) {
//        KafkaConsumerConfig config = new KafkaConsumerConfig();
//        config.config(topic, groupId, new EventProcessor(new Subscription(topic, null)));
//        return config;
//    }

}
