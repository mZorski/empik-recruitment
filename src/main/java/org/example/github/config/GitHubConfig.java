package org.example.github.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GitHubConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
			.rootUri("https://api.github.com/")
			.additionalMessageConverters(new MappingJackson2HttpMessageConverter(jsonMapper()))
			.build();
	}

	private JsonMapper jsonMapper() {
		return JsonMapper.builder()
			.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.addModule(new JavaTimeModule())
			.build();
	}

}
