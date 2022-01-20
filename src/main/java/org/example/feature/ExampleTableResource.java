package org.example.feature;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/feature/example-table")
public class ExampleTableResource {

  @Inject
  ExampleTableRepository repository; // normally services are used inside the controller

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<ExampleTable> findAll() {
    return repository.findAll();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ExampleTable findById(@PathParam("id") long id) {
    return repository.findById(id);
  }

  @POST
  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public void create(final ExampleTable item) {
    repository.create(item);
  }
}
