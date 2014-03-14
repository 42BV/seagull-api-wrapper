package nl.mad.oehoe.model;

/**
 * Tag can be used to give some additional information about a contact.
 * @author Ruben Zorgman
 */
public class Tag {
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "Tag [tagName=" + tagName + "]";
    }

}
