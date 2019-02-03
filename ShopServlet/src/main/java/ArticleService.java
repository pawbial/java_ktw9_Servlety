import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class ArticleService {


    public Collection<Article> avialableArticles = Arrays.asList(
            new Article(1, "Piwo", new BigDecimal(2.56)),
            new Article(2, "Kielba", new BigDecimal(4.50)),
            new Article(3, "Karczek", new BigDecimal(7.89)),
            new Article(4, "Wegiel", new BigDecimal(12.0))

    );


    public Collection<Article> getAvialableArticles() {
        return avialableArticles;
    }

    public void setAvialableArticles(Collection<Article> avialableArticles) {
        this.avialableArticles = avialableArticles;
    }

    public Optional<Article> findArticleById (Collection<Article> articles, Integer id) {
        return articles.stream().filter(article -> id.equals(article.getId())).findFirst();


    }


//    public static void main(String[] args) {
//
//        ArticleService articleService = new ArticleService();
//
//        Collection<Article> avialableArticles = Arrays.asList(
//                new Article(1, "Piwo", new BigDecimal(2.56)),
//                new Article(2, "Kiełba", new BigDecimal(4.50)),
//                new Article(3, "Karczek", new BigDecimal(7.89)),
//                new Article(4, "Węgiel", new BigDecimal(12.0))
//
//        );
//
//        Optional<Article> articleById = articleService.findArticleById(avialableArticles, 3);
//
//        System.out.println(articleById);
//    }


}
