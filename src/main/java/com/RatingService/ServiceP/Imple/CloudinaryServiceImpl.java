package com.RatingService.ServiceP.Imple;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.RatingService.ServiceP.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    @Autowired
    
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) {

        try {

            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "folder", "hotel-reviews"
                    ));

            return uploadResult.get("secure_url").toString();

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
}