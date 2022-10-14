package org.samiuelnegash.modernprocure.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
    String dataNotExist;

    public ResourceNotFoundException(String dataNotExist) {
        this.dataNotExist = dataNotExist;

    }


}
