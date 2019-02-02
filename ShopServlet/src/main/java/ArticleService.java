import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

public class ArticleService {


    private Collection<Article> avialableArticles = Arrays.asList(
            new Article(1, "Piwo", new BigDecimal(2.56)),
            new Article(2, "Kiełba", new BigDecimal(4.50)),
            new Article(3, "Karczek", new BigDecimal(7.89)),
            new Article(4, "Węgiel", new BigDecimal(12.0))

    );


    public Collection<Article> getAvialableArticles() {
        return avialableArticles;
    }

    public void setAvialableArticles(Collection<Article> avialableArticles) {
        this.avialableArticles = avialableArticles;
    }

//    public Article findArticleById (Collection<Article> articles, Integer id) {
//        articles.stream()
//    }


}
