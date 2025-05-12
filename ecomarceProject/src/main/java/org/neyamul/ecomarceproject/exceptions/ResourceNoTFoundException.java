package org.neyamul.ecomarceproject.exceptions;


public class ResourceNoTFoundException extends RuntimeException {
    String recourseName;
    String field;
    String fieldName;
    long fielId;

    public ResourceNoTFoundException(){
    }


    public ResourceNoTFoundException(String recourseName){
        super(String.format("%s not found", recourseName));
        this.recourseName = recourseName;
    }

    public ResourceNoTFoundException(String recourseName, String field, String fieldName) {
        super(String.format("%s not found with %s: %s ", recourseName, field, fieldName));
        this.recourseName = recourseName;
        this.field = field;
        this.fieldName = fieldName;
    }

    public ResourceNoTFoundException(String recourseName, String field, long fielId) {
        super(String.format("%s not found with %s: %d ", recourseName, field, fielId));
        this.recourseName = recourseName;
        this.field = field;
        this.fielId = fielId;
    }

}
