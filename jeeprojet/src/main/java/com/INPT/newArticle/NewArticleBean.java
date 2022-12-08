package com.INPT.newArticle;
import java.io.Serializable;
public class NewArticleBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String article;
	private String tags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tages) {
		this.tags = tages;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
