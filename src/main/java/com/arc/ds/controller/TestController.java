package com.arc.ds.controller;

import com.arc.ds.model.SysFile;
import com.arc.ds.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试跳转以及数据返回用
 *
 * @author 叶超  lamymay@outlook.com
 * @since 2018/12/26 11:28
 */
@Slf4j
@RestController
public class TestController {

    //测试说明 ：
    //@GetMapping("/files/{id}") 走 test5的db
    //@GetMapping("/files") 走test的db
    @Autowired
    private FileService fileService;

    @GetMapping("/files/{id}")
    public Object save(@PathVariable Long id) {
        SysFile sysFile = fileService.get(id);
        log.debug("数据={}", sysFile);
        return sysFile;
    }

    @GetMapping("/files")
    public Object list() {
        List<SysFile> list = fileService.list();
        log.debug("数据={}", list);
        return list;
    }


    @PostMapping("/files")
    public Object save(@RequestBody SysFile file) {
        Long save = fileService.save(file);
        log.debug("数据={}", save);
        return save;
    }
}

