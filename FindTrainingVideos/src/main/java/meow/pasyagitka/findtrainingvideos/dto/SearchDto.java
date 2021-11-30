package meow.pasyagitka.findtrainingvideos.dto;

import lombok.Data;

@Data
public class SearchDto {
    private String key; //the field name
    private String operation; // the operation – for example, equality, less than, … etc.
    private Object value;// the field value – for example, john, 25, … etc.

    public SearchDto(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }
}
