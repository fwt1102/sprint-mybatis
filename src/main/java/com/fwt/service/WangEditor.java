package com.fwt.service;

import com.fwt.dto.WangeditorDto;

import java.util.List;

public interface WangEditor {
    int AddWangEditorText(WangeditorDto wangeditorDto);
    List<WangeditorDto> selectAllWangEditor();

}
