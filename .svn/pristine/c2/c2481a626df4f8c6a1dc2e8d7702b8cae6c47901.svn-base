package com.homedepot.di.xd.efs.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.Annotations;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@Provider
@Consumes(MediaType.WILDCARD)
@Produces(MediaType.WILDCARD)
public class CustomJacksonJaxbJsonProvider extends JacksonJsonProvider {
	
	protected static final Annotations[] DEFAULT_ANNOTATIONS = { Annotations.JAXB };

	public CustomJacksonJaxbJsonProvider() {
		super(new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
				.configure(SerializationFeature.INDENT_OUTPUT, true)
				.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
			, DEFAULT_ANNOTATIONS);
	}

	public CustomJacksonJaxbJsonProvider(Annotations[] annotationsToUse) {
		this(null, annotationsToUse);
	}

	public CustomJacksonJaxbJsonProvider(ObjectMapper mapper,
			Annotations[] annotationsToUse) {
		super(mapper, annotationsToUse);
	}
	
	@Override
	public Object readFrom(Class<Object> type, java.lang.reflect.Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException {
		
		if(isJsonType(mediaType))
		{			
			ObjectMapper mapper = new ObjectMapper();
			JaxbAnnotationModule module = new JaxbAnnotationModule();
			mapper.registerModule(module);
			
			return mapper.readValue(entityStream, type);
		}
		
		return super.readFrom(type, genericType, annotations, mediaType, httpHeaders, entityStream);
	}

	@Override
	public void writeTo(Object value, Class<?> type,
			java.lang.reflect.Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
        if(isJsonType(mediaType))
		{
        	JaxbAnnotationModule module = new JaxbAnnotationModule();
			mapper.registerModule(module);
		}
        
        mapper.writeValue(entityStream, value);
	}

}
