package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;
import nl.tweeenveertig.seagull.model.Tag;

import org.junit.Test;

public class TagTest {

    @Test
    public void constructTag() {
        Tag tag = new Tag();
        tag.setTagName("Name");
        assertEquals("Id is not the same, ", "Name", tag.getTagName());
    }

}
