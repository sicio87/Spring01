package eu.karols.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eu.karols.blog.domain.Article;
@Repository
public class ArticleDAO {

	List<Article> articles = new ArrayList<Article>();
	
	public void addArticle(Article article) {
		articles.add(article);
	}
	public void deleteArticle(Article article) {
		articles.remove(article);
	}
	public void deleteArticle(Integer article) {
		articles.remove(0);
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public Article getArticleById(Integer id) {
		if (id<articles.size()) {
			return articles.get(id);
		} else {
			return null;
		}
	}
	
}
