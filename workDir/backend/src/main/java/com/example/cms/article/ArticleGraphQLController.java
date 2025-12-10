package com.example.cms.article;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ArticleGraphQLController {

    private final ArticleRepository repository;

    public ArticleGraphQLController(ArticleRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public List<Article> articles() {
        return repository.findAll();
    }

    @MutationMapping
    public Article createArticle(
            @Argument String title,
            @Argument String content,
            @Argument boolean published
    ) {
        Article article = new Article(title, content, published);
        return repository.save(article);
    }
}
