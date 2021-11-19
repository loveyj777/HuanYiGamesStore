package com.loveyj.service.impl;

import com.loveyj.mapper.RollImgMapper;
import com.loveyj.pojo.RollImg;
import com.loveyj.service.RollImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("rollImgServiceImpl")
public class RollImgServiceImpl implements RollImgService {

    @Autowired
    RollImgMapper rollImgMapper;

    @Override
    public List<RollImg> getAllRollImg() {
        return rollImgMapper.getAllRollImg();
    }
}

