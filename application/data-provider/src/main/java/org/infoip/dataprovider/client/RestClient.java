package org.infoip.dataprovider.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.infoip.core.exceptions.ExternalApiException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class RestClient<T> {
    private final String accessKey;

    private final String url;

    protected RestClient(final String url, final String accessKey) {
        this.url = url;
        this.accessKey = accessKey;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public T getRequest(final List<String> path) throws ExternalApiException {
        final String finalUrl = url + (String.join("/", path)) + "?access_key=" + accessKey;
        final RestTemplate restTemplate = new RestTemplate();
        final String response = restTemplate.getForObject(finalUrl, String.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.convertValue(objectMapper.readTree(response), getGenericTypeClass());
        } catch (JsonProcessingException e) {
            throw new ExternalApiException(e);
        }
    }
}
