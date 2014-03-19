package nl.mad.oehoe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CustomField contains user created fields that can hold information.
 * @author Ruben Zorgman
 */
public class CustomField {
    @JsonProperty("CUSTOM_FIELD_ID")
    private String customFieldId;
    @JsonProperty("FIELD_VALUE")
    private String fieldValue;

    public String getCustomFieldId() {
        return customFieldId;
    }

    public void setCustomFieldId(String customFieldId) {
        this.customFieldId = customFieldId;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

}
