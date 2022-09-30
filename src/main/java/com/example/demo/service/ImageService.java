package com.example.demo.service;

import com.example.demo.model.ImageVO;
import java.util.List;

public interface ImageService {
    public List<ImageVO> selectImageList() throws Exception;
}
