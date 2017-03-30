package com.aco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.DedrugBasicInfo;
import com.aco.service.DedrugBasicInfoService;
import com.aco.util.PagedResult;

@Controller
@RequestMapping("/dedrugBasicInfo")
public class DedrugBasicInfoController extends BaseController {

	@Autowired
	private DedrugBasicInfoService dedrugBasicInfoService;
	private static final String List = "dedrugBasicInfo/dedrugBasicInfoList";
	private static final String ADDPAGE = "dedrugBasicInfo/addDedrugBasicInfo";
	private static final String EDITPAGE = "dedrugBasicInfo/editDedrugBasicInfo";

	@RequestMapping("/list")
	public String list() {
		return List;
	}

	@RequestMapping("/addPage")
	public String addPage() {
		return ADDPAGE;
	}

	@RequestMapping("/editPage/{id}")
	public ModelAndView editPage(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(EDITPAGE);
		mav.addObject("id", id);
		return mav;
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(DedrugBasicInfo dedrugBasicInfo) {
		return dedrugBasicInfoService.addDedrugBasicInfo(dedrugBasicInfo);
	}

	@RequestMapping("/edit")
	@ResponseBody
	public String edit(DedrugBasicInfo dedrugBasicInfo) {
		return dedrugBasicInfoService.editDedrugBasicInfo(dedrugBasicInfo);
	}

    @RequestMapping(value="/view/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String queryById(@PathVariable("id") String id){
    	return responseSuccess(dedrugBasicInfoService.findDedrugBasicInfo(id).get(0));
    }
    
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		return dedrugBasicInfoService.deleteDedrugBasicInfo(id);
	}
	@RequestMapping("/findDedrugBasicInfoList")
	@ResponseBody
	public String list(Integer pageNumber, Integer pageSize, String userName) {
		logger.info("分页查询用户信息列表请求入参：pageNumber{},pageSize{}", pageNumber, pageSize);
		try {
			PagedResult<DedrugBasicInfo> pageResult = dedrugBasicInfoService.queryByPage(userName, pageNumber,
					pageSize);
			return responseSuccess(pageResult);
		} catch (Exception e) {
			return responseFail(e.getMessage());
		}
	}

}
