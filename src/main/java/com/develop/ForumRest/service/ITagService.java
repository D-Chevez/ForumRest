package com.develop.ForumRest.service;

import com.develop.ForumRest.model.Tag;

import java.util.List;

public interface ITagService {
    Tag createTag(Tag tag);
    Tag getTagById(Long tagId);
    List<Tag> getAllTags();
    Tag updateTag(Long tagId, Tag tagDetails);
    void deleteTag(Long tagId);
    Tag deactivateTag(Long tagId);
}
