package eu.karols.blog.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.karols.blog.ArticleDAO;
import eu.karols.blog.domain.Article;
import eu.karols.blog.dto.ArticleDTO;

@Controller
public class BlogController {
	@Autowired
	ArticleDAO dao;
	@RequestMapping("/lista")
	public String listArticles(Model model) {
		model.addAttribute("articles", dao.getArticles());
		return "lista";
	}
	
	@RequestMapping("/dodaj")
	public String addArticle(HttpServletRequest request,  @ModelAttribute("articleDto") @Valid ArticleDTO articleDto, BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
			Article article = new Article();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				article.setPublicationDate(sdf.parse(articleDto.getPublicationDate()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			article.setTitle(articleDto.getTitle());
			article.setAuthor(articleDto.getAuthor());
			article.setCategory(articleDto.getCategory());
			dao.addArticle(article);
			return "redirect:/lista";
		}
		return "dodaj";
	}
	
	@RequestMapping("/article-{id}")
	public String detailsArticle(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("article", dao.getArticleById(id));
		return "szczegoly";
	}
	
	@RequestMapping("/przyklad")
	public String przykladModelu(Model model) {
		model.addAttribute("message", "To jest jakaś super informacja");
		return "glowny";
	}

}
