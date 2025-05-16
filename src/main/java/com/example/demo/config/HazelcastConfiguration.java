package com.example.demo.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class HazelcastConfiguration {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();

        // Nome del cluster (deve corrispondere a quello dei membri del cluster)
        clientConfig.setClusterName("dev");

        // Configura le porte dei membri del cluster
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.setSmartRouting(false);
        networkConfig.addAddress("localhost:15701", "localhost:25701");

        return HazelcastClient.newHazelcastClient(clientConfig);
    }

}