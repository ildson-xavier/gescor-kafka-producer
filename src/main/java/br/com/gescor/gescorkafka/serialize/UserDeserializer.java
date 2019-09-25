package br.com.gescor.gescorkafka.serialize;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gescor.gescorkafka.model.User;

public class UserDeserializer implements Deserializer<User>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		User developer = null;
		try {
			developer = mapper.readValue(data, User.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
