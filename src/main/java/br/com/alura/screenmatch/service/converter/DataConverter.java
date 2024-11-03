package br.com.alura.screenmatch.service.converter;

import br.com.alura.screenmatch.service.interfaces.IDataConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T obtainData(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
