package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.OptionRequest;
import com.example.onlineexamination.entity.Option;
import java.util.List;

public interface OptionService {

    Option createOption(OptionRequest request);

    List<Option> getOptionsByQuestion(Long questionId);
}