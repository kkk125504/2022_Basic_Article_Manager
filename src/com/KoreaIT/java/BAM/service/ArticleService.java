package com.KoreaIT.java.BAM.service;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.BAM.container.Container;
import com.KoreaIT.java.BAM.dto.Article;

public class ArticleService {

	public List<Article> getForPrintArticles(String searchKeyword) {

		List<Article> articles = Container.articleDao.getArticles(searchKeyword);

		return articles;
		
	}
	public Article getForPrintArticle(int id) {
		Article article = Container.articleDao.getArticleById(id);
		return article;
	}

	public void addArticle(Article article) {
		Container.articleDao.add(article);	
	}
	
	public void removeArticle(Article foundArticle) {
		Container.articleDao.remove(foundArticle);
	}

	public void modifyArticle(Article foundArticle, String title, String body) {
		Container.articleDao.modify(foundArticle, title, body);
	}

}
