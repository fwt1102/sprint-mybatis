package com.fwt.service.impl;

import com.fwt.dto.WangeditorDto;
import com.fwt.mapper.WangEditorMapper;
import com.fwt.service.WangEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WangEditorImpl implements WangEditor {
    @Autowired
    WangEditorMapper wangEditorMapper;
    public int AddWangEditorText(WangeditorDto wangeditorDto) {
        return wangEditorMapper.AddWangEditorText(wangeditorDto);
    }

    public List<WangeditorDto> selectAllWangEditor() {
        return wangEditorMapper.selectAllWangEditor();
    }
}
