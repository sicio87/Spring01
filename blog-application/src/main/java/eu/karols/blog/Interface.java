package eu.karols.blog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import eu.karols.blog.domain.Article;


public class Interface {

    static Scanner sc = new Scanner(System.in);
    
    static ArticleDAO articleDao = new ArticleDAO();

    public static void main(String[] args) {
    	String userChoice;
    	do {
    		System.out.println();
    		System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
	    	System.out.println("[1] Dodaj nowy artykuł");
	    	System.out.println("[2] Pokaż wszystkie artykuły");
	    	System.out.println("[x] Zakończ");
			userChoice = getUserInput();
	    	if (userChoice.equals("1")) {
	    		addArticle();
	    	} else if (userChoice.equals("2")) {
	    		showArticles();
	    	}
    	} while (!userChoice.equalsIgnoreCase("x"));
        
    }

	private static void showArticles() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######               LISTA ARTYKUŁÓW               ######");
		System.out.println("#########################################################");
		
		Article article;
		for (int i=0; i<articleDao.getArticles().size(); i++) {
			article = articleDao.getArticles().get(i);
			System.out.println(i + ": " + article.getTitle());
		}
		System.out.println();
		Pattern numberPattern = Pattern.compile("[0-9]+");
		String numberLoaded;
		do {
			System.out.print("Informację, o którym artykule chcesz zobaczyć? ");
			numberLoaded = getUserInput();
		} while (!numberPattern.matcher(numberLoaded).matches());
		
		Integer numberArticle = Integer.parseInt(numberLoaded);
		if (articleDao.getArticles().size()>numberArticle) {
			Article choiceArticle = articleDao.getArticles().get(numberArticle);
			System.out.println("Tytuł wybranego artykułu to  "+choiceArticle.getTitle()+", kategoria "+choiceArticle.getCategory()+", data publikacji "+choiceArticle.getPublicationDate().toString()+", autor: "+choiceArticle.getAuthor());
		} else {
			System.out.println("Niestety, nie znalazłem artykułu o wybranym numerze :( Sprobój ponownie lub go dodaj!");
		}
	}

	private static void addArticle() {
		System.out.println();
		System.out.println("#########################################################");
		System.out.println("######               DODAJ  ARTYKUŁ                ######");
		System.out.println("#########################################################");
		Article article = new Article();
		System.out.print("Podaj tytuł Artykułu: ");
        article.setTitle(getUserInput());

        Pattern datePattern = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String publicationDateLoaded;
        do {
            System.out.print("Podaj datę publikacji w formacie RRRR.MM.DD: ");
            publicationDateLoaded = getUserInput();
            if (datePattern.matcher(publicationDateLoaded).matches()) {
            	try {
            		article.setPublicationDate(sdf.parse(publicationDateLoaded));
            	} catch (ParseException pe) {
            		System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
            	}
            }
        } while (article.getPublicationDate()==null);
        
        System.out.print("Podaj kategorię artykułu: ");
        article.setCategory(getUserInput());

        articleDao.addArticle(article);


        System.out.print("Podaj kto jest autorem artykułu: ");
        article.setAuthor(getUserInput());

        articleDao.addArticle(article);
        
        System.out.println("Dziękuję, teraz wiem o artykule prawie wszystko! Dodałem bo do naszego zbioru.");
	}

    public static String getUserInput() {
        return sc.nextLine().trim();
    }
}
