package org.example.feature;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ExampleTableRepository {

  @Inject
  EntityManager entityManager;

  public void create(final ExampleTable item) {
    entityManager.persist(item);
  }

  public List<ExampleTable> findAll() {
    return entityManager
        .createNamedQuery(ExampleTable.FIND_ALL, ExampleTable.class)
        .getResultList();
  }

  public ExampleTable findById(final long id) {
    return entityManager.find(ExampleTable.class, id);
  }
}
