package com.arc.ds.service.impl;

import com.arc.ds.mapper.SysFileMapper;
import com.arc.ds.model.SysFile;
import com.arc.ds.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author may
 * @since 2019/7/18 21:43
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private SysFileMapper fileMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    //测试说明贴上 @Transactional 如果写源注解，这里也生效了
//    @Transactional//(propagation= Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public Long save(SysFile file) {
        //return fileMapper.save(file) == 0 ? null : file.getId();
        int save = fileMapper.save(file);
        // 模拟异常 int i = 1 / 0;
        return save == 0 ? null : file.getId();
    }

    @Override
    public int update(SysFile file) {
        return fileMapper.update(file);
    }

    @Override
//    @Transactional(readOnly = true)
    public List<SysFile> list() {
        return fileMapper.list();
    }

    @Override
    @Transactional(readOnly = true)
    public SysFile get(Long id) {
        return fileMapper.get(id);
    }
}

