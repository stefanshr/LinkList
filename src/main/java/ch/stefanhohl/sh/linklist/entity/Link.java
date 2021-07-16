package ch.stefanhohl.sh.linklist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import ch.stefanhohl.sh.linklist.entity.Category;

import javax.persistence.*;

@Entity(name = "Link")
@Table(name = "link")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "link_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "url")
    private String url;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idfs")
    private Category category;

    public Link() {
    }

    public Link(String url, Category category) {
        this.url = url;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
