package com.example.demo.mapper;

import com.example.demo.model.ImageVO;

import java.util.List;

public interface ImageMapper {
    List<ImageVO> selectImageList() throws Exception;
}
