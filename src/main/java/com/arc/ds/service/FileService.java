package com.arc.ds.service;

import com.arc.ds.model.SysFile;

import java.util.List;

/**
 * @author may
 * @since 2019/7/18 21:42
 */
public interface FileService {

    Long save(SysFile file);

    int update(SysFile file);

    SysFile get(Long id);

    List<SysFile> list();
}
