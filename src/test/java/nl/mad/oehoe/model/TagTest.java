package nl.mad.oehoe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TagTest {

    @Test
    public void constructTag() {
        Tag tag = new Tag();
        tag.setTagName("Name");
        assertEquals("Id is not the same, ", "Name", tag.getTagName());
    }

}
