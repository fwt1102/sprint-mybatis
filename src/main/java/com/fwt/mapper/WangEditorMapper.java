package com.fwt.mapper;

import com.fwt.dto.WangeditorDto;

import java.util.List;

public interface WangEditorMapper {
    int AddWangEditorText(WangeditorDto wangeditorDto);

    List<WangeditorDto> selectAllWangEditor();
}
