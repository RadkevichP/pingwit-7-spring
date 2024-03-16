package pl.pingwit.springdemo.repository;


import jakarta.persistence.*;

@Entity
@Table(name = "statuses")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_generator")
    @SequenceGenerator(name = "status_id_generator", sequenceName = "status_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
