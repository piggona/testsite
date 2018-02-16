package com.kevinmvc.testsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TweetController {
    @Autowired
    private Twitter twitter;//先注入twitter对象

    @RequestMapping("/twitter")
    public String hello(@RequestParam(defaultValue = "haohaojin's tweet") String search,Model model){
        SearchResults searchResults=twitter.searchOperations().search(search);//使用twitter对象进行搜索操作
        List<String> tweets=searchResults.getTweets().//获取搜索到的结果（是一个集合）
                stream().//集合默认包含的方法，为了对它进行函数式操作（操作可以是中间操作-返回一个流，也可以是终止操作-返回一个值）
                map(Tweet::getText)./*中间操作有  map:为列表中每个元素都应用某个方法。filter:会返回匹配断言的所有元素。
                                    reduce：借助一个操作和累加器将列表中的所有值聚合到单个值上*/
                collect(Collectors.toList());//终止操作 Collectors.toList()说明会产生一个列表，包含流中每一个元素
        model.addAttribute("tweets",tweets);
        return "tweet";
    }
}
