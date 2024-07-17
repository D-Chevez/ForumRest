package com.develop.ForumRest.service;

import com.develop.ForumRest.model.Reply;

import java.util.List;

public interface IReplyService {
    Reply createReply(Reply reply);
    Reply getReplyById(Long replyId);
    List<Reply> getAllReplys();
    Reply updateReply(Long replyId, Reply replyDetails);
    void deleteReply(Long replyId);
}
