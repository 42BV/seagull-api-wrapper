package nl.mad.oehoe.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomFieldTest {

    @Test
    public void constructCustomField() {
        CustomField customField = new CustomField();
        customField.setCustomFieldId("Id");
        customField.setFieldValue("Value");

        assertEquals("Id is not the same, ", "Id", customField.getCustomFieldId());
        assertEquals("Value is not the same, ", "Value", customField.getFieldValue());

    }

}
