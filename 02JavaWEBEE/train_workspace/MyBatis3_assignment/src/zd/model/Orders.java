package zd.model;

import java.util.List;

public class Orders {
	private int orders_id;
	private int count;
	private int status;
	private int user_id;
	private User user;
	private List<Items> itemss;
	private Posts posts;
	
	public Posts getPosts() {
		return posts;
	}
	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	
	public List<Items> getItemss() {
		return itemss;
	}
	public void setItemss(List<Items> itemss) {
		this.itemss = itemss;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Orders [orders_id=" + orders_id + ", count=" + count + ", status=" + status + ", user_id=" + user_id
				+ ", user=" + user + ", itemss=" + itemss + ", posts=" + posts + "]";
	}
	

}
