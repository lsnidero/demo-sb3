package com.example.demo.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
@Slf4j
public class HazelcastConfiguration {

    @Value("#{'${hazelcast.addresses}'.split(',')}")
    List<String> addresses;

    @Value("${hazelcast.cluster.name}")
    String clusterName;

    @Bean
    public HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();

        // Nome del cluster (deve corrispondere a quello dei membri del cluster)
        clientConfig.setClusterName(clusterName);

        // Configura le porte dei membri del cluster
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.setSmartRouting(false);
        //networkConfig.addAddress(addresses.toArray(String[]::new));
        networkConfig.addAddress(addresses.toArray(new String[]{}));

        log.info("Configured Hazelcast Cache cluster \"{}\" with addresses {}", clusterName, addresses);

        return HazelcastClient.newHazelcastClient(clientConfig);
    }

}