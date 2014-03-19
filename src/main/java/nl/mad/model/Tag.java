package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Tag can be used to give some additional information about a contact.
 * @author Ruben Zorgman
 */
public class Tag {
    @JsonProperty("TAG_NAME")
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
