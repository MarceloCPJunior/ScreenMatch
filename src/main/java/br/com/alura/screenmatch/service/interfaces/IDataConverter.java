package br.com.alura.screenmatch.service.interfaces;

public interface IDataConverter {
	<T> T obtainData(String json, Class<T> clazz);
}
