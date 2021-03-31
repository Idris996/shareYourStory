package shareyourstory.ShareStory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Story {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String title;
    @Lob()
    private String content;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean approved = false;
    private Long likes = 0L;
    private Long dislikes = 0L;

    public Story() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return id.equals(story.id) &&
                author.equals(story.author) &&
                title.equals(story.title) &&
                content.equals(story.content) &&
                date.equals(story.date) &&
                approved.equals(story.approved) &&
                likes.equals(story.likes) &&
                dislikes.equals(story.dislikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, content, date, approved, likes, dislikes);
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", approved=" + approved +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}
