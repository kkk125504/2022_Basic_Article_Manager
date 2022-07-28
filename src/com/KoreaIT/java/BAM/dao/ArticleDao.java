package com.KoreaIT.java.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.dto.Member;

public class ArticleDao extends Dao {
	private List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId++;
	}

	public void remove(Article foundArticle) {
		articles.remove(foundArticle);

	}

	public void modify(Article foundArticle, String title, String body) {
		foundArticle.title = title;
		foundArticle.body = body;
	}

	public List<Article> getArticles(String searchKeyword) {
		if (searchKeyword != null && searchKeyword.length() != 0) {

			List<Article> forPrintArticles = new ArrayList<>();

			if (searchKeyword.length() > 0) {

				for (Article article : articles) {
					if (article.title.contains(searchKeyword)) {
						forPrintArticles.add(article);
					}
				}

			}
			return forPrintArticles;
		}
		return articles;
	}

	public Article getArticleById(int id) {
		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	private int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {

			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
