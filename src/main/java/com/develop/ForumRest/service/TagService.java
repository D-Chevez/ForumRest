package com.develop.ForumRest.service;

import com.develop.ForumRest.model.Status;
import com.develop.ForumRest.model.Tag;
import com.develop.ForumRest.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService{

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(Long tagId) {
        Optional<Tag> tagOptional = tagRepository.findById(tagId);
        return tagOptional.orElse(null);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(Long tagId, Tag tagDetails) {
        Tag existingTag = getTagById(tagId);
        if (existingTag != null) {
            // TODO: BUSCAR UNA MEJOR FORMA DE HACERLO
            existingTag.setTagName(tagDetails.getTagName());
            return tagRepository.save(existingTag);
        }
        return null;
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Tag deactivateTag(Long tagId) {
        Tag existingTag = getTagById(tagId);
        if (existingTag != null) {
            existingTag.setStatus(Status.INACTIVE);
            return tagRepository.save(existingTag);
        }
        return null;
    }
}
