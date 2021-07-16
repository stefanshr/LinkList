package ch.stefanhohl.sh.linklist.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Category")
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "category_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    public Category() {
    }

    public Category(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
