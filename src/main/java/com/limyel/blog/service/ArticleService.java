package com.limyel.blog.service;

import com.limyel.blog.dao.ArticleRepository;
import com.limyel.blog.model.dto.PostListDTO;
import com.limyel.blog.model.entity.ArticleEntity;
import com.limyel.blog.model.vo.ArticleListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleListVO list(PostListDTO dto) {
        LocalDateTime startTime = LocalDateTime.of(dto.getYear(), 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(dto.getYear(), 12, 31, 23, 59);
        List<ArticleEntity> articles = articleRepository.findByCreateTimeBetweenOrderByCreateTimeDesc(startTime, endTime);

        ArticleListVO result = new ArticleListVO();
        result.setYear(dto.getYear());

        Map<Integer, List<ArticleListVO.Article>> map = new HashMap<>();
        articles.forEach(item -> {
            Integer month = item.getCreateTime().getMonthValue();
            List<ArticleListVO.Article> list = map.computeIfAbsent(month, k -> new ArrayList<>());

            ArticleListVO.Article article = new ArticleListVO.Article();
            article.setTitle(item.getTitle());
            article.setSlug(item.getSlug());
            article.setCreateTime(getCreateTime(item.getCreateTime()));

            list.add(article);
        });

        List<ArticleListVO.ArticleListItem> list = new ArrayList<>();
        for (Map.Entry<Integer, List<ArticleListVO.Article>> entry : map.entrySet()) {
            ArticleListVO.ArticleListItem articleListItem = new ArticleListVO.ArticleListItem();
            articleListItem.setMonthNum(entry.getKey());
            articleListItem.setMonth(getMonth(entry.getKey()));
            articleListItem.setArticles(entry.getValue());
            list.add(articleListItem);
        }
        list = list.stream()
                .sorted(Comparator.comparing(ArticleListVO.ArticleListItem::getMonthNum).reversed())
                .toList();
        result.setList(list);

        return result;
    }

    private String getMonth(Integer monthValue) {
        return switch (monthValue) {
            case 1 -> "一月";
            case 2 -> "二月";
            case 3 -> "三月";
            case 4 -> "四月";
            case 5 -> "五月";
            case 6 -> "六月";
            case 7 -> "七月";
            case 8 -> "八月";
            case 9 -> "九月";
            case 10 -> "十月";
            case 11 -> "十一月";
            case 12 -> "十二月";
            default -> null;
        };
    }

    private String getCreateTime(LocalDateTime time) {
        return time.getMonthValue() + "-" + time.getDayOfMonth();
    }

}
