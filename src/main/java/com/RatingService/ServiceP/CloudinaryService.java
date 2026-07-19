package com.RatingService.ServiceP;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

    String uploadFile(MultipartFile file);

}