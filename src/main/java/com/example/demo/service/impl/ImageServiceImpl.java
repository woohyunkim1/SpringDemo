package com.example.demo.service.impl;

import com.example.demo.model.ImageVO;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.service.ImageService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<ImageVO> selectImageList() throws Exception {
        ImageMapper mapper = sqlSession.getMapper(ImageMapper.class);
        List<ImageVO> selectImageList = mapper.selectImageList();
        return selectImageList;
    }
}
