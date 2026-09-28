package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.OptionRequest;
import com.example.onlineexamination.entity.Option;
import com.example.onlineexamination.entity.Question;
import com.example.onlineexamination.repository.OptionRepository;
import com.example.onlineexamination.repository.QuestionRepository;
import com.example.onlineexamination.service.OptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;
    private final QuestionRepository questionRepository;

    public OptionServiceImpl(OptionRepository optionRepository,
                             QuestionRepository questionRepository) {
        this.optionRepository = optionRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Option createOption(OptionRequest request) {

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Option option = new Option();
        option.setOptionText(request.getOptionText());
        option.setCorrect(request.getCorrect());
        option.setQuestion(question);

        return optionRepository.save(option);
    }

    @Override
    public List<Option> getOptionsByQuestion(Long questionId) {
        return optionRepository.findAll()
                .stream()
                .filter(o -> o.getQuestion().getId().equals(questionId))
                .toList();
    }
}