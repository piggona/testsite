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

@Controller
public class TweetController {
    @Autowired
    private Twitter twitter;//先注入twitter对象

    @RequestMapping("/twitter")
    public String hello(@RequestParam(defaultValue = "haohaojin's tweet") String search,Model model){
        SearchResults searchResults=twitter.searchOperations().search(search);//使用twitter对象进行搜索操作
        List<Tweet> tweets=searchResults.getTweets();
        model.addAttribute("search",search);
        model.addAttribute("tweets",tweets);
        return "tweet";
    }
}
