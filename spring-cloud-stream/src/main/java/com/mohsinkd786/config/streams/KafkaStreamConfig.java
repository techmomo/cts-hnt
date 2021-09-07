package com.mohsinkd786.config.streams;

import com.mohsinkd786.dto.MessageDto;
import com.mohsinkd786.mapper.MessageMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.web.client.RestTemplate;

@EnableKafka
@EnableKafkaStreams
@Configuration
public class KafkaStreamConfig {

    @Bean
    public KStream<String, MessageDto> kStream(StreamsBuilder builder){

        KStream<String,MessageDto> stream = builder
                .stream("kafka-demo",
                        Consumed.with(
                                Serdes.String(),
                                new JsonSerde<>(MessageDto.class)
                        ));
        // process the stream
        stream
                .map(new MessageMapper())
                .groupByKey()
                .count();
        // sink topic
        stream.to("messages");
        return stream;
    }
}
