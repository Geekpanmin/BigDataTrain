package zd.car.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zd.car.base.Page;
import zd.car.base.Pager;
import zd.car.bean.Dymsn;
import zd.car.bean.News;
import zd.car.bean.Notice;
import zd.car.service.DymsnService;
import zd.car.service.NewsService;
import zd.car.service.NoticeService;

@Controller
@RequestMapping("/index")
public class IndexAction {
	
	@Resource
	private NewsService newsService;
	
	@Resource
	private NoticeService noticeService;
	
	@Resource
	private DymsnService dymsnService;
	
	@RequestMapping("/news.shtml")
	public String news(Page page,HttpServletRequest request){
		if(page.getPager()==null){
			Pager pager = new Pager();
			page.setPager(pager);
		}
		List<News> list = newsService.findByPageQuery(page);
		int totalRows = newsService.findTotalRowsByPageQuery(page);
		page.setList(list);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "index/news";
	}
	
	@RequestMapping("/notice.shtml")
	public String notice(Page page,HttpServletRequest request){
		if(page.getPager()==null){
			Pager pager = new Pager();
			page.setPager(pager);
		}
		List<Notice> list = noticeService.findByPageQuery(page);
		int totalRows = noticeService.findTotalRowsByPageQuery(page);
		page.setList(list);
		page.setTotalRows(totalRows);
		request.setAttribute("page", page);
		return "index/notice";
	}
	
	@RequestMapping("/index.shtml")
	public String index(){
		return "index/index";
	}
	
	@RequestMapping("/top.shtml")
	public String top(){
		return "index/top";
	}
	
	@RequestMapping("/navigation.shtml")
	public String navigation(){
		return "index/navigation";
	}
	
	@RequestMapping("/dymsn.shtml")
	public String dymsn(HttpServletRequest request){
		List<Dymsn> list = dymsnService.findDysmn();
		request.setAttribute("list", list);
		return "index/dymsn";
	}
}
