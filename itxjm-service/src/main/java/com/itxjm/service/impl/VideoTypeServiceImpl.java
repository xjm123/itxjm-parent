package com.itxjm.service.impl;

import com.itxjm.dao.VideoTypeMapper;
import com.itxjm.entity.VideoType;
import com.itxjm.service.VideoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("videoTypeServiceImpl")
public class VideoTypeServiceImpl implements VideoTypeService {
    @Autowired
    private VideoTypeMapper videoTypeMapper;
    @Override
    public List<VideoType> getVideoType(VideoType videoType) {
        return videoTypeMapper.getVideoType(videoType);
    }
}
