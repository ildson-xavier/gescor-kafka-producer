package br.com.gescor.gescorkafka.serialize;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gescor.gescorkafka.model.User;

public class UserSerializer implements Serializer<User>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

		
	}

	@Override
	public byte[] serialize(String topic, User data) {
		byte[] serializedBytes = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			serializedBytes = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serializedBytes;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
