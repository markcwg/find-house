package com.study.findhouse.service.impl;

import com.study.findhouse.pojo.House;
import com.study.findhouse.service.HouseService;
import com.study.findhouse.utils.HtmlParserUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author markcwg
 * @email caiwg@sucsoft.com
 * @date 2021/1/20 17:37
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Resource
    private ElasticsearchRestTemplate template;
    @Resource
    private HtmlParserUtils htmlParserUtils;

    @Override
    public Boolean inputData () throws IOException {
        List<House> list = htmlParserUtils.parser();
        template.save(list);
        return true;
    }

    @Override
    public List<House> searchByTitle(String title) {
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(title,"title"))
                .withPageable(PageRequest.of(0,200))
                .withSort(SortBuilders.scoreSort().order(SortOrder.DESC))
                .withHighlightBuilder(new HighlightBuilder().field("title").
                        preTags("<span style='color:red'>").postTags("</span>"))
                .build();
        List<House> result = new ArrayList<>();
        SearchHits<House> search = template.search(query, House.class);
        System.out.println(search);
        search.forEach(o -> {
            result.add(o.getContent());
        });
        return result;
    }

}
