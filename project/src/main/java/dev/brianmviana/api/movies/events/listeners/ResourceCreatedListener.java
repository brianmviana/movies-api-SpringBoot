package dev.brianmviana.api.movies.events.listeners;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.brianmviana.api.movies.events.ResourceCreatedEvent;

public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent>{

	@Override
	public void onApplicationEvent(ResourceCreatedEvent event) {
		HttpServletResponse response = event.getResponse();
		String id = event.getId();
		
		AddingHeaderLocation(response, id);
		
	}

	private void AddingHeaderLocation(HttpServletResponse response, String id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}")
				.buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
