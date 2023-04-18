package com.wellsfargo.backend.validator;

import com.wellsfargo.backend.exception.InvalidFileTypeException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DataValidator {

    public void isCSV(MultipartFile file) {
        String contentType = file.getContentType();
        System.out.println("File Content Type : " + contentType);
        if (!"text/csv".equalsIgnoreCase(contentType)) {
            throw new InvalidFileTypeException("Invalid File Type. Expected : CSV");
        }
    }
}
