package zd.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import zd.model.Items;
import zd.model.Post;
import zd.model.User;
import zd.service.ItemsService;
import zd.service.PostService;
import zd.service.impl.ItemsServiceImpl;
import zd.service.impl.PostServiceImpl;
import zd.vo.ItemsVo;

@Controller
public class ItemsAction {
	//  /Users/Zd/Desktop/GitHub/BigDataTrain/02JavaWEBEE/pic
	private static final String VIR_PATH="/pic/";
	private static final String REAL_PATH="/Users/Zd/Desktop/GitHub/BigDataTrain/02JavaWEBEE/pic/";
	@RequestMapping(value="/itemsList.shtml")
	public String itemsList(ItemsVo itemsVo, HttpServletRequest request) {
		ItemsService itemsService = new ItemsServiceImpl();
		List<Items> itemsList = itemsService.findItemsByVo(itemsVo);
		request.setAttribute("itemsList", itemsList);
		request.setAttribute("vo", itemsVo);
		return "itemsList";
	}

	@RequestMapping("/addCart.shtml")
	public String addCart(HttpServletResponse response, int id) {
		String key = "items" + id;
		String value = id + "";
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(1000);
		response.addCookie(cookie);
		return "redirect:cart.shtml";
	}

	@RequestMapping("/cart.shtml")
	public String cart(HttpServletRequest request,HttpSession session) {
		Cookie[] cookies = request.getCookies();
		String ids = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().contains("items")) {
					String id = cookies[i].getValue();
					ids += id + ",";
				}
			}
		}
		List<Items> itemsList;
		if (ids != "") {
			ids = ids.substring(0, ids.length() - 1);
			ItemsService itemsService = new ItemsServiceImpl();
			itemsList = itemsService.findItemsByCart(ids);
		} else {
			itemsList = null;
		}
		PostService postService=new PostServiceImpl();
		User user=(User) session.getAttribute("user");
		List<Post> postList=postService.findPostsByUserId(user.getUserId());
		request.setAttribute("itemsList", itemsList);
		request.setAttribute("postList", postList);
		return "cart";
	}

	@RequestMapping("/delCart.shtml")
	public String delCart(int id, HttpServletResponse response, HttpServletRequest request) {
		String key = "items" + id;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(key)) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		return "redirect:cart.shtml";
	}
	//
	@RequestMapping("/toUpdateItems.shtml")
	public String toUpdateItems(@RequestParam(value="id",required=true)int id,HttpServletRequest request){
		ItemsService itemsService=new ItemsServiceImpl();
		Items items=itemsService.findItemsBySelect(id);
		request.setAttribute("items",items);
		return "toUpdateItems";
	}
	@RequestMapping("/updateItems.shtml")
	public String updateItems(Items items){
		ItemsService itemsService=new ItemsServiceImpl();
		itemsService.updateItemsBySelective(items);
		return "redirect:itemsList.shtml";
	}
	
	@RequestMapping("/toAddItems.shtml")
	public String toAddItems(){
		return "addItems";
	}
	
	@RequestMapping("/addItems.shtml")
	public String addItems(MultipartFile file,Items items) throws Exception, IOException{
		String oldName=file.getOriginalFilename();
		String suffix=oldName.substring(oldName.lastIndexOf("."));
		String prefix=UUID.randomUUID().toString();
		String newName=prefix+suffix;
		String realPath=REAL_PATH+newName;
		file.transferTo(new File(realPath));
		String virPath=VIR_PATH+newName;
		items.setUrl(virPath);
		ItemsService itemsService=new ItemsServiceImpl();
		itemsService.insertBySelective(items);
		return "redirect:itemsList.shtml";
	}
	
}
