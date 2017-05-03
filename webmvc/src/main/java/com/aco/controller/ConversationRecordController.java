package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.ConversationRecord;
import com.aco.service.ConversationRecordService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/conversationRecord")
public class ConversationRecordController extends BaseController{

	@Autowired
	private ConversationRecordService conversationRecordService;
	
	private final static String List="conversationRecord/conversationRecordList";
	private final static String ADDPAGE="conversationRecord/addConversationRecord";
	private final static String EDITPAGE="conversationRecord/editConversationRecord";
	private final static String InPrisonConversationList="conversationRecord/inPrisonConversationList";
	private final static String ADDInPrisonConversation="conversationRecord/addInPrisonConversation";
	private final static String editInPrisonConversationList="conversationRecord/editInPrisonConversationList";
	private final static String OutPrisonConversationList="conversationRecord/outPrisonConversationList";
	private final static String ADDOutPrisonConversation="conversationRecord/addOutPrisonConversation";
	private final static String editOutPrisonConversationList="conversationRecord/editOutPrisonConversationList";
	
	@RequestMapping("/list")
	public String List(){
		return List;
	}
	@RequestMapping("/InPrisonConversationList")
	public String InPrisonConversationList(){
		return InPrisonConversationList;
	}
	@RequestMapping("/OutPrisonConversationList")
	public String OutPrisonConversationList(){
		return OutPrisonConversationList;
	}
	@RequestMapping("/addInPrisonConversation")
	public String ADDInPrisonConversation(){
		return ADDInPrisonConversation;
	}
	@RequestMapping("/addOutPrisonConversation")
	public String ADDOutPrisonConversation(){
		return ADDOutPrisonConversation;
	}
	@RequestMapping("/addpage")
	public String addPage(){
		return ADDPAGE;
	}
	@RequestMapping("/editInPrisonConversationList/{id}")
	public ModelAndView editInPrisonConversationList(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(editInPrisonConversationList);
    	mav.addObject("id", id);
    	return mav;
	}
	@RequestMapping("/editOutPrisonConversationList/{id}")
	public ModelAndView editOutPrisonConversationList(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(editOutPrisonConversationList);
    	mav.addObject("id", id);
    	return mav;
	}
	@RequestMapping("/editPage/{id}")
	public ModelAndView editPage(@PathVariable("id") String id){
    	ModelAndView mav = new ModelAndView(EDITPAGE);
    	mav.addObject("id", id);
    	return mav;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(ConversationRecord conversationRecord){
		return conversationRecordService.addConversationRecord(conversationRecord);
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit(ConversationRecord conversationRecord){
		return conversationRecordService.editConversationRecord(conversationRecord);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return conversationRecordService.deleteConversationRecord(id);
	}
	
    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(conversationRecordService.findConversationRecord(id).get(0));
    }
    
    @RequestMapping("/findInPrisonConversationList")
    @ResponseBody
    public String inPrisonlist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<ConversationRecord> pageResult = conversationRecordService.queryByPageForInPrison(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
    
    @RequestMapping("/findOutPrisonConversationList")
    @ResponseBody
    public String outPrisonlist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<ConversationRecord> pageResult = conversationRecordService.queryByPageForOutPrison(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
    
    @RequestMapping("/findConversationRecordList")
    @ResponseBody
    public String rolelist(Integer pageNumber,Integer pageSize ,String id){
        logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber,pageSize);  
        try {  
            PagedResult<ConversationRecord> pageResult = conversationRecordService.queryByPage(id, pageNumber, pageSize);  
            return responseSuccess(pageResult);  
        } catch (Exception e) {  
            return responseFail(e.getMessage());  
        } 
    }
}
