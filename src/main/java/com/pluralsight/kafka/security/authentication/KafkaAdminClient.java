package com.pluralsight.kafka.security.authentication;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;

/**
 * Class KafkaAdminClient that responsible for
 *
 * @author Mykola.Matsishin <br> created on 18 January 2021
 * @since 5.1
 */
public class KafkaAdminClient {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "broker-1:9291,broker-2:9292,broker-3:9293");
		props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
		props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");

		AdminClient adminClient = AdminClient.create(props);
		NewTopic newTopic = new NewTopic("my-new-topic", 1, (short) 1);
		adminClient.createTopics(Collections.singleton(newTopic));
	}
}
