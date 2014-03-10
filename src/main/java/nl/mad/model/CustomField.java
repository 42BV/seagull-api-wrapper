package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Override
    public String toString() {
        return "CustomField [customFieldId=" + customFieldId + ", fieldValue=" + fieldValue + "]";
    }

}
