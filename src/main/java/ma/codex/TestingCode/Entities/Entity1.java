package ma.codex.TestingCode.Entities;

import ma.codex.Framework.ORM.Annotations.Column;
import ma.codex.Framework.ORM.Annotations.Entity;
import ma.codex.Framework.ORM.Annotations.ID;

@Entity(name = "entities")
public class Entity1 {
    @ID
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", size = 50)
    private String name;

    @Column(name = "description", type = "text")
    private String description;
}
