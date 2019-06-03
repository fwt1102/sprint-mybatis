package com.fwt.coutrollen;

import com.fwt.dto.WangeditorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//富文本编辑器
@Controller
public class WangEditor {
    @Autowired
    com.fwt.service.WangEditor wangEditor;
//文件上传
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) {
        System.out.println("inner upload");
        System.out.println(dropzFile);
        Map<String, Object> result = new HashMap<String, Object>();

        // 获取上传的原始文件名
        String fileName = dropzFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("/static/upload");
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File destFile = new File(filePath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        // 重新设置文件名为 UUID，以确保唯一
        destFile = new File(filePath, UUID.randomUUID() + fileSuffix);
        System.out.println(destFile.getAbsolutePath());
        if(!destFile.exists()){
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(destFile.getAbsolutePath()+"-------");
        try {
            // 写入文件
            dropzFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回 JSON 数据，这里只带入了文件名
        result.put("fileName", destFile.getName());
        return result;
    }



    //富文本编辑器
    static String UPLOAD_PATH = "/static/upload/";

    //wangEditor
    @ResponseBody
    @RequestMapping(value = "upload1", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        System.out.println(fileName);
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath  = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);


        System.out.println("文件存放路径:"+filePath);
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getLocalHost()+":"+ia.getHostAddress()+"aaaaaa");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 判断路径是否存在，不存在则创建文件夹
        //目标文件夹创建
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //目标文件创建
        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        if(!file.exists()){
            try {
                file.createNewFile();

                editorFile.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
            }}

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        System.out.println("文件名："+serverPath+": "+file.getName());

        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        return result;
    }

    //添加富文本内容到数据库
    @ResponseBody
    @RequestMapping("getWangEditorText")
    public Object getWangEditor(@RequestBody WangeditorDto wangeditorDto){

        System.out.println(wangeditorDto);
        return wangEditor.AddWangEditorText(wangeditorDto);
    }

    @ResponseBody
    @RequestMapping("SelectWangEditorText")
    public Object SelectWangEditor(){


        List<WangeditorDto> wangeditorDtos = wangEditor.selectAllWangEditor();
        System.out.println(wangeditorDtos);
        return wangeditorDtos;
    }
}
