package org.example.feature;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "example_table")
@Getter
@Setter
@NamedQueries(
    @NamedQuery(name = ExampleTable.FIND_ALL, query = "SELECT x FROM ExampleTable x")
)
public class ExampleTable {

  public static final String FIND_ALL = "ExampleTable.findAll";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "is_used")
  private boolean used;
}
