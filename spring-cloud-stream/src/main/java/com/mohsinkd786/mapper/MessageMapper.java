package com.mohsinkd786.mapper;

import com.mohsinkd786.dto.MessageDto;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;

public class MessageMapper implements KeyValueMapper<String, MessageDto, KeyValue<String,MessageDto>> {
    @Override
    public KeyValue<String, MessageDto> apply(String s, MessageDto messageDto) {
        return new KeyValue<>(messageDto.getKey(),messageDto);
    }
}
