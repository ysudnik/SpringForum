package objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message{
    private User author;
    private String text;
    private String date;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Message(User author, String text, String date) {
        this.author = author;
        this.text = text;
        this.date = date;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "<h4>" + getAuthor() +
                " : " + getText() + "<h4>";
    }
}
