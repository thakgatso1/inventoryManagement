package za.co.eoh.invetory.management.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "makes")
public class Make implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "make_id")
  private Integer makeId;

  @Column(name = "name")
  private String name;

  public Integer getMakeId() {
    return makeId;
  }

  public void setMakeId(Integer makeId) {
    this.setId( makeId);
  }

  public void setId(Integer id) {
    this.makeId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Make{" +
        "makeId=" + makeId +
        ", name='" + name + '\'' +
        '}';
  }
}
