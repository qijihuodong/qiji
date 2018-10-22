package com.qiji.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiji.domain.MicroMessage;
import com.qiji.service.impl.MicroMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MicroMessageController {

    @Autowired
    MicroMessageService microMessageService;

    @RequestMapping("/index")
    public ModelAndView selectList(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam @NotNull Integer isRead){
        MicroMessage param=new MicroMessage();
        param.setIsRead(isRead);

        PageHelper.startPage(pageNum,10);
        List<MicroMessage> list=microMessageService.selectList(param);
        PageInfo<MicroMessage> pageInfo=new PageInfo<>(list);

        return  new ModelAndView("message-list","page",pageInfo);
    }

    @RequestMapping("/part")//@ResponseBody
    public ModelAndView showContentPart() {
        MicroMessage param=new MicroMessage();
        param.setIsRead(0);
        PageHelper.startPage(1,10);
        List<MicroMessage> list=microMessageService.selectList(param);
        PageInfo<MicroMessage> pageInfo=new PageInfo<>(list);

        return new ModelAndView( "message-list::content","page",pageInfo);
    }
    @RequestMapping("/ajax")
    public String dd(){

        return "ajax-demo";
    }
}
